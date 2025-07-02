package com.fithub.rutinas.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutinas")
public class RutinaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@Column
	private Long duracionMins;
	
	@ElementCollection
	@Column
	private List<EjercicioEntity> ejercicios;
	
	@Column
	private LocalDate fechaCreacion;
	
	@Column
	private LocalDate ultimaActualizacion;
	
	@Column
	private Long trainerId;
}
