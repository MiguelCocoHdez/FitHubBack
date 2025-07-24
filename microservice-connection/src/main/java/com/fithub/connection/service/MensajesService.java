package com.fithub.connection.service;

import java.util.List;

import com.fithub.connection.dto.MensajeDTO;
import com.fithub.connection.dto.MensajeRecibidoDTO;

public interface MensajesService {

	void mandarMensaje(MensajeDTO mensaje);
	
	List<MensajeRecibidoDTO> verConversacion(Long trainerId, Long clientId);
}
