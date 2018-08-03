package com.example.demo.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ws.model.Client;
import com.example.demo.ws.service.ClientService;

@RestController
public class ClienteController {

	@Autowired
	ClientService clientService;

	// End points
	@RequestMapping(method = RequestMethod.GET, value = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Client>> searchAll() {
		Collection<Client> searchedCLients = clientService.searchForAll();
		return new ResponseEntity<>(searchedCLients, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> login(@RequestBody Client cliente) {
		Boolean clientLogged = clientService.login(cliente);
		return new ResponseEntity<>(clientLogged, HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> register(@RequestBody Client cliente) {
		Client clientRegistered = clientService.register(cliente);
		return new ResponseEntity<Client>(clientRegistered, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/removeById/{id}")
	public ResponseEntity<Client> removeById(@PathVariable Integer id) {

		Client clientFound = clientService.searchById(id);
		if (clientFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		clientService.remove(clientFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> update(@RequestBody Client cliente) {
		Client clientUpdated = clientService.update(cliente);
		return new ResponseEntity<Client>(clientUpdated, HttpStatus.OK);
	}

}
