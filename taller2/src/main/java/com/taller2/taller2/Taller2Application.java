package com.taller2.taller2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.taller2.taller2.models")
@ComponentScan("com.taller2.taller2")
@EnableJpaRepositories("com.taller2.taller2.repository")
public class Taller2Application {

	public static void main(String[] args) {
		SpringApplication.run(Taller2Application.class, args);
	}

}
