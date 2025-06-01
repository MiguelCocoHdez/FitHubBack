package com.fithub.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceNotificationApplication.class, args);
	}

}
