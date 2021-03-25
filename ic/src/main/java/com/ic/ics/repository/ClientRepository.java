package com.ic.ics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ic.ics.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("FROM Client WHERE business_name LIKE %:value% OR city LIKE %:value% OR contact_name LIKE %:value% OR TO_CHAR(date_created, 'YYYY-MM-DD') LIKE %:value% OR direction LIKE %:value% OR email LIKE %:value% OR first_name LIKE %:value% OR last_name LIKE %:value% OR nid LIKE %:value% OR web LIKE %:value% OR phone_1 LIKE %:value% OR phone_2 LIKE %:value%")
	public List<Client> findAll (String value);
}
