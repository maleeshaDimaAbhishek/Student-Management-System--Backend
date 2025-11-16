package com.studentmanager.sm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student Manager API", version = "1.0", description = "CRUD operations for students"))
public class SmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmApplication.class, args);
    }
}
