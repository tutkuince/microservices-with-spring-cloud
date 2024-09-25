package com.incetutku.restapidevelopmentbasics;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API Documentation",
                description = "Spring Boot REST API Documentation Description",
                version = "v1",
                contact = @Contact(
                        name = "Tutku",
                        email = "tutku.ince@outlook.com",
                        url = "https://github.com/tutkuince"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/tutkuince/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "https://github.com/tutkuince/user_management.html"
        )
)
public class RestApiDevelopmentBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiDevelopmentBasicsApplication.class, args);
    }

}
