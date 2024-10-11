package com.project.api_rest_viacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot project generated via Spring Initializr.
 * The following modules were selected:
 * - Spring Data JPA
 * - Spring Web
 * - Lombok
 * - H2 Database
 * - OpenFeign
 *
 * @author danieelfeer
 */

@EnableFeignClients
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
