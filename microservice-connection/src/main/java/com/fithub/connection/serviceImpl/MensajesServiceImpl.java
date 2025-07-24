package com.fithub.connection.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithub.connection.dto.MensajeDTO;
import com.fithub.connection.dto.MensajeRecibidoDTO;
import com.fithub.connection.entity.MensajesEntity;
import com.fithub.connection.repository.ConnectionRepository;
import com.fithub.connection.service.MensajesService;

@Service
public class MensajesServiceImpl implements MensajesService {
	
	@Autowired
	ConnectionRepository cr;

	@Override
	public void mandarMensaje(MensajeDTO mensaje) {
		MensajesEntity m = MensajesEntity.parse(mensaje);
		m.setHoraEnviada(LocalDateTime.now());
		
		cr.save(m);
	}

	@Override
	public List<MensajeRecibidoDTO> verConversacion(Long trainerId, Long clientId) {
		List<MensajeRecibidoDTO> conversacion = new ArrayList<MensajeRecibidoDTO>();
		
		for(MensajesEntity m : cr.verConversacion(trainerId, clientId)) {
			conversacion.add(MensajeRecibidoDTO.parse(m));
		}
		
		return conversacion;
	}

}
