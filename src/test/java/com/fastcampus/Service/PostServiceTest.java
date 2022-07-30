package com.fastcampus.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Post;
import com.fastcampus.dto.PostDto;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.service.PostService;


@Transactional
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
	
	@InjectMocks
	private PostService postService; //테스트할, 주입받을 서비스 객체 선언
	
	@Mock
	private PostRepository postRepository; //포스트 서비스에 주입할 mock 객체 선언
		
	@Mock
	private ModelMapper modelMapper;
	
	private Post createPost(int id, String title, String content ) {
		Post post = new Post();
		post.setId(id);
		post.setContent(content);
		post.setTitle(title);
		return post;
	}  //post 객체 생성 메소드
	
	private PostDto createPostDto(int id, String title, String content ) {
		PostDto postDto = new PostDto();
		postDto.setId(id);
		postDto.setContent(content);
		postDto.setTitle(title);
		return postDto;
	}  //post 객체 생성 메소드
	
	
	@DisplayName("포스트 목록 조회")
	@Test
	void getPostListTest() {
		
		//given
		 List<Post> posts = new ArrayList<>();  // 10개의 포스트 리스트 객체 생성
		for (int i = 1; i < 11; i++) {
			Post post = createPost(i, "title"+i, "content"+i );
			posts.add(post);
		}

		//ModelMapper modelMapper = new ModelMapper();//엔티티 객체>DTO
		
		PageRequest pageable = PageRequest.of(0, 3); //PageRequest로 pageable 객체 생성
		
		PageImpl<Post> postPages = new PageImpl<>(posts, pageable, posts.size());  //posts 객체 page 객체로 변환
		
		when(postRepository.findAll(any(PageRequest.class))).thenReturn(postPages);
		when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(new PostDto());
		
		// 레포지토리 역할 선언(pageable 객체를 통해 findAll 메소드를 찾으면 postPages 객체를 리턴해주세요)
			
		//when
		//포스트 목록 조회 서비스와 같은 로직으로 생성
		Page<PostDto> postDtoPages = postService.getPostList(pageable);
		 
		
		//then
		assertThat(postPages.getSize()).isEqualTo(postDtoPages.getSize());  //포스트 서비스와 입력한 값이 같은지 확인하는 단정문
	}
	
	@DisplayName("포스트 상세 조회")
	@Test
	void getPostTest() {
		//given
		Post post =createPost(5, "test", "test and test");  //id가 5인 객체 생성
		PostDto postDto = createPostDto(5, "test", "test and test");
		
		Optional<Post> test =Optional.of(post); //postRepository.findById(id)의 리턴값이 Optional이므로 객체 타입 변경
		
		int id=5;
		when(postRepository.findById(id)).thenReturn(test); //postRepository.findById(id) 사용하면 test 객체 리턴해주세요
		when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);
		
		//when
		PostDto result = postService.getPost(id); //포스트 서비스  객체가 id로 조회할 때
		
		//then
		assertThat(postDto).isEqualTo(result);  //같은 객체인지 확인하는 단정문
	
	}
	
}
