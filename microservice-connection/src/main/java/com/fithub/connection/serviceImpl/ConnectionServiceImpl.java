package com.fithub.connection.serviceImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithub.connection.dto.RequestConectarTrainer;
import com.fithub.connection.rabbitmq.RabbitConfig;
import com.fithub.connection.service.ConnectionService;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	
	@Autowired
	RabbitTemplate rt;

	@Override
	public void solicitarConexion(RequestConectarTrainer request) {
		rt.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, request);
	}

}
