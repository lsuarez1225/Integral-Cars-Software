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
@Table(name = "\"work_order_service\"")
public class WorkOrderService {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "work_order_id", referencedColumnName = "id")
	private WorkOrder workOrderId;
	
	@OneToOne
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	private Service service;
}
