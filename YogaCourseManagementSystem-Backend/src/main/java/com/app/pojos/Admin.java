package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;


import javax.validation.constraints.NotBlank;

@Entity
@Table(name="admin")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	
	
	
	private Integer id;

	
	public Admin() {
		super();
	}

	@NotBlank(message="Name must be supplied")
	@Column(name="Name",nullable=false, length=45)
	private String name;

	
	@NotBlank(message="Email must be supplied")
	@Column(name="Email",nullable=false, length=45)
	private String email;
	
	@Column(name="Password",nullable=false, length=45)
	private String password;

	public Admin(Integer id, @NotBlank(message = "Name must be supplied") String name,
			@NotBlank(message = "Email must be supplied") String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
	
	