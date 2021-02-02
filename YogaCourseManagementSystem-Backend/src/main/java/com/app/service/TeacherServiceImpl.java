package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Center;
import com.app.pojos.Teacher;
import com.app.repository.TeacherRepository;

@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService {
	// dependency
	@Autowired
	private TeacherRepository dao;
	
	@Autowired
	private ICenterService cdao;
	

	@Override
	public List<Teacher> getAllTeachers() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	
	//  @Override
	//  public Center  getCenterDetails(String cname) 
	 // { 
		  
	//	  return dao.findByName(cname);
		  
	  
	//  }
	 
	   @Override 
		  public Teacher getTeacherDetailsById(int id) 
		  {
			  return dao.findById(id); 
		  }
		 

	@Override //
	public Teacher addTeacherDetails(Teacher p) {  
		Center c=cdao.getCenterDetailsById(p.getCenter().getId());
		Teacher t=new Teacher();
		t.setContactNumber(p.getContactNumber());
		t.setDisability(p.getDisability());
		t.setEmail(p.getEmail());
		t.setExperience(p.getExperience());
		t.setGender(p.getGender());
		t.setPassword(p.getPassword());
		t.setName(p.getName());
		  t.setCenter(c);
	
	  return dao.save(t); 
	  }
	  
	  @Override 
	  public Teacher updateTeacherDetails(int teacherID, Teacher p1) 
	  { 
	  
		  Teacher c=dao.findById(teacherID); 
	      if (c!=null) 
	     { 
		  
		  // p.get() : PERSISTENT // p1 : detached POJO : contains the updates sent by clnt 
		  // change state of persistent POJO 
	    	  Teacher t= c;
	    		t.setContactNumber(p1.getContactNumber());
	    		t.setDisability(p1.getDisability());
	    		t.setEmail(p1.getEmail());
	    		t.setExperience(p1.getExperience());
	    		t.setGender(p1.getGender());
	    		t.setPassword(p1.getPassword());
	    		t.setName(p1.getName());
		  return t;
	  
	  }
	  
	  throw new ResourceNotFoundException("Invalid  ID");

		}
	  
	  @Override
		public String deleteTeacher(int teacherID) {
	  	
			dao.deleteById(teacherID);
			return "Teacher with ID="+teacherID+"deleted.";
		}
		 
}
