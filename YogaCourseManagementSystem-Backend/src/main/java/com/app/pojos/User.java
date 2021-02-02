package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="Name",nullable=false, length=45)
	private String name;
	
	@Column(length=45)
	private String email;
	
	@Column(name="Password",nullable=false, length=45)
	private String password;

	
	@Column(name="Address", length=200)
	private String address;


	@Column(name="Age", length=45)
	private Integer age;

	@Column(name="ContactNumber", length=45)
	private String contactNumber;

	

	@Column(name="Gender", length=45)
	private String gender;

		@Column(name="Role", length=45)
	private String role;

	
//bi-directional many-to-one association to Course
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Course.class)

	@JoinColumn(name="CourseID")
    //@JsonBackReference
   private Course course;

	public User() {
	}
	

  public User(Integer id, String address, Integer age, String contactNumber, String email, String gender,
			String name, String password, String role, Course course) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.gender = gender;
		this.name = name;
		this.password = password;
		this.role = role;
		this.course = course;
	}



	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	

	

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", age=" + age + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", gender=" + gender + ", name=" + name + ", password=" + password + ", role="
				+ role + ", course=" + course + "]";
	}

	
}