package com.fithub.auth.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fithub.auth.exception.AuthException;

@RestControllerAdvice
public class AuthManejoExcepciones { //ESTA CLASE SIRVE PARA QUE NO DEVUELVA SIEMPRE 401 UNAUTHORIZED Y DEVUELVA MIS EXCEPCIONES PERSONALIZADAS

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<Map<String, String>> manejoExcepcion(AuthException ex) {
		Map<String, String> response = new HashMap<>();
		
		response.put("mensaje", ex.getMessage());
		
		return ResponseEntity.status(ex.getCodigo()).body(response);
	}
}
