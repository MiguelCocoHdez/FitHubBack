package com.fithub.notification.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.fithub.notification.dto.RequestConectarTrainer;
import com.fithub.notification.entity.EstadoSolicitud;
import com.fithub.notification.entity.NotificationEntity;
import com.fithub.notification.repository.NotificationRepository;

@Component
public class RabbitListener {

	@Autowired
	NotificationRepository nr;
	
	@org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitConfig.QUEUE)
	void recibirSolicitud(RequestConectarTrainer request) {
		NotificationEntity notificacion = NotificationEntity.parse(request);
		notificacion.setEstado(EstadoSolicitud.PENDIENTE);
		Boolean notificacionExiste = nr.notificacionRepetida(notificacion.getClientId(), notificacion.getTrainerId());
		
		if(notificacionExiste) {
			return;
		}
		
		nr.save(notificacion);
	}
	
}
