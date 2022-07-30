package com.fastcampus.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //포스트 일련번호
	
	@Column(nullable = false, length = 100)
	private String title; //제목
	
	@Lob // 아주 긴 문자데이터(GB)를 저장할 수 있는 설정
	@Column(nullable = false)
	private String content; //컨텐츠 내용
	
	@CreationTimestamp 
	private Timestamp createDate; //작성 날짜
	
	@ManyToOne
	@JoinColumn(name = "USER_ID") // FK
	private User user; //누가 작성했는지
	
	//cascade 설정을 통해 post 객체 제거시 댓글 리스트 제거
	@OneToMany(mappedBy="post", cascade=CascadeType.REMOVE)
	private List<Reply> replies; //댓글리스트

	
}








