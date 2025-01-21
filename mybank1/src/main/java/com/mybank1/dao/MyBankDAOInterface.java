package com.mybank1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank1.entity.Employee;

@Repository
public interface MyBankDAOInterface extends JpaRepository<Employee, String>{

}
