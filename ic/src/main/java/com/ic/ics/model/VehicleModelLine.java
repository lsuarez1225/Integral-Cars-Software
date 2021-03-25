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
@Table(name = "\"vehicle_model_line\"")
public class VehicleModelLine {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "model_id", referencedColumnName = "id")
	private VehicleModel vehicleModel;
	
	@OneToOne
	@JoinColumn(name = "line_id", referencedColumnName = "id")
	private VehicleLine vehicleLine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public VehicleLine getVehicleLine() {
		return vehicleLine;
	}

	public void setVehicleLine(VehicleLine vehicleLine) {
		this.vehicleLine = vehicleLine;
	}
	
}
