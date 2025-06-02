package com.fithub.trainer.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fithub.trainer.client.TrainerClientClient;
import com.fithub.trainer.dto.ClientDTO;
import com.fithub.trainer.dto.TrainerCompletoDTO;
import com.fithub.trainer.dto.TrainerDTO;
import com.fithub.trainer.entity.TrainerEntity;
import com.fithub.trainer.repository.TrainerRepository;
import com.fithub.trainer.response.VerTrainerIdResponse;
import com.fithub.trainer.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	TrainerRepository tr;
	
	@Autowired
	TrainerClientClient tcc;

	@Override
	public void crearTrainer(TrainerDTO trainer, String email) {
		TrainerEntity trainerCompleto = TrainerEntity.parse(trainer);
		
		trainerCompleto.setEmail(email);
		trainerCompleto.setFechacreacion(LocalDate.now());
		
		tr.save(trainerCompleto);
	}

	@Override
	public VerTrainerIdResponse verClientesTrainer(String email) {
		TrainerCompletoDTO trainer = TrainerCompletoDTO.parse(tr.verTrainerEmail(email));
		
		if(trainer == null) {
			return new VerTrainerIdResponse();
		}
		
		//Lista de clientes del entrenador
		List<ClientDTO> clientesTrainer = tcc.verClientesTrainer(trainer.getClientesIds());
		
		return VerTrainerIdResponse.builder()
				.id(trainer.getId())
				.nombre(trainer.getNombre())
				.apellidos(trainer.getApellidos())
				.email(trainer.getEmail())
				.tfno(trainer.getTfno())
				.bio(trainer.getBio())
				.foto(trainer.getFoto())
				.fechacreacion(trainer.getFechacreacion())
				.plan(trainer.getPlan())
				.redesSociales(trainer.getRedesSociales())
				.clientes(clientesTrainer)
				.build();		
	}

	@Override
	public void validarAccesoTrainer(String email) {
		TrainerCompletoDTO trainer = TrainerCompletoDTO.parse(tr.verTrainerEmail(email));
		
		if(trainer == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entrenador no encontrado");
		}
		
		if(!trainer.getEmail().equals(email)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tienes permiso para acceder a estos datos");
		}
	}

	@Override
	public TrainerCompletoDTO verTrainerEmail(String email) {
		return TrainerCompletoDTO.parse(tr.verTrainerEmail(email));
	}

	@Override
	public void cambiarAPremiumTrainer(String email) {		
		tr.cambiarAPremiumTrainer(email);
	}

	@Override
	public void agregarClient(Long trainerId, Long clientId) {
		tr.agregarClient(trainerId, clientId);
	}

	@Override
	public List<TrainerCompletoDTO> verTodosTrainers() {
		List<TrainerCompletoDTO> trainers = new ArrayList<TrainerCompletoDTO>();
		
		for(TrainerEntity t : tr.verTodosTrainers()) {
			trainers.add(TrainerCompletoDTO.parse(t));
		}
		
		return trainers;
	}

}
