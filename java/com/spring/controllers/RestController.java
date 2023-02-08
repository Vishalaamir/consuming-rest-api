package com.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.DAO.Employee;
import com.spring.DAO.EmployeeDAO;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	EmployeeDAO employeeDAO;
	@GetMapping(value="/employee")
	public ResponseEntity<List<Employee>>getEmployeeList() {
		List<Employee> employeeList=employeeDAO.getEmployeeList();
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
		
		
	}
}
