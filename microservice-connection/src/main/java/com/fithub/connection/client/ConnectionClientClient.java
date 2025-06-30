package com.fithub.connection.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fithub.connection.dto.ClienteCompletoDTO;

@FeignClient(name = "msvc-client", configuration = FeignClientConfig.class)
public interface ConnectionClientClient {

	@PutMapping("/fithub/client/agregarTrainer")
	void agregarTrainer(@RequestParam Long clientId, @RequestParam Long trainerId);
	
	@GetMapping("/fithub/client/verClient")
	ClienteCompletoDTO verClient();
}
