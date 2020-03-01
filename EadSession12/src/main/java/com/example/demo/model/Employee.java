package com.example.demo.model;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employeedetails")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private int id;
	@NotBlank
	@Column(name = "EmployeeName")
	private String fullName;
	@NotNull
	@Column(name = "Gender")
	private String gender;
	@NotBlank
	@Email
	@Column(name = "Mail")
	private String mail;
	@NotBlank
	@Column(name = "Password")
	private String password;
	@NotBlank
	@Column(name = "Contact")
	private String contactDetails;
	@NotNull
	@Column(name = "Organisation")
	private String organisation;
	@Column(name = "imageName")
	private String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@javax.persistence.Transient
	private String confirmPassword;

	public Employee() {

	}

	public Employee(int id, String contact, String fullName, String gender, String mail, String organisation) {

		this.id = id;

		this.contactDetails = contact;
		this.fullName = fullName;
		this.gender = gender;

		this.mail = mail;
		this.organisation = organisation;
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
