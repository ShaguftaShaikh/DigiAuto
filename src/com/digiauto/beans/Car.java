package com.digiauto.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customercar")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@Column(name = "carNumber")
	private String carNumber;

	@Column(name = "engineNumber")
	private String engineNumber;

	@Column(name = "chassisNumber")
	private String chassisNumber;

	@Column(name = "rcBook")
	private String rcBook;

	@Column(name = "insurancePolicyNumber")
	private String insurancePolicyNumber;

	public Car() {
	}

	public Car(long id, String carNumber, String enigineNumber, String chassisNumber) {
		this.id = id;
		this.carNumber = carNumber;
		this.engineNumber = enigineNumber;
		this.chassisNumber = chassisNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getRcBook() {
		return rcBook;
	}

	public void setRcBook(String rcBook) {
		this.rcBook = rcBook;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public Car(long id, String carNumber, String enigineNumber, String chassisNumber, String rcBook,
			String insurancePolicyNumber) {
		this.id = id;
		this.carNumber = carNumber;
		this.engineNumber = enigineNumber;
		this.chassisNumber = chassisNumber;
		this.rcBook = rcBook;
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

}
