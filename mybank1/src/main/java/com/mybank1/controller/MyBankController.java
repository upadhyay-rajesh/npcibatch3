package com.mybank1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybank1.entity.Employee;
import com.mybank1.service.MyBankServiceInterface;

@RestController
public class MyBankController {
	
	@Autowired
	private MyBankServiceInterface mService;
	
	@GetMapping("displayAllEmployee")   //retrive
	public String showAll() {
		return "welcome to Rest API";
	}
	
	@PostMapping("createProfile")   //create
	public String register(@RequestBody Employee emp) { //how api will take data from postman/client? using @RequestBody
		
		Employee ee = mService.createProfileService(emp);
		
		return "registration completed "+ emp.getName()+"  "+emp.getPassword()+"   "+emp.getEmail()+"  "+emp.getAddress();
	}
	
	@PutMapping("editProfile")   //edit
	public String updateProfile() {
		return "profile updated";
	}
	
	@DeleteMapping("deleteProfile/{uid}")  //delete // here {uid} means uid variable dynamic value passed by postman
	public String delete(@PathVariable("uid") String uidemail){  //take value of uid using @PathVariable and store inside String
		return "profile deleted";
	}

}








