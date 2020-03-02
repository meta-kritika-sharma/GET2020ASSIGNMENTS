package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "vehicledetails")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VehicleId")
	private int vehicleId;
	// @Column(name = "EmployeeId")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EmployeeId")
	private Employee employee;

	@NotBlank
	@Column(name = "VehicleName")
	private String vehicleName;
	@NotBlank
	@Column(name = "VehicleType")
	private String vehicleType;
	@NotBlank
	@Column(name = "VehicleNumber")
	private String vehicleNumber;
	@NotBlank
	@Column(name = "Description")
	private String description;
	@Column(name = "Plan")
	private String plan;
	@Column(name = "Price")
	private int price;

	public Vehicle(String vehicleName, String vehicleType, String vehicleNumber, String plan, int price,
			String description) {
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.plan = plan;
		this.price = price;
		this.description = description;
	}

	public Vehicle() {

	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleName=" + vehicleName + ", vehicleType=" + vehicleType + ", vehicleNumber="
				+ vehicleNumber + ", plan=" + plan + ", price=" + price + ", description=" + description + "]";
	}

}
