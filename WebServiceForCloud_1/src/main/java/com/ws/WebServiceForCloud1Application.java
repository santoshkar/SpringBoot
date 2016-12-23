package com.ws;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SpringBootApplication
public class WebServiceForCloud1Application {
	
	@Bean
	CommandLineRunner runner(ReservationRepository rr){
		return args -> {
			Arrays.asList("One, Two, Three, Four, Five".split(",")).forEach(x -> rr.save(new Reservation(x, ThreadLocalRandom.current().nextInt(1, 61))));;
			
			rr.findAll().forEach(System.out::println);
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebServiceForCloud1Application.class, args);
	}
	
	
}

@RepositoryRestResource
interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
}

@Entity
class Reservation{
	
	@Id
	@GeneratedValue
	private Long id;
	private Integer age;
	
	private String reservationName;

	
	public Reservation() {
		super();
	}

	public Reservation(String reservationName, Integer age) {
		super();
		this.reservationName = reservationName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", age=" + age + ", reservationName=" + reservationName + "]";
	}
	
}