package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation{
	
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