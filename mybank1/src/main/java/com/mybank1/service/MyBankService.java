package com.mybank1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybank1.dao.MyBankDAOInterface;
import com.mybank1.entity.Employee;

@Service
@Transactional
public class MyBankService implements MyBankServiceInterface{
	
	@Autowired
	private MyBankDAOInterface mDao;

	@Override
	public Employee createProfileService(Employee emp) {
		mDao.save(emp);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployeeService() {
		// TODO Auto-generated method stub
		return mDao.findAll();
	}

	@Override
	public String editProfileService(Employee emp) {
		mDao.saveAndFlush(emp);
		return "record edited";
	}

	
	public String deleteProfileService(String uidemail) {
		mDao.deleteById(uidemail);
		return "record deleted";
	}


	

}
