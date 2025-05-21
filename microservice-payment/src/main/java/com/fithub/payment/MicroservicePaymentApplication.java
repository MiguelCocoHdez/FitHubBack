package com.fithub.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePaymentApplication.class, args);
	}

}
