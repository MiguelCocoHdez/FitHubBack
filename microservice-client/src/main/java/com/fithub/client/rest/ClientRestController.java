package com.fithub.client.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.client.dto.ClientDTO;
import com.fithub.client.dto.ClienteCompletoDTO;
import com.fithub.client.service.ClientService;

@RequestMapping("/fithub/client")
@RestController
public class ClientRestController {
	
	@Autowired
	ClientService cs;

	@PostMapping("/register")
	ResponseEntity<String> crearClient(@RequestBody ClientDTO client, Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		cs.crearClient(client, email);
		
		return ResponseEntity.ok("Cliente creado correctamente");
	}
	
	//Endpoint usado en verTrainerId en el servicio trainers
	@GetMapping("/verClientesTrainer")
	List<ClienteCompletoDTO> verClientesTrainer(@RequestParam List<Long> ids) {
		return cs.verClientesTrainer(ids);
	}
}
