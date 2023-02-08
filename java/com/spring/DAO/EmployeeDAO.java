package com.spring.DAO;

import java.util.List;

public interface EmployeeDAO {
	List<Employee> getEmployeeList();
	Employee getEmployeeById();
	Employee addEmployee();

}
