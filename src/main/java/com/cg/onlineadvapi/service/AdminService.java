package com.cg.onlineadvapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.domain.Category;
import com.cg.onlineadvapi.domain.User;

/**
 * This AdminOperation Service is responsible for performing all the business logic on
 * Admin operations. 
 * @author Shivam
 */
public interface AdminService {
	/**
	 * This addCategory method will add new or update existing category in the database
	 * @param Category to be updated/added
	 * @return Category which is updated/added
	 */
	public Category saveOrUpdateCategory(Category category); 
	
	
	
	/**
	 * This viewUserList method will return List of all Users from database
	 * @return List<User> if found, otherwise null
	 */
	public List<User> viewUserList();
	
	/**
	 * This viewUser method return data of required User from database
	 * @param userId of User
	 * @return User
	 */
	public User viewUser(int userId);
	
	/**
	 * This deleteUser method will delete existing user data from database using User ID
	 * @param User Id of the, user - to be deleted
	 * @return User which is deleted
	 */
	public String deleteUser(int userId);
	
	/**
	 * This viewAdvertisementByUser method will return list of all Advertisement uploaded by specific user
	 * @param userId, whose advertisement list to be fetched
	 * @return List<Advertise> 
	 */
	public ResponseEntity<Object> viewAdvertisementByUser(int userId);
	
	/**
	 * This deleteAdvertise method will delete the required advertisement from the database.
	 * @param AdvertisementID, whose data to be deleted
	 * @return Advertise, which is deleted
	 */
	public String deleteAdvertise(int advertisementId);
	/**
	 * This duplicateCategoryCheck method will check if duplicate category name exists in database
	 * @param Category whose name to be verified
	 * @return true if duplicate value found, otherwise false
	 */
	public boolean duplicateCategoryCheck(Category category);
}
