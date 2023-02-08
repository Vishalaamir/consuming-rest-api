package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class config {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dm= new DriverManagerDataSource("jdbc:mysql://localhost:3306/employee_data?useSSL=false&allowPublicKeyRetrieval=true","root","Imhappy@0755");
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dm;
		
	}	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

}
