package com.fithub.auth.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int codigo;
	
	public AuthException(String mensaje, int codigo) {
		super(mensaje);
		this.codigo = codigo;
	}
}
