package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan("com.dao.entity")
@ComponentScan(basePackages={"com.mvc.controller"})
public class SpringBootWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJpaApplication.class, args);
	}
}

/*
CREATE TABLE department (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
name CHAR(30) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE employee (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    name CHAR(30) NOT NULL,
    dept_id MEDIUMINT,
    PRIMARY KEY(id),
    FOREIGN KEY (dept_id) REFERENCES department(id) ON DELETE CASCADE
);

*/