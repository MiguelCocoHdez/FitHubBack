package com.fithub.rutinas.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fithub.rutinas.dto.CrearEjercicioDTO;
import com.fithub.rutinas.dto.CrearRutinaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Column
	private Long duracionMins;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rutina_id")
	private List<EjercicioEntity> ejercicios;
	
	@Column
	private LocalDate fechaCreacion;
	
	@Column
	private LocalDate ultimaActualizacion;
	
	@Column
	private Long trainerId;
	
	@ElementCollection
	@Column
	private List<Long> clientId;
	
	public static RutinaEntity parse(CrearRutinaDTO r) {
		RutinaEntity rN = new RutinaEntity();
		
		rN.setNombre(r.getNombre());
		rN.setDescripcion(r.getDescripcion());
		rN.setNivel(r.getNivel());
		rN.setCategoria(r.getCategoria());
		rN.setDuracionMins(r.getDuracionMins());
		rN.setTrainerId(r.getTrainerId());
		
		List<EjercicioEntity> listaEjercicios = new ArrayList<>();
		
		for(CrearEjercicioDTO e : r.getEjercicios()) {
			EjercicioEntity eE = new EjercicioEntity();
			
			eE.setNombre(e.getNombre());
			eE.setDescripcion(e.getDescripcion());
			eE.setSeries(e.getSeries());
			eE.setRepeticionesMin(e.getRepeticionesMin());
			eE.setRepecionesMax(e.getRepecionesMax());
			
			listaEjercicios.add(eE);
		}
		
		rN.setEjercicios(listaEjercicios);
		
		return rN;
	}
}
