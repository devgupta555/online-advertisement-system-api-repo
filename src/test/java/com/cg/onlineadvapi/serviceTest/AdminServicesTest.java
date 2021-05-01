package com.cg.onlineadvapi.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.domain.Category;
import com.cg.onlineadvapi.repository.AdvertiseRepository;
import com.cg.onlineadvapi.repository.UserRepository;
import com.cg.onlineadvapi.service.AdminService;
import com.cg.onlineadvapi.serviceImpl.AdminServiceImpl;
import com.cg.onlineadvapi.web.CategoryController;

@SpringBootTest
class AdminServicesTest {
	
	@Mock 
    private AdvertiseRepository advertiseRepository;
	@Mock
	private UserRepository userRepository;
	
	
    @InjectMocks 
    private AdminServiceImpl adminServiceImpl; 
   
    @BeforeEach
    public void initMocks() {
    	MockitoAnnotations.initMocks(this);  
 }
    
   
	private Advertise demoAdvertise;
    List<Advertise> advertiseList1;
    List<Advertise> advertiseList2;
    
   
	
	
	@Test
	void test_viewAdvertisementByUser_GivenCorrectUserId_ShouldReturnAdvertisementList() {
		
		
		advertiseList1 = new ArrayList<>();
    	advertiseList2=new ArrayList<>();
		advertiseList1.add(new Advertise(1, "1", "1", 1d, "1", "1"));
		
		
		BDDMockito.given(advertiseRepository.viewAdvertisementByUser(0))
    	.willReturn(advertiseList1);
    	
    	advertiseList2 = (List<Advertise>) adminServiceImpl.viewAdvertisementByUser(0).getBody();
    	
    	assertEquals(advertiseList1, advertiseList2);}
	
	@Test
	void test_viewAdvertisementByUser_GivenIncorrectUserId_ShouldReturnErrorMessage() { 
		
		
		advertiseList1 = new ArrayList<>();
    	advertiseList2=new ArrayList<>();
    	
    	
		BDDMockito.given(advertiseRepository.viewAdvertisementByUser(0))
    	.willReturn(advertiseList1);
		
		String errorMessage = (String) adminServiceImpl.viewAdvertisementByUser(0).getBody();
		
		assertEquals("No advertisement found for inputed user ID", errorMessage);}
	
	@Test
	void test_deleteAdvertise_GivenCorrectAdvertisementId_ShouldReturDeletionErrorMessage() {
		
		BDDMockito.doThrow(new IllegalArgumentException("")).when(advertiseRepository).
				deleteById(0);
		
		String message=adminServiceImpl.deleteAdvertise(0);
		
		assertEquals("AdvertisementId not found", message);
	}
	
	@Test
	void test_deleteAdvertise_GivenCorrectAdvertisementId_ShouldReturnDeletionSuccessfulMessage() {
		
		
		BDDMockito.doNothing().when(advertiseRepository).deleteById(0);
		
		String message=adminServiceImpl.deleteAdvertise(0);
		
		assertEquals("Advertisement deleted Successfully", message);
	}
	
	@Test
	void test_deleteUser_GivenCorrectUserId_ShouldReturnDeletionErrorMessage() {
		
		BDDMockito.doThrow(new IllegalArgumentException("")).when(userRepository).
		deleteById(0);

		String message=adminServiceImpl.deleteUser(0);

		assertEquals("UserId not found", message);
	}
	
	@Test
	void test_deleteUser_GivenCorrectUserId_ShouldReturnDeletionSuccessfulMessage() { 
		
		BDDMockito.doNothing().when(userRepository).deleteById(0);
		
		String message=adminServiceImpl.deleteUser(0);
		
		assertEquals("User Deleted Successfully", message);
		}
	
	

}
