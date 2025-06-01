package com.fithub.notification.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithub.notification.client.NotificationClientClient;
import com.fithub.notification.dto.ClienteCompletoDTO;
import com.fithub.notification.dto.NotificationDTO;
import com.fithub.notification.entity.NotificationEntity;
import com.fithub.notification.repository.NotificationRepository;
import com.fithub.notification.response.VerNotificationsTrainerResponse;
import com.fithub.notification.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationRepository nr;
	
	@Autowired
	NotificationClientClient ncc;

	@Override
	public List<VerNotificationsTrainerResponse> verNotificacionesTrainer(Long trainerId) {
		List<NotificationDTO> notificaciones = new ArrayList<NotificationDTO>();
		List<Long> idsClientes = new ArrayList<Long>();
		
		for(NotificationEntity n : nr.verNotificacionesTrainer(trainerId)) {
			idsClientes.add(n.getClientId());
			notificaciones.add(NotificationDTO.parse(n));
		}
		
		//Ver la info de los clientes
		List<ClienteCompletoDTO> todosClientes = ncc.verClientesTrainer(idsClientes);
		
		List<VerNotificationsTrainerResponse> listaFinal = new ArrayList<VerNotificationsTrainerResponse>();
		
		for(NotificationDTO n : notificaciones) {
			for(ClienteCompletoDTO c : todosClientes) {
				if(n.getClientId().equals(c.getId())) {
					VerNotificationsTrainerResponse respuesta = VerNotificationsTrainerResponse.builder()
						.mensaje(n.getMensaje())
						.cliente(c)
						.build();
					
					listaFinal.add(respuesta);
				}
			}
		}
		
		return listaFinal;
	}

}
