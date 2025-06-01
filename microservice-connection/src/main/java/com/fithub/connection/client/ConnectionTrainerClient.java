package com.fithub.connection.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "msvc-trainer")
public interface ConnectionTrainerClient {

	@PutMapping("/fithub/trainer/agregarClient")
	void agregarClient(@RequestParam Long trainerId, @RequestParam Long clientId);
}
