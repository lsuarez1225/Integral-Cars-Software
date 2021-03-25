package com.ic.ics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ic.ics.model.Client;
import com.ic.ics.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	List<Client> list = new ArrayList<>();
	
	public List<Client> getClients () {
		return clientRepository.findAll();
	}
	
	public List<Client> getClients (String value) {
		return clientRepository.findAll(value);
	}
	
	public void saveClient (Client client) {
		clientRepository.save(client);
	}
	
}
