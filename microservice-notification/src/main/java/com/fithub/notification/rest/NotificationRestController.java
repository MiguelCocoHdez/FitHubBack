package com.fithub.notification.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.notification.response.VerNotificationsTrainerResponse;
import com.fithub.notification.service.NotificationService;

@RequestMapping("/fithub/notification")
@RestController
public class NotificationRestController {

	@Autowired
	NotificationService ns;
	
	@GetMapping("/verPeticionesTrainer")
	List<VerNotificationsTrainerResponse> verPeticionesClientes(@RequestParam Long trainerId, Authentication auth) {
		return ns.verNotificacionesTrainer(trainerId);
	}

}