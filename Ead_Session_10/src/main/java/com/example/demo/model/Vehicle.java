package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class Vehicle {

	@NotBlank
	private String vehicleName;
	@NotBlank
	private String vehicleType;
	@NotBlank
	private String vehicleNumber;
	@NotBlank
	private String description;

	private String plan;
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

	@Override
	public String toString() {
		return "Vehicle [vehicleName=" + vehicleName + ", vehicleType=" + vehicleType + ", vehicleNumber="
				+ vehicleNumber + ", plan=" + plan + ", price=" + price + ", description=" + description + "]";
	}
	
	
}
