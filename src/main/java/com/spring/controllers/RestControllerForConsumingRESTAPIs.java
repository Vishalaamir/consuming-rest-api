package com.spring.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.Employee;
import exceptionhandler.AppExceptionHandler;

@RestController
public class RestControllerForConsumingRESTAPIs {
	
	@Autowired
	RestTemplate restTemplate;
//	@Autowired
//	SimpleClientHttpRequestFactory requestFactory;
//    @Autowired
//	AppExceptionHandler errorHandler;
	String url="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/employee";
	String posturl="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/add-emp";
	String getforentityurl="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/employee/1";
	String RestExceptionHandlerTestURL="http://newspringrestfirstprojectusingjdbcba-env.eba-ynrrmnbu.us-east-1.elasticbeanstalk.com/employee/190";
	
	@GetMapping("/fetch-employeeinrest")
	public ResponseEntity<List<Employee>> getEmployeeList(Model model){
		
		Employee[] employeearray = restTemplate.getForObject(url,Employee[].class );
		List<Employee> employeeList = Arrays.asList(employeearray);
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
	}
	
	@PostMapping("/create-employeeinrest")
	@ResponseBody
	public ResponseEntity<Employee> Employee(@RequestBody Employee newemployee) {
		
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.add("Accept","application/json");
		httpheaders.add("Content-Type","application/json");
		HttpEntity request=new HttpEntity(newemployee,httpheaders);
		Employee employee = restTemplate.postForObject(posturl, request, Employee.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
//	@PostMapping("/create-employeeinrest")
//	@ResponseBody
//	public ResponseEntity<Employee> Employee( @RequestBody String employeeString) throws JsonMappingException, JsonProcessingException {
//		System.out.println(employeeString);
//		ObjectMapper om=new ObjectMapper();
//		Employee newemp= om.readValue(employeeString, Employee.class);
//		HttpHeaders httpheaders = new HttpHeaders();
//		httpheaders.add("Accept","application/json");
//		httpheaders.add("Content-Type","application/json");
//		HttpEntity request=new HttpEntity(newemp,httpheaders);
//		Employee employee = restTemplate.postForObject(posturl, request, Employee.class);
//		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
//	}
//	
	
	@GetMapping("/getforentityinrest")
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
	
	@GetMapping("/testRestExceptionHandlerMethodinrest")
	public String testRestExceptionHandling() {
		String EmpAsStr=restTemplate.getForObject(RestExceptionHandlerTestURL,String.class);
		System.out.println("Back to Rest Controller");
		System.out.println(EmpAsStr);
		System.out.println(EmpAsStr.toString());
		return EmpAsStr;
	}
	
}
