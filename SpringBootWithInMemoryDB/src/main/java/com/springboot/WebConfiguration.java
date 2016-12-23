package com.springboot;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Required to get access to the console for the inmemory DB
 */
/*@Configuration
public class WebConfiguration {

	@Bean
	ServletRegistrationBean ServletRegistrationForInMemoryDB(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
	
}*/
