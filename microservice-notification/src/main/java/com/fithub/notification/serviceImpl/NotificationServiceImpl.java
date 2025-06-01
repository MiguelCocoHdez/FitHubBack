package com.fithub.notification.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fithub.notification.client.NotificationClientClient;
import com.fithub.notification.dto.ClienteCompletoDTO;
import com.fithub.notification.dto.IdsTrainerClientDTO;
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
	
	@Autowired
	@Qualifier("templateJson")
	AmqpTemplate at;

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
		
		//Ver el cliente con el mensaje que puso en su solicitud
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

	@Override
	public void aceptarPeticion(Long idPeticion) {
		nr.aceptarPeticion(idPeticion);
		
		NotificationDTO notificacion = NotificationDTO.parse(nr.getReferenceById(idPeticion));
		
		at.convertAndSend("fithub.connection.exchange", "fithub.connection.solicitud", new IdsTrainerClientDTO(notificacion.getClientId(), notificacion.getTrainerId()));
	}

}
