package com.cg.onlineadvapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineadvapi.domain.User;
import com.cg.onlineadvapi.repository.UserRepository;
import com.cg.onlineadvapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public void deleteById(Integer user_id) {
		userRepository.deleteById(user_id);
		
	}
	

	

	

}
