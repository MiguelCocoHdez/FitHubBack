package com.fithub.trainer.service;


import com.fithub.trainer.dto.TrainerCompletoDTO;
import com.fithub.trainer.dto.TrainerDTO;
import com.fithub.trainer.response.VerTrainerIdResponse;

public interface TrainerService {

	void crearTrainer(TrainerDTO trainer, String email);
	
	VerTrainerIdResponse verClientesTrainer(String email);
	
	void validarAccesoTrainer(String email);
	
	TrainerCompletoDTO verTrainerEmail(String email);
	
	void cambiarAPremiumTrainer(String email);
	
	void agregarClient(Long trainerId, Long clientId);
}
