package com.fithub.rutinas.dto;

import java.util.List;

import com.fithub.rutinas.entity.Categoria;
import com.fithub.rutinas.entity.Nivel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class CrearRutinaDTO {

	private String nombre;
	private String descripcion;
	private Nivel nivel;
	private Categoria categoria;
	private Long duracionMins;
	private List<CrearEjercicioDTO> ejercicios;
	private Long trainerId;
}
