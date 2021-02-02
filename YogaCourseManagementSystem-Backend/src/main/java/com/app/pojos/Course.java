package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	
	private Integer id;
	
	@Column(name="name", length=45)
	private String name;

	@Column(name="BeginDate")
	private LocalDate beginDate;
	
	@Column(name="EndDate")
	private LocalDate endDate;

	@Column(name="Availabilty", length=45)
	private String availability;
	
   @Column(name="Time")
	private LocalTime time;

	@Column(name="Capacity")
	private Integer capacity;

	@Column(name="Duration")
	private double duration;

	
	@Column(name="EligibilityCriteria", length=45)
	private Integer eligibilityCriteria;





	@Column(name="Location", length=200)
	private String location;


	@Column(name="Mode", length=45)
	private String mode;



	@Column(name="Status", length=45)
	private String status;

	@Column(name="Fees", length=45)
	private double fees;
	

	//bi-directional one-to-one association to Teacher
	@OneToOne
	@JoinColumn(name="TeacherID", nullable=false)
	//@JsonBackReference
	private Teacher teacher;

	
	//bi-directional many-to-one association to User

	public Course() {
	}

	
	
	public Course(Integer id, String availability, LocalDate beginDate, Integer capacity, String name,
			double duration, Integer eligibilityCriteria, LocalDate endDate, String location, String mode,
			String status, LocalTime time, Teacher teacher,double fees) {
		super();
		this.id = id;
		this.availability = availability;
		this.beginDate = beginDate;
		this.capacity = capacity;
		this.name = name;
		this.duration = duration;
		this.eligibilityCriteria = eligibilityCriteria;
		this.endDate = endDate;
		this.location = location;
		this.mode = mode;
		this.status = status;
		this.time = time;
		this.teacher = teacher;
		this.fees=fees;
	}



	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public double getDuration() {
		return this.duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}


	public Integer getEligibilityCriteria() {
		return this.eligibilityCriteria;
	}

	public void setEligibilityCriteria(Integer eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public LocalDate getBeginDate() {
		return beginDate;
	}



	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public LocalTime getTime() {
		return time;
	}



	public void setTime(LocalTime time) {
		this.time = time;
	}



	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	

	



	public double getFees() {
		return fees;
	}



	public void setFees(double fees) {
		this.fees = fees;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", availability=" + availability + ", beginDate=" + beginDate
				+ ", capacity=" + capacity + ", name=" + name +  ", duration=" + duration + ", eligibilityCriteria=" + eligibilityCriteria + ", endDate=" + endDate
				+ ", location=" + location + ", mode=" + mode + ", status=" + status + ", time=" + time + ", teacher="
				+ teacher + ", fees=" + fees + "]";
	}

	
	
}