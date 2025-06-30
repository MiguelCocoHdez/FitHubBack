package com.fithub.connection.serviceImpl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fithub.connection.client.ConnectionClientClient;
import com.fithub.connection.dto.ClienteCompletoDTO;
import com.fithub.connection.dto.RequestConectarTrainer;
import com.fithub.connection.service.ConnectionService;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	
	@Autowired
	@Qualifier("templateJson") //Esto lo hace para que coja el template de json en vez de el que crea spring por defecto
	AmqpTemplate at;
	
	@Autowired
	ConnectionClientClient ccc;

	@Override
	public void solicitarConexion(RequestConectarTrainer request) {
		ClienteCompletoDTO cliente = ccc.verClient();
		
		if(cliente.getTrainerid() != null) {
			return;
		}
		
		at.convertAndSend("fithub.notification.exchange", "fithub.notification.solicitud", request);
	}

}
