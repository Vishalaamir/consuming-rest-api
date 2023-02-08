package com.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	EmployeeDAOImpl(){
		
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getEmployeeList() {
		String sql="select * from employee";
		List <Employee> employeeList = jdbcTemplate.query(sql, new RowMapper<Employee>()
				
				{

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						int id=rs.getInt("id");
						String firstName=rs.getString("first_name");
						String lastName=rs.getString("last_name");
						
						Employee employee=new Employee(id,firstName,lastName);
						return employee;
					}
			
				});
		return employeeList;
	}

	@Override
	public Employee getEmployeeById() {
		
		return null;
	}

	@Override
	public Employee addEmployee() {
		
		
		return null;
	}
	

}
