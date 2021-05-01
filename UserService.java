package com.cg.onlineadvapi.service;

import com.cg.onlineadvapi.domain.User;

public interface UserService {

	User saveOrUpdateUser(User user);
	public void deleteById(Integer user_id);
	


}
