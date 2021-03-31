package com.ic.ics.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "plate")
	private String plate;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_model_line_id", referencedColumnName = "id")
	private VehicleModelLine vehicleModelLine;	
	
	@Column(name = "year_model")
	private String yearModel;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "chassis_number")
	private String chassisNumber;
	
	@Column(name = "motor_number")
	private String motorNumber;
	
	@ManyToOne
	@JoinColumn(name = "fuel_type_id", referencedColumnName = "id")
	private FuelType fuelType;
	
	@Column(name = "dateCreated", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate dateCreated = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
	/*
	@ManyToOne
	@JoinTable(name = "clients_vehicles", joinColumns = @JoinColumn(name = "vehicle_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
	private Client client;
	*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public VehicleModelLine getVehicleModelLine() {
		return vehicleModelLine;
	}

	public void setVehicleModelLine(VehicleModelLine vehicleModelLine) {
		this.vehicleModelLine = vehicleModelLine;
	}

	public String getYearModel() {
		return yearModel;
	}

	public void setYearModel(String yearModel) {
		this.yearModel = yearModel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getMotorNumber() {
		return motorNumber;
	}

	public void setMotorNumber(String motorNumber) {
		this.motorNumber = motorNumber;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	/*
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	*/
}
