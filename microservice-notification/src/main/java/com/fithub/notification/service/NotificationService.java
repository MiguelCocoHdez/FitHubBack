package com.fithub.notification.service;

import java.util.List;

import com.fithub.notification.response.VerNotificationsTrainerResponse;

public interface NotificationService {

	List<VerNotificationsTrainerResponse> verNotificacionesTrainer(Long trainerId);
	
	void aceptarPeticion(Long idPeticion);
}
