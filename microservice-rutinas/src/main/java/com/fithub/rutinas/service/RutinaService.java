package com.fithub.rutinas.service;

import java.util.List;

import com.fithub.rutinas.dto.CrearRutinaDTO;
import com.fithub.rutinas.dto.RutinaCompletaDTO;

public interface RutinaService {

	void crearRutina(CrearRutinaDTO rutina);
	
	List<RutinaCompletaDTO> verRutinasTrainer(Long trainerId);
	
	void eliminarRutina(Long id);
	
	void asignarRutina(Long clientId, Long id);
}
