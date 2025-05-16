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

public class RegistroDTO {

	private String nombreusuario;
	private String contraseña;
	private String email;
	private Role rol;
	
	public static RegistroDTO parse(AuthEntity ae) {
		RegistroDTO r = new RegistroDTO();
		
		r.setNombreusuario(ae.getNombreusuario());
		r.setContraseña(ae.getContraseña());
		r.setEmail(ae.getEmail());
		r.setRol(ae.getRol());
		
		return r;
	}
}