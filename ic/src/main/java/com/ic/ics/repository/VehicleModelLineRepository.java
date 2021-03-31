package com.ic.ics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ic.ics.model.VehicleModelLine;

public interface VehicleModelLineRepository extends JpaRepository<VehicleModelLine, Long>{

	@Query("FROM VehicleModelLine WHERE vehicle_model_id = :id")
	public List<VehicleModelLine> findByVehicleModel(Long id);
}
