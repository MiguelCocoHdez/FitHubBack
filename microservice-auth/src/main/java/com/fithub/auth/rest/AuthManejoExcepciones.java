package com.fithub.auth.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fithub.auth.exception.AuthException;

@RestControllerAdvice
public class AuthManejoExcepciones { //ESTA CLASE SIRVE PARA QUE NO DEVUELVA SIEMPRE 401 UNAUTHORIZED Y DEVUELVA MIS EXCEPCIONES PERSONALIZADAS

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<String> manejoExcepcion(AuthException ex) {
		return ResponseEntity.status(ex.getCodigo()).body(ex.getMessage());
	}
}
