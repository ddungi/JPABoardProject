package com.fastcampus.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.User;
import com.bank.dto.UserDto;
import com.bank.persistence.UserRepository;
import com.bank.service.UserService;

@Transactional
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private ModelMapper modelMapper;
	

	private UserDto createduserDto() {	
		return UserDto.builder()
				.id(2)
				.username("bbb")
				.password("bbb")
				.email("bbb")
				.build();
	}
	
	private User createduser() {	
		return User.builder()
				.id(2)
				.username("bbb")
				.password("bbb")
				.email("bbb")
				.build();
	}
	
	
	@DisplayName("회원가입 서비스")
	@Test
	void insertUser() {
		
		//given
		 UserDto userDto = createduserDto();
		 User user = createduser();
		// 아래코드랑 같은 코드, doReturn은 타입체킹을 하지 않아 자유도가 높지만 그만큼 안정성이 낮다.
		//런타임시 타입 다르면 예외발생(WrongTypeOfReturnValue)한다.
		
		when(modelMapper.map(any(UserDto.class), eq(User.class))).thenReturn(user);
		when(userRepository.save(user)).thenReturn(user);
		
		//when
		userService.insertUser(userDto);
		
		//then
		verify(userRepository, times(1)).save(user);
	}
	
	@DisplayName("회원 상세 조회")
	@Test
	void getUser() {
		//given
		User user = createduser();
		UserDto userDto =createduserDto();
		when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(user));
		when(modelMapper.map(eq(user), eq(UserDto.class))).thenReturn(userDto);
				
		//when
		UserDto findUser = userService.getUser(user.getUsername());
		
		//then
		assertThat(userDto).isEqualTo(findUser);
		
	}
	
}
