package com.fithub.client.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/verClient")
	ClienteCompletoDTO verClient(Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		return cs.verClient(email);
	}
	
	//Endpoint usado en verTrainerId en el servicio trainers y notification service
	@GetMapping("/verClientesTrainer")
	List<ClienteCompletoDTO> verClientesTrainer(@RequestParam List<Long> ids) {
		return cs.verClientesTrainer(ids);
	}
	
	//Endpoint usado en connection service que se encarga de gestionar agregar clientes y trainers
	@PutMapping("/agregarTrainer")
	void agregarTrainer(@RequestParam Long clientId, @RequestParam Long trainerId) {
		cs.agregarTrainer(clientId, trainerId);
	}
}
