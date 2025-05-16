package com.fithub.trainer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fithub.trainer.dto.ClientDTO;

@FeignClient(name = "msvc-client")
public interface TrainerClientClient {

	@GetMapping("/fithub/client/verClientesTrainer")
	List<ClientDTO> verClientesTrainer(@RequestParam List<Long> ids);
}
