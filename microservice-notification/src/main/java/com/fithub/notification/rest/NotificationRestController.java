package com.fithub.notification.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.notification.response.VerNotificationsTrainerResponse;
import com.fithub.notification.service.NotificationService;

@RequestMapping("/fithub/notification")
@RestController
public class NotificationRestController {

	@Autowired
	NotificationService ns;
	
	@GetMapping("/verPeticionesTrainer")
	List<VerNotificationsTrainerResponse> verPeticionesClientes(@RequestParam Long trainerId, Authentication auth) {
		return ns.verNotificacionesTrainer(trainerId);
	}
	
	@PutMapping("/aceptarPeticion")
	ResponseEntity<Map<String, String>> aceptarPeticion(@RequestParam Long idPeticion, Authentication auth) {
		Map<String, String> respuesta = new HashMap<>();
		
		ns.aceptarPeticion(idPeticion);
		respuesta.put("Mensaje", "Peticion aceptada correctamente");
		
		return ResponseEntity.ok(respuesta);
	}
}