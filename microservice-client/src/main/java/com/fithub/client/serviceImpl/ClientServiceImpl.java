package com.fithub.client.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithub.client.dto.ClientDTO;
import com.fithub.client.dto.ClienteCompletoDTO;
import com.fithub.client.entity.ClientEntity;
import com.fithub.client.repository.ClientRepository;
import com.fithub.client.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository cr;

	@Override
	public void crearClient(ClientDTO client, String email) {
		ClientEntity clientCompleto = ClientEntity.parse(client);
		
		clientCompleto.setEmail(email);
		clientCompleto.setFechacreacion(LocalDate.now());
		
		cr.save(clientCompleto);
	}

	@Override
	public List<ClienteCompletoDTO> verClientesTrainer(List<Long> ids) {
		List<ClienteCompletoDTO> clientes = new ArrayList<ClienteCompletoDTO>();
		
		for(ClientEntity c : cr.verClientesTrainer(ids)) {
			clientes.add(ClienteCompletoDTO.parse(c));
		}
		
		return clientes;
	}

}
