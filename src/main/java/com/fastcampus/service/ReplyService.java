package com.fastcampus.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Reply;
import com.fastcampus.dto.ReplyDto;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.persistence.ReplyRepository;
import com.fastcampus.security.jpa.UserDetailsImpl;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//댓글 입력  
	@Transactional
	public void insertReply( ReplyDto replyDto, UserDetailsImpl userDetails,int id) {
		Reply reply = modelMapper.map(replyDto, Reply.class); 
		reply.setPost(postRepository.findById(id).get());
		reply.setUser(userDetails.getUser());
		replyRepository.save(reply);
	}
	 
	//댓글 삭제
	@Transactional
	public void deleteReply(int seq) {
		replyRepository.deleteById(seq);
	}
}
