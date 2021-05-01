package com.cg.onlineadvapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineadvapi.domain.Category;
import com.cg.onlineadvapi.service.AdminService;
import com.cg.onlineadvapi.serviceImpl.AdminServiceImpl;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/createNewCategory")
	public ResponseEntity<Object> createNewCategory(@RequestBody Category category)
	{	//checks if duplicate category name exists in database
		
		if(adminService.duplicateCategoryCheck(category)==true)
			return ResponseEntity.accepted().body("Error !! Duplicate category name found !!");
		else
			return ResponseEntity.accepted().body(adminService.saveOrUpdateCategory(category));
		
	}

}
