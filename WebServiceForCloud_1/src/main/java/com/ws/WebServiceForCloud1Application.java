package com.ws;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.Employee;
import com.entity.Reservation;
import com.repository.EmployeeRepository;
import com.repository.ReservationRepository;

@SpringBootApplication
@EntityScan(basePackages={"com.entity"})
@EnableJpaRepositories(basePackages={"com.repository"})
public class WebServiceForCloud1Application {
	
	@Bean
	CommandLineRunner runner(ReservationRepository rr){
		return args -> {
			Arrays.asList("One, Two, Three, Four, Five".split(",")).forEach(x -> rr.save(new Reservation(x, ThreadLocalRandom.current().nextInt(1, 61))));;
			
			rr.findAll().forEach(System.out::println);
			
		};
	}
	
	@Bean
	CommandLineRunner runner2(EmployeeRepository rr){
		return args -> {
			
			Arrays.asList("Santosh, Hanmantha, Kala, Pramod, Srini".split(",")).forEach(x -> rr.save(new Employee(x, ThreadLocalRandom.current().nextInt(1, 61))));;
			rr.findAll().forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebServiceForCloud1Application.class, args);
	}
	
	
}




