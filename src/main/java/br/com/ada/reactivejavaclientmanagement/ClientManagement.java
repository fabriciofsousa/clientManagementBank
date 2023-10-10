package br.com.ada.reactivejavaclientmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@OpenAPIDefinition(info =  @Info(title = "Client Management API", version = "1.0.0",
		description = "Documentation APIs v1.0.0"))
public class ClientManagement {

	public static void main(String[] args) {
		SpringApplication.run(ClientManagement.class, args);
	}

}
