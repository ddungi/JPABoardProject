package com.bank.Service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.User;
import com.bank.dto.UserDto;
import com.bank.persistence.UserRepository;
import com.bank.service.UserService;

@SpringBootTest
@Transactional
//@AutoConfigureWebMvc //MockMvc 를  builder 없이 주입받을 수 있음
public class UserServiceIntegrationTest {
	
	@Autowired
	UserService userService; //실제로 서비스 객체를 주입받아 테스트
	
	@Autowired
	UserRepository userRepository; //실제로 레포지토리 객체를 주입받아 테스트
	
	@Test
	@DisplayName("회원가입 테스트")
	void insertUserTest() throws Exception{
		//given
		UserDto userDto = UserDto.builder()
				.id(2)
				.username("bbb")
				.password("bbb")
				.email("bbb")
				.build();
		//when
		userService.insertUser(userDto);
		
		//then
		User findUser = userRepository.findByUsername("bbb").get();
		assertThat(userDto.getId()).isEqualTo(findUser.getId());
		assertThat(userDto.getPassword()).isEqualTo(findUser.getPassword());
		assertThat(userDto.getEmail()).isEqualTo(findUser.getEmail());
		
	}
}
