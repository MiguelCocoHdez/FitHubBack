package com.fithub.trainer.serviceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithub.trainer.dto.TrainerDTO;
import com.fithub.trainer.entity.TrainerEntity;
import com.fithub.trainer.repository.TrainerRepository;
import com.fithub.trainer.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	TrainerRepository tr;

	@Override
	public void crearTrainer(TrainerDTO trainer, String email) {
		TrainerEntity trainerCompleto = TrainerEntity.parse(trainer);
		
		trainerCompleto.setEmail(email);
		trainerCompleto.setFechacreacion(LocalDate.now());
		
		tr.save(trainerCompleto);
	}

}
