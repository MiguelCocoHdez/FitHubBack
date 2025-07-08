package com.fithub.rutinas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class CrearEjercicioDTO {

	private String nombre;
	private String descripcion;
	private Long series;
	private Long repeticionesMin;
	private Long repecionesMax;
}
