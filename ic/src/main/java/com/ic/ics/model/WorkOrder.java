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
@Table(name = "work_order")
public class WorkOrder {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "number")
	private Integer number;
	
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client clientId;
	
	@OneToOne
	@JoinColumn(name = "vehicle_id", referencedColumnName = "id")
	private Vehicle vehicleId;
	
	@Column(name = "client_request")
	private String client_request;
	
	@Column(name = "dateEntered", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate dateEntered = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
	@Column(name = "datePromised", nullable = false, columnDefinition = "date")
	private LocalDate datePromisse = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
	@Column(name = "dateExit", nullable = false, columnDefinition = "date")
	private LocalDate dateExit = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
	@Column(name = "satuts")
	private String status;
}
