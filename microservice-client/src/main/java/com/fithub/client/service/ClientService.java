package com.fithub.client.service;

import java.util.List;

import com.fithub.client.dto.ClientDTO;
import com.fithub.client.dto.ClienteCompletoDTO;

public interface ClientService {

	void crearClient(ClientDTO client, String email);
	
	List<ClienteCompletoDTO> verClientesTrainer(List<Long> ids);
}
