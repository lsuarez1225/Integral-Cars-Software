package com.ic.ics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles_models_lines")
public class VehicleModelLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "vehicle_model_id", referencedColumnName = "id")
	private VehicleModel vehicleModel;
	
	public VehicleModelLine() {
		
	}
	
	public VehicleModelLine(Long id) {
		this.id = id;
	}

	public VehicleModelLine(VehicleModel vehicleModel, String name) {
		this.vehicleModel = vehicleModel;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
}
