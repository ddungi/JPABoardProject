package com.fastcampus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Post;
import com.fastcampus.dto.PostDto;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.security.jpa.UserDetailsImpl;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//포스트 저장
	@Transactional
	public void insertPost(PostDto postDto, UserDetailsImpl userDetails) {
		Post post = modelMapper.map(postDto, Post.class);
		post.setUser(userDetails.getUser());
		postRepository.save(post);
	}
	
	//포스트 업데이트
	@Transactional
	public void updatePost(PostDto postDto, UserDetailsImpl userDetails) {
		Post post = modelMapper.map(postDto, Post.class);
		post.setUser(userDetails.getUser());
		postRepository.save(post);
	}
	
	//포스트 목록 조회
	@Transactional(readOnly=true)
	public Page<PostDto> getPostList(Pageable pageable) {
		Page<Post> postList = postRepository.findAll(pageable);
		List<PostDto> postDtoList = postList.stream().map(post -> modelMapper.map(post, PostDto.class))
													 .collect(Collectors.toList());
		PageImpl<PostDto> postDtoPages = new PageImpl<>(postDtoList, pageable, postList.getTotalElements());
		return postDtoPages;
	}
	
	//포스트 상세 조회
	@Transactional(readOnly=true)
	public PostDto getPost(int id) {
		Optional<Post> post=postRepository.findById(id);
		if(post.isPresent()) {
			PostDto postDto = modelMapper.map(post.get(), PostDto.class);
			return postDto;
		}
		return new PostDto();
		
	}
	
	//포스트 삭제
	@Transactional
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

}
