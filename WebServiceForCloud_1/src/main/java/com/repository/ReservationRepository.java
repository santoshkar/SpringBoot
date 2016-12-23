package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.entity.Reservation;

@RepositoryRestResource
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
}