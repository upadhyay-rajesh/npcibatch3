package com.mybank1.service;

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

	

}
