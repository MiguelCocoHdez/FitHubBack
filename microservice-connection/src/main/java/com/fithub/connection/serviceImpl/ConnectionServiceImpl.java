package com.fithub.connection.serviceImpl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fithub.connection.dto.RequestConectarTrainer;
import com.fithub.connection.rabbitmq.RabbitConfig;
import com.fithub.connection.service.ConnectionService;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	
	@Autowired
	@Qualifier("templateJson") //Esto lo hace para que coja el template de json en vez de el que crea spring por defecto
	AmqpTemplate at;

	@Override
	public void solicitarConexion(RequestConectarTrainer request) {
		at.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, request);
	}

}
