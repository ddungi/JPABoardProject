package com.fastcampus.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.User;
import com.fastcampus.dto.UserDto;
import com.fastcampus.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//회원가입
	@Transactional
	public void insertUser(UserDto userDto) {
		userDto.setRole("USER");
		User user = modelMapper.map(userDto, User.class);
		userRepository.save(user);
	}
	
	//회원 상세 조회
	@Transactional(readOnly = true)
	public UserDto getUser(String username) {	
		Optional<User> findUser = userRepository.findByUsername(username);
		if(findUser.isPresent()) {
			UserDto userDto = modelMapper.map(findUser.get(), UserDto.class);
			return userDto;
		}
		return new UserDto();		
	}

}
