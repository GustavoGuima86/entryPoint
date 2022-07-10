package com.example.entrypoint;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class EntrypointApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrypointApplication.class, args);
	}

}
