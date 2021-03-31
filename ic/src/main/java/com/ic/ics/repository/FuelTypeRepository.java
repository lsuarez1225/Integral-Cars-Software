package com.ic.ics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ic.ics.model.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long>{

}
