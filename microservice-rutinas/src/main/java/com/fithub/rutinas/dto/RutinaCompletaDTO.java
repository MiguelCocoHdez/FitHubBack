package com.fithub.rutinas.dto;

import java.time.LocalDate;
import java.util.List;

import com.fithub.rutinas.entity.Categoria;
import com.fithub.rutinas.entity.EjercicioEntity;
import com.fithub.rutinas.entity.Nivel;
import com.fithub.rutinas.entity.RutinaEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class RutinaCompletaDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private Nivel nivel;
	private Categoria categoria;
	private Long duracionMins;
	private List<EjercicioEntity> ejercicios;
	private LocalDate fechaCreacion;
	private LocalDate ultimaActualizacion;
	private Long trainerId;
	
	public static RutinaCompletaDTO parse(RutinaEntity r) {
		RutinaCompletaDTO rN = new RutinaCompletaDTO();
		
		rN.setId(r.getId());
		rN.setNombre(r.getNombre());
		rN.setDescripcion(r.getDescripcion());
		rN.setNivel(r.getNivel());
		rN.setCategoria(r.getCategoria());
		rN.setDuracionMins(r.getDuracionMins());
		rN.setEjercicios(r.getEjercicios());
		rN.setFechaCreacion(r.getFechaCreacion());
		rN.setUltimaActualizacion(r.getUltimaActualizacion());
		rN.setTrainerId(r.getTrainerId());
		
		return rN;
	}
}
