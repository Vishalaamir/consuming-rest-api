package com.spring.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import api.Employee;
import exceptionhandler.AppExceptionHandler;

@Controller
public class NormalController {
	
	@Autowired
	RestTemplate restTemplate;
//    @Autowired
//	AppExceptionHandler errorHandler;
	String url="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/employee";
	String posturl="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/add-emp";
	String getforentityurl="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/employee/100";
	String RestExceptionHandlerTestURL="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/employee/30";
	
	@GetMapping("/fetch-employee")
	public String getEmployeeList(Model model){
		
		Employee[] employeearray = restTemplate.getForObject(url,Employee[].class );
		List<Employee> employeeList = Arrays.asList(employeearray);
		model.addAttribute("employeeList", employeeList);
		return "employeeList";
	}
	
	@PostMapping("/create-employee")
	@ResponseBody
	public String createEmployee(@RequestBody Employee newemployee) {
		
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.add("Accept","application/json");
		httpheaders.add("Content-Type","application/json");
		HttpEntity request=new HttpEntity(newemployee,httpheaders);
		restTemplate.postForObject(posturl, request, Employee.class);
		return "New employee created";
	}
	
	@GetMapping("/getforentity")
	@ResponseBody
	public String getEmployeeListByEntity() {
		
		ResponseEntity<Employee> getforEntityobj = restTemplate.getForEntity(getforentityurl, Employee.class);
		System.out.println("getforEntityobj:"+" "+getforEntityobj);
		HttpHeaders headers = getforEntityobj.getHeaders();
		Employee body = getforEntityobj.getBody();
		System.out.println("body:"+body);
		Set<String> keySet = headers.keySet();
		for(String key:keySet) {
		String value = headers.getFirst(key);
		System.out.println("value:"+value);
		}
		return "Showing employeee entity";
		
	} 
	
	@GetMapping("/testRestExceptionHandlerMethod")
	public String testRestExceptionHandling() {
		String EmpAsStr=restTemplate.getForObject(RestExceptionHandlerTestURL,String.class);
		System.out.println("Back to Rest Controller");
		System.out.println(EmpAsStr);
		return EmpAsStr;
	}
	
}

