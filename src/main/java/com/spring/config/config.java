package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import exceptionhandler.AppExceptionHandler;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class config {
	
	@Bean
	public DataSource getDataSource() {
		System.out.println("In DataSource..");
		DriverManagerDataSource dm= new DriverManagerDataSource("jdbc:mysql://mydb.cw5w5ytirprt.us-east-1.rds.amazonaws.com:3306/Employee_Schema?useSSL=false&allowPublicKeyRetrieval=true","Vishal","Sept$123");
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dm;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("In RestTemplate..");
		SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
		requestFactory.setReadTimeout(900);
		requestFactory.setConnectTimeout(900);
		RestTemplate restTemplate=new RestTemplate(requestFactory);
		restTemplate.setErrorHandler(new AppExceptionHandler());
		return restTemplate;
	}
		
	@Bean
	public InternalResourceViewResolver getinternalResourceViewResolver(){
		System.out.println("In InternalResourceViewResolver..");
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
		
	}
//	@Bean
//	public AppExceptionHandler getAppExnHandler(){
//		
//		return new AppExceptionHandler();
//	}

//	@Bean
//	public SimpleClientHttpRequestFactory getSimpleClientHttpRequestFactory() {
//		System.out.println("SimpleClient..");
//		SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
//		requestFactory.setReadTimeout(900);
//        requestFactory.setConnectTimeout(900);
//		return requestFactory;
//	}
}
