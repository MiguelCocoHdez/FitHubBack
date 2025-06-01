package com.fithub.connection.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fithub.connection.client.ConnectionClientClient;
import com.fithub.connection.client.ConnectionTrainerClient;
import com.fithub.connection.dto.IdsTrainerClientDTO;

@Component
public class RabbitListener {
	
	@Autowired
	ConnectionClientClient ccc;
	
	@Autowired
	ConnectionTrainerClient ctc;

	@org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitConfig.QUEUE)
	void asignarClientesYTrainers(IdsTrainerClientDTO request) {
		ccc.agregarTrainer(request.getClientId(), request.getTrainerId());
		ctc.agregarClient(request.getTrainerId(), request.getClientId());
	}
}
