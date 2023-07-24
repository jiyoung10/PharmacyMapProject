package com.example.pharmacyMapProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PharmacyMapProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyMapProjectApplication.class, args);
	}

}
