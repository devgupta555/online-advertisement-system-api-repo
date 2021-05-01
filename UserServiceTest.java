package com.cg.onlineadvertisementsystem.UserServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlineadvapi.domain.User;
import com.cg.onlineadvapi.repository.UserRepository;
import com.cg.onlineadvapi.serviceImpl.UserServiceImpl;
/**
 * 
 * @author bmanikch
 *
 */
public class UserServiceTest {
	
	@Mock //- mock bean
	private UserRepository userRepository;
	
	@Autowired
	@InjectMocks // mock bean injection
	private UserServiceImpl userServiceImpl;
	// stubs
	private User firstUser;
	private User secondUser;
	private User user;
	private User user1; 

	@BeforeEach
	public void setUp() {
	user=new User();
	MockitoAnnotations.initMocks(this); //invoke mock
	user1=new User(1,"Dev","DEVGUPTA","dev@cgmail.com","1234567890");
	firstUser=new User(2,"Bipin","bkori","9098987898","b.kori@gmail.com");
	}
	
	@AfterEach
	public void tearDown() {
	userRepository.deleteAll();
	firstUser = secondUser = null;
	}
	
	@Test
	public void test_saveOrUpdateUser_GivenUser_ShouldReturnSavedUser(){
	//firstUser=new User("Bipin","bkori","9098987898","b.kori@gmail.com");
	BDDMockito.given(userRepository.save(user))
	.willReturn(firstUser);
	secondUser = userServiceImpl.saveOrUpdateUser(user);
	assertNotNull(secondUser);
	assertEquals("Bipin",secondUser.getname());
	assertEquals("bkori",secondUser.getLoginName());
	assertEquals("b.kori@gmail.com",secondUser.getEmail());
	assertEquals("9098987898",secondUser.getContactNo());
	}
	
	@Test
	public void test_saveOrUpdateUser_GivenUser_ShouldReturnUpdatedUser(){
	//firstUser=new User("Bipin","bkori","9098987898","b.kori@gmail.com");
	firstUser.setname("Dev");
	BDDMockito.given(userRepository.save(user))
	.willReturn(firstUser);
	secondUser = userServiceImpl.saveOrUpdateUser(user);
	assertNotNull(secondUser);
	assertEquals("Dev",secondUser.getname());
	assertEquals("bkori",secondUser.getLoginName());
	assertEquals("b.kori@gmail.com",secondUser.getEmail());
	assertEquals("9098987898",secondUser.getContactNo());
	}
	
	@Test
	public void test_deleteUserByUserId_GivenUserId_ShouldDeleteUserById() {
	
	userServiceImpl.deleteById(user.getUserId());
	verify(userRepository).deleteById(user.getUserId());
	System.out.println(user.getUserId());
	assertNull(user.getUserId());
	assertNull(user.getname());
	assertNull(user.getLoginName());
	assertNull(user.getEmail());
	
	}
	 
	
	
}
