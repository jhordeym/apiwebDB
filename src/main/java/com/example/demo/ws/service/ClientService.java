package com.example.demo.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ws.model.Client;
import com.example.demo.ws.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	// Negocios
	public Client register(Client client) {
		return clientRepository.save(client);
	}
	
	public Collection<Client> searchForAll() {
		return clientRepository.findAll();
	}
	
	public void remove(Client client) {
		clientRepository.delete(client);
	}
	
	public Client searchById(Integer id) {
		return clientRepository.findOne(id);
	}
	
	public Client update(Client client) {
		return clientRepository.save(client);
	}
	
	public Boolean login(Client client) {
		Collection<Client> clients = searchForAll();
		for(Client c : clients) {
			boolean result = c.compareTo(client);
			if(result == true)
				return new Boolean(true);
		}
		return new Boolean(false);
	}
	
	
}
