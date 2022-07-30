package com.bank.dto;

import java.sql.Timestamp;
import java.util.List;

import com.bank.domain.Reply;
import com.bank.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {
	private int id; //포스트 일련번호
	
	private String title; //제목
	
	private String content; //컨텐츠 내용
	
	private Timestamp createDate; //작성 날짜
	
	private User user; //누가 작성했는지
	
	private List<Reply> replies; //댓글리스트
}








