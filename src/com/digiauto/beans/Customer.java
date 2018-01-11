package com.digiauto.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "customerContact")
	private String customerContact;
	
	@Column(name = "cutomerAddress")
	private String cutomerAddress;
	
	@Column(name = "drivingLicenceNumber")
	private String drivingLicenceNumber;
	
	@Column(name = "issueDate")
	private String issueDate;
	
	@Column(name = "expiryDate")
	private String expiryDate;
	
	@Column(name = "carId")
	private String carId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCutomerAddress() {
		return cutomerAddress;
	}
	public void setCutomerAddress(String cutomerAddress) {
		this.cutomerAddress = cutomerAddress;
	}
	public String getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}
	public void setDrivingLicenceNumber(String drivingLicenceNumber) {
		this.drivingLicenceNumber = drivingLicenceNumber;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return customerName+" "+customerContact+" "+cutomerAddress;
	}
}
