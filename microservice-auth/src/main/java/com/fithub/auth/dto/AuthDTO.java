package com.fithub.auth.dto;

import com.fithub.auth.entity.AuthEntity;
import com.fithub.auth.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class AuthDTO {

	private Long id;
	private String nombreusuario;
	private String contraseña;
	private String email;
	private Role rol;
	
	public static AuthDTO parse(AuthEntity r) {
		AuthDTO ae = new AuthDTO();
		
		ae.setId(r.getId());
		ae.setNombreusuario(r.getNombreusuario());
		ae.setContraseña(r.getContraseña());
		ae.setEmail(r.getEmail());
		ae.setRol(r.getRol());
		
		return ae;
	}
}
