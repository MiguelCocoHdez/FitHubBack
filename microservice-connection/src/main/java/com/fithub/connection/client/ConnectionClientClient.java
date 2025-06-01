package com.fithub.connection.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "msvc-client")
public interface ConnectionClientClient {

	@PutMapping("/fithub/client/agregarTrainer")
	void agregarTrainer(@RequestParam Long clientId, @RequestParam Long trainerId);
}
