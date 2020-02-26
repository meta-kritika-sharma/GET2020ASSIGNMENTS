package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class Pass {

	@NotBlank
	private String passChoice;
	private int dailypassValue;
	private int monthlypassValue;
	private int yearlypassValue;
	public String getPassChoice() {
		return passChoice;
	}
	public void setPassChoice(String passChoice) {
		this.passChoice = passChoice;
	}
	public int getDailypassValue() {
		return dailypassValue;
	}
	public void setDailypassValue(int dailypassValue) {
		this.dailypassValue = dailypassValue;
	}
	public int getMonthlypassValue() {
		return monthlypassValue;
	}
	public void setMonthlypassValue(int monthlypassValue) {
		this.monthlypassValue = monthlypassValue;
	}
	public int getYearlypassValue() {
		return yearlypassValue;
	}
	public void setYearlypassValue(int yearlypassValue) {
		this.yearlypassValue = yearlypassValue;
	}
  	
}
