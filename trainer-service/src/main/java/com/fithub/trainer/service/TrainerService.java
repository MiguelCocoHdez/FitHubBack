package com.fithub.trainer.service;


import com.fithub.trainer.dto.TrainerCompletoDTO;
import com.fithub.trainer.dto.TrainerDTO;
import com.fithub.trainer.response.VerTrainerIdResponse;

public interface TrainerService {

	void crearTrainer(TrainerDTO trainer, String email);
	
	VerTrainerIdResponse verClientesTrainer(Long trainerId);
	
	void validarAccesoTrainer(Long trainerId, String email);
	
	TrainerCompletoDTO verTrainerEmail(String email);
}
