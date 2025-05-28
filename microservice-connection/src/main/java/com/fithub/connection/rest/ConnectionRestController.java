package com.fithub.connection.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.connection.dto.RequestConectarTrainer;
import com.fithub.connection.service.ConnectionService;

@RequestMapping("/fithub/connection")
@RestController
public class ConnectionRestController {

	@Autowired
	ConnectionService cs;
	
	@PostMapping("")
	ResponseEntity<String> crearSolicitud(@RequestBody RequestConectarTrainer request) {
		cs.solicitarConexion(request);
		
		return ResponseEntity.ok("Mensaje enviado");
	}
}
