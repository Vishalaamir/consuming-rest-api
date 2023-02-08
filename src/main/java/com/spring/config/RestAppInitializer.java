package com.spring.config;

//public class RestAppInitializer {
//
//}

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class [] config= {config.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
		
	}
	

}

