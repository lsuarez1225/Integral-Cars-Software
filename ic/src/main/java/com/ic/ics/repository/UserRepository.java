package com.ic.ics.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ic.ics.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public Optional<User> findByUsername(String userName);
}
