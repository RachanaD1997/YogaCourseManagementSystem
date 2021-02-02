package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)

	private Integer id;
	
	@Column(name="Name",nullable=false, length=45)
	private String Name;

	@Column(name="Email",nullable=false, length=45)
	private String email;

	@Column(name="Password",nullable=false, length=45)
	private String password;
	
	@Column(name="ContactNumber",nullable=false, length=45)
	private String contactNumber;

	@Column(name="Disability",nullable=false, length=45)
	private String disability;


	@Column(name="Experince",nullable=false, length=45)
	private Integer experience;

	@Column(name="Gender",nullable=false, length=10)
	private String gender;

	


	//bi-directional many-to-one association to Course
	@OneToOne(mappedBy = "teacher",cascade = CascadeType.ALL)	
	private Course course;

	//bi-directional many-to-one association to Center
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Center.class)

	@JoinColumn(name="CenterId", nullable=false)
	//@JsonBackReference
    private Center center;

	public Teacher() {
	}

	
	
	public Teacher(Integer id, String contactNumber, String disability, String email, Integer experience,
			String gender, String password, String Name,Center center) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
		this.disability = disability;
		this.email = email;
		this.experience = experience;
		this.gender = gender;
		this.password = password;
		this.Name = Name;
		this.center = center;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDisability() {
		return this.disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}


	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", contactNumber=" + contactNumber + ", disability=" + disability
				+ ", email=" + email + ", experience=" + experience + ", gender=" + gender + ", password=" + password
				+ ", Name=" + Name +  ", center=" + center + "]";
	}
	
	

}