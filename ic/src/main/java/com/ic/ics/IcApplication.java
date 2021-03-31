package com.ic.ics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ic.ics.model.FuelType;
import com.ic.ics.model.VehicleModel;
import com.ic.ics.repository.UserRepository;
import com.ic.ics.service.NidTypeService;
import com.ic.ics.service.VehicleService;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class IcApplication implements CommandLineRunner {

	@Autowired
	NidTypeService nidTypeService;
	
	@Autowired
	VehicleService vehicleService;
	
	public static void main(String[] args) {
		SpringApplication.run(IcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//nidTypeService.addTypes(); //TODO: Solo para despliegue.
		//vehicleService.addInitializationData(); //TODO: Solo para despliegue.
	}
}
