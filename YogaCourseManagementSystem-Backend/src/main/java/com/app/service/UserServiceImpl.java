package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;

import com.app.pojos.Course;

import com.app.pojos.User;

import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	// dependency
	@Autowired
	private UserRepository dao;
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ICourseService mdao;
	

	@Override
	public List<User> getAllUsers() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	
	@Override
	  public User  getUserDetails(String cname) 
	 { 
		  
	  return dao.findByName(cname);
	 }
	 
	   @Override 
		  public User getUserDetailsById(int id) 
		  {
			  return dao.findById(id); 
		  }
		 

	@Override //
	public User addUserDetails(User p) {  
	Course m=mdao.getCourseDetailsById(p.getCourse().getId());
	User c=new User();
	
	c.setName(p.getName());
	c.setAge(p.getAge());
	c.setEmail(p.getEmail());
	c.setGender(p.getGender());
	c.setPassword(p.getPassword());
	c.setRole(p.getRole());
	c.setAddress(p.getAddress());
    c.setContactNumber(p.getContactNumber());
	c.setCourse(m);
	
	  return dao.save(c); 
	  }
	  
	  @Override 
	  public User updateUserDetails(int userID, User p1) 
	  { 
		//	  chk if product exists : findById
	  
		  User c=dao.findById(userID); 
	  if (c!=null) 
	  { 
		  User user = c;
		  user.setAge(p1.getAge());
		  user.setGender(p1.getGender());
		  user.setRole(p1.getRole());
		  user.setAddress(p1.getAddress());
		  user.setContactNumber(p1.getContactNumber());
		  return user;
	  
	  }
	  throw new ResourceNotFoundException("Invalid  ID");

		}
	  
	  @Override
		public String deleteUser(int userID) {
	  		
			dao.deleteById(userID);
			return "Manager with ID="+userID+"deleted.";
		}


	
}
