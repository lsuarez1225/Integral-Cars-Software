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
import com.ic.ics.model.FuelType;
import com.ic.ics.model.Vehicle;
import com.ic.ics.model.VehicleModel;
import com.ic.ics.model.VehicleModelLine;
import com.ic.ics.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value = "/vehicles")
	public String getVehicles(@RequestParam(name = "b", defaultValue = "") String value, Model model) {
		
		List<Vehicle> listVehicles;
		
		if (!value.isBlank()) {
			listVehicles = vehicleService.getVehicles(value);
		}
		else {
			listVehicles = vehicleService.getVehicles();
		}
		
		List<VehicleModel> listVehicleModels = vehicleService.getVehicleModels();
		List<FuelType> listFuelTypes = vehicleService.getFuelTypes();
		
		model.addAttribute("vehicleModel", new Vehicle());
		model.addAttribute("listVehicles", listVehicles);
		model.addAttribute("listVehicleModels", listVehicleModels);
		model.addAttribute("listFuelTypes", listFuelTypes);
		
		return "user-form/vehicles";
	}
	
	@GetMapping(value = "/vehicles/lines")
	public ResponseEntity<Object> getVehicleLines(@RequestParam(name = "model") Long id) {
		
		AjaxResponse response = new AjaxResponse();
		
		List<VehicleModelLine> list = vehicleService.getVehicleLinesByModel(id);
		
		response.setObject(list);
		response.setStatus("OK");
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/saveVehicle")
	public ResponseEntity<Object> saveVehicle(@RequestBody Vehicle vehicle, Errors errors) {
		
		AjaxResponse ajaxResponse = new AjaxResponse();
		
		if (errors.hasErrors()) {
			ajaxResponse.setStatus(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			
			return ResponseEntity.badRequest().body(ajaxResponse);
		}
		
		Vehicle vehicleSaved = vehicleService.saveVehicle(vehicle);
		
		ajaxResponse.setObject(vehicleSaved);
		ajaxResponse.setStatus("OK");
		
		return ResponseEntity.ok(ajaxResponse);
	}
	
}
