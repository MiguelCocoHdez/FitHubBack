package com.fithub.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.fithub.payment.dto.TrainerDTO;


@FeignClient(name = "msvc-trainer", configuration = FeignClientConfig.class)
public interface PaymentTrainerClient {

	@GetMapping("/fithub/trainer/verTrainerEmail")
	TrainerDTO verTrainerEmail();
	
	@PutMapping("/fithub/trainer/cambiarAPremiumTrainer")
	void cambiarAPremiumTrainer();
}
