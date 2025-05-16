package com.fithub.auth.entity;

import com.fithub.auth.dto.RegistroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class AuthEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombreusuario;
	
	@Column
	private String contraseña;
	
	@Column
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role rol;
	
	public static AuthEntity parse(RegistroDTO r, String contraseñaCifrada) {
		AuthEntity ae = new AuthEntity();
		
		ae.setNombreusuario(r.getNombreusuario());
		ae.setContraseña(contraseñaCifrada);
		ae.setEmail(r.getEmail());
		ae.setRol(r.getRol());
		
		return ae;
	}
}
