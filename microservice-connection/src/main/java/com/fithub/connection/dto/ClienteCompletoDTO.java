package com.fithub.connection.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class ClienteCompletoDTO {

	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private int tfno;
	private String bio;
	private String foto;
	private LocalDate fechacreacion;
	private String genero;
	private Long trainerid;
	
}
