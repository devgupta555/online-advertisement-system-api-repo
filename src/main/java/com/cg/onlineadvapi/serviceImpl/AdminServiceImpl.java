package com.cg.onlineadvapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.domain.Category;
import com.cg.onlineadvapi.domain.User;
import com.cg.onlineadvapi.domain.User;
import com.cg.onlineadvapi.repository.AdvertiseRepository;
import com.cg.onlineadvapi.repository.CategoryRepository;
import com.cg.onlineadvapi.repository.UserRepository;
import com.cg.onlineadvapi.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdvertiseRepository advertiseRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveOrUpdateCategory(Category category) {
		// Method to Save/Update Category in database
		return categoryRepository.save(category);
	}

	@Override
	public List<User> viewUserList() {
		// Method to return list of all users, null if no users found.
		return userRepository.findAll();
	}

	@Override
	public User viewUser(int userId) {
		// Returns user by UserId or null if not found
		return userRepository.findById(userId).orElse(new User());
	}

	@Override
	public String deleteUser(int userId) {
		// delete User using UserId
		try{userRepository.deleteById(userId);}
		catch(Exception e) {
			return("UserId not found");} //if user id not found, error message is returned 
		return "User Deleted Successfully";	//if user id found, successful execution message is returned
	}

	@Override
	public ResponseEntity<Object> viewAdvertisementByUser(int userId) {
		// Fetching Advertisement uploaded by specific user using UserId
		
		List<Advertise> fetchedData=advertiseRepository.viewAdvertisementByUser(userId);
		if(fetchedData.isEmpty())
			return ResponseEntity.accepted().body("No advertisement found for inputed user ID");
		
		return ResponseEntity.accepted().body(fetchedData);
//		return advertiseRepository.viewAdvertisementByUser(userId);
	}

	@Override
	public String deleteAdvertise(int advertisementId) {
		// delete Advertisement using AdvertisementId
		try{advertiseRepository.deleteById(advertisementId);}
		catch(Exception e) {
			return("AdvertisementId not found");}
		
		return "Advertisement deleted Successfully";
	}
	
	@Override
	public boolean duplicateCategoryCheck(Category category)
	{	System.out.println("here");
		if(categoryRepository.findByCategoryName(category.getCategoryName()).isEmpty())
			return false;
		else
			return true;
	}
}
