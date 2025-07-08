package com.fithub.rutinas.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithub.rutinas.dto.CrearRutinaDTO;
import com.fithub.rutinas.dto.RutinaCompletaDTO;
import com.fithub.rutinas.entity.RutinaEntity;
import com.fithub.rutinas.repository.RutinaRepository;
import com.fithub.rutinas.service.RutinaService;

@Service
public class RutinaServiceImpl implements RutinaService {
	
	@Autowired
	RutinaRepository rr;

	@Override
	public void crearRutina(CrearRutinaDTO rutina) {
		RutinaEntity rutinaF = RutinaEntity.parse(rutina);		
		rutinaF.setFechaCreacion(LocalDate.now());
			
		rr.save(rutinaF);
	}

	@Override
	public List<RutinaCompletaDTO> verRutinasTrainer(Long trainerId) {
		List<RutinaCompletaDTO> rutinasTrainer = new ArrayList<RutinaCompletaDTO>();
		
		for(RutinaEntity r : rr.rutinasTrainer(trainerId)) {
			rutinasTrainer.add(RutinaCompletaDTO.parse(r));
		}
		
		return rutinasTrainer;
	}

}
