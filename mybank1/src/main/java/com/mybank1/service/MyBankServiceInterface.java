package com.mybank1.service;

import java.util.List;

import com.mybank1.entity.Employee;

public interface MyBankServiceInterface {

	Employee createProfileService(Employee emp);

	List<Employee> getAllEmployeeService();

	String editProfileService(Employee emp);

	String deleteProfileService(String uidemail);


}
