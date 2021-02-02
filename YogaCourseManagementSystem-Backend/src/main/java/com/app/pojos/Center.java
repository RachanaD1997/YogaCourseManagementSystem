package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the center database table.
 * 
 */
@Entity
@Table(name="center")
@NamedQuery(name="Center.findAll", query="SELECT c FROM Center c")
public class Center implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	
	private Integer id;

	
	@Column(name="name",nullable=false, length=45)
	private String name;
	
	@Column(name="Address",nullable=false, length=200)
	private String address;


	@Column(name="ContactNumber",nullable=false, length=45)
	private String contactNumber;

	

	//bi-directional many-to-one association to Teacher
	@OneToMany(mappedBy="center")
	

	//bi-directional one-to-one association to Manager
	@OneToOne
	@JoinColumn(name = "ManagerID",nullable = false)
   private Manager manager;

	public Center() {
	}
	
	public Center(Integer id, String address, String name, String contactNumber,
			Manager manager) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.contactNumber = contactNumber;
	
		this.manager = manager;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}




	

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Center [id=" + id + ", address=" + address + ", name=" + name
				+ ", contactNumber=" + contactNumber + ", manager=" + manager + "]";
	}

	
}