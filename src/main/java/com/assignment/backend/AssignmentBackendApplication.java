package com.assignment.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Tour Package API",
				version = "1.0",
				description = "API documentation for managing Tour Packages",
				contact = @Contact(
						name = "Prince",
						email = "prince08833@example.com",
						url = "https://example.com"
				)
		)
)
public class AssignmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentBackendApplication.class, args);
	}

}
