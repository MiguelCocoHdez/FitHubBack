package com.fithub.auth.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.auth.dto.AuthDTO;
import com.fithub.auth.dto.LoginDTO;
import com.fithub.auth.dto.RegistroDTO;
import com.fithub.auth.service.AuthService;

@RestController
@RequestMapping("/fithub/auth")
public class AuthRestController {

	@Autowired
	AuthService as;
	
	@PostMapping("/register")
	ResponseEntity<Map<String, String>> register(@RequestBody RegistroDTO reg) {
		String token = as.registro(reg);
		
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("token", token);
		
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping("/login")
	ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO log) {
		String token = as.login(log);
		
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("token", token);
		
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/perfil")
	AuthDTO verDatosPerfilUsuario(Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		return as.findByEmail(email);
	}
}
