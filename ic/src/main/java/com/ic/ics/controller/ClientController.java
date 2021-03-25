package com.ic.ics.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ic.ics.model.AjaxResponse;
import com.ic.ics.model.Client;
import com.ic.ics.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "/clients")
	public String getClientsForm(@RequestParam(name = "b", defaultValue = "") String value, Model model) {
		
		List<Client> list;
		
		if (!value.isBlank()) {
			list = clientService.getClients(value);
		}
		else {
			list = clientService.getClients();
		}
		
		model.addAttribute("listClients", list);
		model.addAttribute("client", new Client());
		
		return "user-form/clients";
	}

	@PostMapping(value = "/saveClient")
	public ResponseEntity<Object> saveClient(@RequestBody Client client, Errors errors) {
		
		AjaxResponse response = new AjaxResponse();
		
		if (errors.hasErrors()) {
			response.setStatus(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		clientService.saveClient(client);
		
		response.setStatus("OK AGREGADO");
		response.setObject(client);
		
		return ResponseEntity.ok(response);
	}	
}