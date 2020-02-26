package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Employee {

	
	private int id;
	@NotBlank
	private String fullName;
	@NotNull
	private String gender;
	@NotBlank
	@Email
	private String mail;
	@NotBlank
	private String password;
	@NotBlank
	private String contactDetails;
	@NotNull
	private String organisation;
	
	
	private String confirmPassword;

	
	public Employee () {
		
	}
	public Employee(int id, String fullName, String gender, String mail, String organisation, String contact) {
	
		this.id = id;
		this.fullName=fullName;
		this.gender= gender;
		this.contactDetails=contact;
		this.organisation=organisation;
		this.mail=mail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", gender=" + gender + ", mail=" + mail + ", password="
				+ password + ", contactDetails=" + contactDetails + ", organisation=" + organisation + ", contact="
				+ "]";
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	

}
