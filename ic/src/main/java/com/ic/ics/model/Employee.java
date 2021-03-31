package com.ic.ics.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	private enum PersonType {
		NS, JC, NC
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "person_type")
	@Enumerated(EnumType.STRING)
	private PersonType person_type;
	
	@Column(name = "date_entered", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate dateEntered = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
	@Column(name = "date_exit", nullable = false, columnDefinition = "date")
	private LocalDate dateExit = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
}
