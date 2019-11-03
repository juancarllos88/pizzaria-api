package br.com.pizzaria.core.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.pizzaria.core.api.application.configuration.ApplicationProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperty.class)
public class App {
	

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	
}
