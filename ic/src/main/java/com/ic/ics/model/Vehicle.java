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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"vehicle\"")
public class Vehicle {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "plate")
	private String plate;
	
	@OneToOne
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
	
	@Column(name = "fuel_type")
	private String fuelType;
	
	@Column(name = "dateCreated", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate dateCreated = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();

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

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
