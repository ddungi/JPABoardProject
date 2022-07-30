package com.bank.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "USERS")
@Entity
public class User {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 회원 일련번호
	private String username; // 아이디
	private String password; // 비밀번호
	private String email; // 이메일
	private String role;
	@CreationTimestamp 
	private Timestamp createDate; // 계정 생성 날짜
	
	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Post> posts; //계정이 작성한 포스트들
	
	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
	private List<Reply> replies; //계정이 단 댓글
	
	@Builder //테스트를 위한 빌더  생성
	public User(int id, String username, String password, String email) {
		this.id=id;
		this.username=username;
		this.password=password;
		this.email=email;
	}
	

}








