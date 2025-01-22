package com.mybank1.controller;
import java.util.List;

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
	public List<Employee> showAll() {
		return mService.getAllEmployeeService();
	}
	
	
	@PostMapping("createProfile")   //create
	public String register(@RequestBody Employee emp) { //how api will take data from postman/client? using @RequestBody
		Employee ee = mService.createProfileService(emp);
		return "registration completed "+ emp.getName()+"  "+emp.getPassword()+"   "+emp.getEmail()+"  "+emp.getAddress();
	}
	
	
	@PutMapping("editProfile/{uid}")   //edit
	public String updateProfile(@PathVariable("uid") String uidemail, @RequestBody Employee emp) {
		emp.setEmail(uidemail);
		return mService.editProfileService(emp);
	}
	
	@DeleteMapping("deleteProfile/{uid}")  //delete // here {uid} means uid variable dynamic value passed by postman
	public String delete(@PathVariable("uid") String uidemail){  //take value of uid using @PathVariable and store inside String
		return mService.deleteProfileService(uidemail);
	}
}








