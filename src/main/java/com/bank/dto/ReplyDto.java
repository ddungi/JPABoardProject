package com.bank.dto;

import java.sql.Timestamp;

import com.bank.domain.Post;
import com.bank.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyDto {
	
	private int seq; //댓글 일련번호
	
	private String content; //댓글 내용
	
	private Timestamp createDate; //댓글 생성 날짜

	private User user; //누가 작성했는지
	
	private Post post; //댓글은 어떤 포스트에 속해있는지
	
}
