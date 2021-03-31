package com.ic.ics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ic.ics.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	@Query("FROM Vehicle WHERE chassis_number LIKE %:value% OR color LIKE %:value% OR TO_CHAR(date_created, 'YYYY-MM-DD') LIKE %:value% OR motor_number LIKE %:value% OR plate LIKE %:value% OR year_model LIKE %:value%")
	public List<Vehicle> findAll(String value);
}
