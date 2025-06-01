package com.fithub.notification.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fithub.notification.dto.ClienteCompletoDTO;


@FeignClient(name = "msvc-client")
public interface NotificationClientClient {

	@GetMapping("/fithub/client/verClientesTrainer")
	List<ClienteCompletoDTO> verClientesTrainer(@RequestParam List<Long> ids);
}
