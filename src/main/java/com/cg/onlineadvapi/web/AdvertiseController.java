package com.cg.onlineadvapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.service.AdminService;

@RestController

@RequestMapping("/api")
public class AdvertiseController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/viewAdvertisementByUser")
	public ResponseEntity<Object> viewAdvertisementByUser(int userId) throws Exception
	{	//ResponseEntity<Object> fetchedData=adminService.viewAdvertisementByUser(userId);
		
		return adminService.viewAdvertisementByUser(userId);
	}
	@PostMapping("/deleteAdvertise")
	public String deleteAdvertise(int advertisementId)
	{	//returns "AdvertisementId not found" message for invalid AdvertisementId, otherwise returns "Advertisement deleted successfully"
		return adminService.deleteAdvertise(advertisementId);
	}
}
