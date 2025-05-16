package com.fithub.trainer.service;

import com.fithub.trainer.dto.TrainerDTO;

public interface TrainerService {

	void crearTrainer(TrainerDTO trainer, String email);
}
