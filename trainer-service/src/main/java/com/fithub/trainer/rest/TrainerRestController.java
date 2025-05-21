package com.fithub.trainer.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.trainer.dto.TrainerCompletoDTO;
import com.fithub.trainer.dto.TrainerDTO;
import com.fithub.trainer.response.VerTrainerIdResponse;
import com.fithub.trainer.service.TrainerService;


@RestController
@RequestMapping("/fithub/trainer")
public class TrainerRestController {

	@Autowired
	TrainerService ts;
	
	@PostMapping("/register")
	ResponseEntity<String> crearTrainer(@RequestBody TrainerDTO trainer, Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		ts.crearTrainer(trainer, email);
		
		return ResponseEntity.ok("Registrado correctamente");
	}
	
	@GetMapping("/verTrainer")
	VerTrainerIdResponse verTrainer(@RequestParam Long trainerId, Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		ts.validarAccesoTrainer(trainerId, email);
		
		return ts.verClientesTrainer(trainerId);
	}
	
	//ENDPOINT CONSUMIDO POR PAYMENT SERVICE
	@GetMapping("/verTrainerEmail")
	TrainerCompletoDTO verTrainerEmail(Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		return ts.verTrainerEmail(email);
	}
	
	//ENDPOINT CONSUMIDO POR PAYMENT SERVICE
	@PatchMapping("/cambiarAPremiumTrainer")
	void cambiarAPremiumTrainer(Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		ts.cambiarAPremiumTrainer(email);
	}
}
