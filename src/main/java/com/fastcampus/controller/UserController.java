package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.dto.UserDto;
import com.fastcampus.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	//private UserDetailsServiceImpl userService;

	// 로그인 화면으로 이동
	@GetMapping("/auth/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {
		model.addAttribute("error",error);
		model.addAttribute("exception",exception);
		return "system/login";
	}

	// 회원가입 화면으로 이동
	@GetMapping("/auth/user")
	public String insertUser() {
		return "user/insertUser";
	}

	// 회원 가입 처리
	@PostMapping("/auth/user")
	@ResponseBody
	public String insertUser(@RequestBody UserDto userDto) {
		// username으로 등록된 회원 검사
		UserDto findUser = userService.getUser(userDto.getUsername());

		if (findUser.getUsername() == null) {
			userDto.setRole("USER");
			userService.insertUser(userDto);
			return userDto.getUsername() + " 회원 가입 성공";
		} else {
			return userDto.getUsername() + " 아이디는 이미 존재합니다";
		}
	}

	// 회원 상세 조회
	@GetMapping("/user/{username}")
	public String getUser(@PathVariable String username, Model model) {
		model.addAttribute("user", userService.getUser(username));
		return "user/getUser";
	}

}
