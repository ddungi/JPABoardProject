package com.bank.controller;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.dto.PostDto;
import com.bank.security.jpa.UserDetailsImpl;
import com.bank.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// 메인페이지 이동
	@GetMapping({"", "/"})
	public String getPostList(Model model, 
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("postList", postService.getPostList(pageable));
		return "welcome";
	}
	
	//포스트 등록페이지 이동
	@GetMapping("/post")
	public String insertPost() {
		return "post/insertPost";
	}
	
	//포스트 등록
	@PostMapping("/post")
	public @ResponseBody String insertPost(@RequestBody PostDto postDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) {
		postService.insertPost(postDto,userDetails);
		return "새로운 1:1 문의를 등록했습니다.";
	}

	//포스트 상세 조회
	@GetMapping("/posts/{id}")
	public String getBoard(@PathVariable int id, Model model) {
		model.addAttribute("post" ,postService.getPost(id));
		model.addAttribute("replyList", postService.getPost(id).getReplies());
		return "post/getPost";
	}
	
	//포스트 수정 화면으로 이동
	@GetMapping("/post/{id}")
	public String updatePost(@PathVariable int id, Model model) {
		model.addAttribute("post" ,postService.getPost(id));
		return "post/updatePost";
	}
	
	//수정하고 메인 화면으로 이동
	@PutMapping("/post")
	@ResponseBody
	public String updatePost(@RequestBody PostDto postDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		postService.updatePost(postDto, userDetails);
		return "수정이 완료되었습니다. ";
	}
	
	//포스트 삭제
	@DeleteMapping("/post/{id}")
	@ResponseBody
	public String deletePost(@PathVariable int id) {
		postService.deletePost(id);
		return "삭제가 완료되었습니다.";
	}
}










