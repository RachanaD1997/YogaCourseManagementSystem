package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;


import javax.validation.constraints.NotBlank;

@Entity
@Table(name="manager")
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	
	
	private Integer id;

	@NotBlank(message="address  can't be blank")
	@Column(name="Address",nullable=false, length=45)
	private String address;

	@NotBlank(message="FirstName must be supplied")
	@Column(name="FirstName",nullable=false, length=45)
	private String firstName;


	@NotBlank(message="LastName must be supplied")
	@Column(name="LastName",nullable=false, length=45)
	private String lastName;
	
	
	@NotBlank(message="Email must be supplied")
	@Column(name="Email",nullable=false, length=45)
	private String email;
	
	@Column(name="Password",nullable=false, length=45)
	private String password;
	
	@Column(name="ContactNumber",nullable=false, length=45)
	private String contactNumber;

	
	@Column(name="Experience",nullable=false)
	private Integer experience;
	
	//bi-directional one-to-one association to Center
	
	@OneToOne(mappedBy = "manager")	
	private Center center;

	public Manager() {
	}
	
	public Manager(Integer id, String address, String contactNumber, String email, Integer experience,
			String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.experience = experience;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	
	}

	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getExperience() {
		return this.experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Manager [id=" + id + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", experience=" + experience + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password +  "]";
	}
	
	
	
	
	

}

