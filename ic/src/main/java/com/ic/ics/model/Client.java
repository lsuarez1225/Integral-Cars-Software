package com.ic.ics.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "nid_type", referencedColumnName = "id")
	private NidType nidType;
	
	@Column(name = "nid")
	private String nid;
	
	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_1")
	private String phone1;
	
	@Column(name = "phone_2")
	private String phone2;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "date_created", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate dateCreated = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();
	
	@Column(name = "active", nullable = false, columnDefinition = "boolean DEFAULT 'true'")
	private Boolean active = true;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "direction")
	private String direction;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "clients_vehicles", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
	private Set<Vehicle> vehicle;

	public Set<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public NidType getNidType() {
		return nidType;
	}
	
	public void setNidType(NidType nidType) {
		this.nidType = nidType;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contact_name) {
		this.contactName = contact_name;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
