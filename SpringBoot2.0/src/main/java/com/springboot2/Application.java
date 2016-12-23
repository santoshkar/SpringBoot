package com.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@Controller*/
@SpringBootApplication

@EnableJpaRepositories(basePackages={"com.dao.repository"})
@EntityScan(basePackages={"com.dao.entity"})
@ComponentScan(basePackages={"com.mvc.controller"})

/**
 * 
 * @author Santosh_Kar
 *
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*@RequestMapping("/")
	private String sayHello(){
		return "hello";
	}*/
}
