package com.fastcampus.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	
	private int id; // 회원 일련번호
	private String username; // 아이디
	private String password; // 비밀번호
	private String email; // 이메일
	private String role;
	private Timestamp createDate; // 계정 생성 날짜
	
	private List<Post> posts; //계정이 작성한 포스트들
	
	private List<Reply> replies; //계정이 단 댓글
	
	@Builder //테스트를 위한 빌더  생성
	public UserDto(int id, String username, String password, String email) {
		this.id=id;
		this.username=username;
		this.password=password;
		this.email=email;
	}
	

}








