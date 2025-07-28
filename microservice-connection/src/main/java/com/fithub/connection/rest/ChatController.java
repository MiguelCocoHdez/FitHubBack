package com.fithub.connection.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.fithub.connection.dto.MensajeDTO;
import com.fithub.connection.service.MensajesService;

@Controller
public class ChatController {
	
	@Autowired
	SimpMessagingTemplate mt;
	
	@Autowired
    MensajesService ms;

	@MessageMapping("/chat.enviar")
	public void enviarMensaje(@Payload MensajeDTO mensaje) {
		ms.mandarMensaje(mensaje);
		
		String destinatario = "/user/" + mensaje.getTrainerId() + "-" + mensaje.getClientId() + "/mensajes";
		
		mt.convertAndSend(destinatario, mensaje);
	}
}
