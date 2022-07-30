package com.fastcampus.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq; //댓글 일련번호
	
	@Column(nullable=false, length=200 )
	private String content; //댓글 내용
	
	@CreationTimestamp 
	private Timestamp createDate; //댓글 생성 날짜

	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user; //누가 작성했는지
	
	@ManyToOne
	@JoinColumn(name = "POST_ID") 
	private Post post; //댓글은 어떤 포스트에 속해있는지
	
}
