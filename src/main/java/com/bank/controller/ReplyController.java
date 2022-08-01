package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.dto.ReplyDto;
import com.bank.security.jpa.UserDetailsImpl;
import com.bank.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	//댓글 등록
	@PostMapping("/reply/{id}")
	@ResponseBody
	public String insertReply(@RequestBody ReplyDto replyDto,
			@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable int id) {
		replyService.insertReply(replyDto, userDetails, id);
		return "댓글 등록이 완료되었습니다.";
	}
	
	//댓글 삭제
	@DeleteMapping("/reply/{seq}")
	@ResponseBody
	public String deleteReply(@PathVariable int seq) {
		replyService.deleteReply(seq);
		return "댓글 삭제가 완료되었습니다.";
	}
	
}
