package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;

import com.app.pojos.Course;
import com.app.pojos.Teacher;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
	// dependency
	@Autowired
	private CourseRepository dao;
	
	@Autowired
	private ITeacherService mdao;
	

	@Override
	public List<Course> getAllCourses() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	
	@Override
	  public Course  getCourseDetails(String cname) 
	 { 
		  
	  return dao.findByName(cname);
		  
	  
	  }
	 
	   @Override 
		  public Course getCourseDetailsById(int id) 
		  {
			  return dao.findById(id); 
		  }
		 

	@Override //
	public Course addCourseDetails(Course p) {  
	Teacher m=mdao.getTeacherDetailsById(p.getTeacher().getId());
	 Course c=new Course();
	  c.setName(p.getName());
	  c.setLocation(p.getLocation());
	  c.setAvailability(p.getAvailability());
	  c.setBeginDate(p.getBeginDate());
		c.setCapacity(p.getCapacity()); 
		c.setDuration(p.getDuration());
		c.setEligibilityCriteria(p.getEligibilityCriteria());
		c.setEndDate(p.getEndDate());
		c.setMode(p.getMode());
		c.setStatus(p.getStatus());
		c.setTime(p.getTime());
		c.setFees(p.getFees());
		c.setTeacher(m);
	
	  return dao.save(c); 
	  }
	  
	  @Override 
	  public Course updateCourseDetails(int courseID, Course p1) 
	  { 
		//	  chk if product exists : findById
	  
		  Course c=dao.findById(courseID); 
	  if (c!=null) 
	  { 
		  
		  // p.get() : PERSISTENT // p1 : detached POJO : contains the updates sent by clnt 
		  // change state of persistent POJO 
		  Course course = c;
	
		  course.setName(p1.getName());
		  course.setLocation(p1.getLocation());
		  course.setAvailability(p1.getAvailability());
		  course.setBeginDate(p1.getBeginDate());
		  course.setCapacity(p1.getCapacity()); 
		  course.setDuration(p1.getDuration());
		  course.setEligibilityCriteria(p1.getEligibilityCriteria());
		  course.setEndDate(p1.getEndDate());
		  course.setMode(p1.getMode());
		  course.setStatus(p1.getStatus());
		  course.setTime(p1.getTime());
		  return course;
	  
	  }
	  
		//in case of no product found : throw custom exception
	  throw new ResourceNotFoundException("Invalid  ID");

		}
	  
	  @Override
		public String deleteCourse(int courseID) {
	  		
			dao.deleteById(courseID);
			return "Manager with ID="+courseID+"deleted.";
		}
		 
}
