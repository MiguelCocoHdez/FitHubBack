package com.fithub.auth.rest;

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
@RequestMapping("fithub/auth")
public class AuthRestController {

	@Autowired
	AuthService as;
	
	@PostMapping("/register")
	ResponseEntity<String> register(@RequestBody RegistroDTO reg) {
		return ResponseEntity.ok(as.registro(reg));
	}
	
	@PostMapping("/login")
	ResponseEntity<String> login(@RequestBody LoginDTO log) {
		return ResponseEntity.ok(as.login(log));
	}
	
	@GetMapping("/perfil")
	AuthDTO verDatosPerfilUsuario(Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		return as.findByEmail(email);
	}
}
