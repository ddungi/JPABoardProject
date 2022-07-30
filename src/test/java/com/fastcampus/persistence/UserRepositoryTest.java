package com.fastcampus.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bank.domain.User;
import com.bank.persistence.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
		
	@Autowired
	private UserRepository userRepository;
	
	@DisplayName("회원가입")
	@Test
	void insertUser() {
		
		//given
		User user = User.builder()
				.id(1)
				.username("imbc")
				.password("1234")
				.email("imbc@naver.com")
				.build();
		
		//when
		User inserted = userRepository.save(user);
		
		//then
		assertEquals(inserted.getId(), user.getId());
		assertEquals(inserted.getUsername(), user.getUsername());
		assertEquals(inserted.getPassword(), user.getPassword());
		assertEquals(inserted.getEmail(), user.getEmail());
	}
	
	@DisplayName("유저 이름으로 상세 조회")
	@Test
	void findByUsername() {
		//given
		User user = User.builder()
				.id(3)
				.username("imbc")
				.password("1234")
				.email("imbc@naver.com")
				.build();
		//when
		User saved= userRepository.save(user);
		Optional<User> found = userRepository.findByUsername(user.getUsername());
		
		//then
		assertThat(found.get()).isEqualTo(saved);
	}
	
}
