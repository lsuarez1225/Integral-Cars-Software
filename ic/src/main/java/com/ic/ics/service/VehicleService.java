package com.ic.ics.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ic.ics.model.FuelType;
import com.ic.ics.model.Vehicle;
import com.ic.ics.model.VehicleModel;
import com.ic.ics.model.VehicleModelLine;
import com.ic.ics.repository.ClientRepository;
import com.ic.ics.repository.FuelTypeRepository;
import com.ic.ics.repository.NidTypeRepository;
import com.ic.ics.repository.VehicleModelLineRepository;
import com.ic.ics.repository.VehicleModelRepository;
import com.ic.ics.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	@Autowired
	private VehicleModelLineRepository vehicleModelLineRepository;
	
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}
	
	public List<Vehicle> getVehicles(String value) {
		return vehicleRepository.findAll(value);
	}
	
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	public List<FuelType> getFuelTypes() {
		return fuelTypeRepository.findAll();
	}
	
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}
	
	public List<VehicleModelLine> getVehicleLinesByModel(Long id) {
		return vehicleModelLineRepository.findByVehicleModel(id);
	}
	
	public void addInitializationData() {
		
		VehicleModel vehicleModelMazda = new VehicleModel("Mazda");
		VehicleModel vehicleModelRenault = new VehicleModel("Renault");
		VehicleModel vehicleModelFord = new VehicleModel("Ford");
		
		Set<VehicleModel> listModel = new HashSet<VehicleModel>();
		listModel.add(vehicleModelMazda);
		listModel.add(vehicleModelRenault);
		listModel.add(vehicleModelFord);
		
		Set<VehicleModelLine> listModelLine = new HashSet<VehicleModelLine>();
		listModelLine.add(new VehicleModelLine(vehicleModelMazda, "3"));
		listModelLine.add(new VehicleModelLine(vehicleModelMazda, "2"));
		listModelLine.add(new VehicleModelLine(vehicleModelMazda, "CX-5"));
		
		listModelLine.add(new VehicleModelLine(vehicleModelRenault, "Sandero"));
		listModelLine.add(new VehicleModelLine(vehicleModelRenault, "Logan"));
		listModelLine.add(new VehicleModelLine(vehicleModelRenault, "Duster"));
		
		listModelLine.add(new VehicleModelLine(vehicleModelFord, "Fiesta"));
		listModelLine.add(new VehicleModelLine(vehicleModelFord, "Focus"));
		listModelLine.add(new VehicleModelLine(vehicleModelFord, "Escape"));
		
		Set<FuelType> listFuelType = new HashSet<FuelType>();
		FuelType fuelTypeGasoline = new FuelType("Gasolina");
		FuelType fuelTypeGas = new FuelType("Gas");
		FuelType fuelTypeExtra = new FuelType("Extra");
		
		listFuelType.add(fuelTypeGasoline);
		listFuelType.add(fuelTypeGas);
		listFuelType.add(fuelTypeExtra);
		
		fuelTypeRepository.saveAll(listFuelType);
		vehicleModelRepository.saveAll(listModel);
		vehicleModelLineRepository.saveAll(listModelLine);
	}
}
