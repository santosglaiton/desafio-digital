package com.example.desafiodigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients({"com.example.desafiodigital.client"})
public class DesafioDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDigitalApplication.class, args);
	}

}
