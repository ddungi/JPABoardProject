package com.fastcampus.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fastcampus.domain.User;
import com.fastcampus.dto.UserDto;
import com.fastcampus.service.UserService;
import com.google.gson.Gson;
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers =UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
//	@InjectMocks
//	private UserController	userController;
//	
//	@Mock
//	private UserService userService;
	
//	private MockMvc mockMvc;

	
	private UserDto insertUserRequest() {
		return UserDto.builder()
				.id(2)
				.username("test")
				.password("test123")
				.email("test@test")
				.build();
				
	}
	
	@DisplayName("회원 가입")
	@Test
	void insertUserTest() throws Exception {
		//given
		UserDto request = insertUserRequest();
		when(userService.getUser(any(String.class))).thenReturn(new UserDto());
		doNothing().when(userService).insertUser(any(UserDto.class));
		
		//when
		mockMvc.perform(post("/auth/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new Gson().toJson(request))
			)
		//then
		//.andExpect(status().isOk())
		.andExpect(content().string(request.getUsername()+ " 회원 가입 성공"));
				
	}

}
