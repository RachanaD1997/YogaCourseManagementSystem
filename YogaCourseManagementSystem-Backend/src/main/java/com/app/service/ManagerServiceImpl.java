package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Manager;
import com.app.repository.ManagerRepository;


@Service
@Transactional
public class ManagerServiceImpl implements IManagerService {
	// dependency
	@Autowired
	private ManagerRepository dao;

	@Override
	public List<Manager> getAllManager() {
		return dao.findAll();
	}

	
	/*
	 * @Override public Manager getManagerDetails(String firstname) {
	 * 
	 * return dao.findByFirstName(firstname); }
	 */


	
	 @Override 
	 public Manager getManagerDetailsById(int id)
	   { 
		 return dao.findById(id); 
	   }
		
	
	  @Override 
	public Manager addManagerDetails(Manager transientPOJO) {  
	

	  return dao.save(transientPOJO); 
	  }
	  
	  @Override 
	  public Manager updateManagerDetails(int managerID, Manager p1) 
	  { 
	  
	  Manager p =dao.findById(managerID); 
	  if (p!=null) 
	  { 
		  // p.get() : PERSISTENT // p1 : detached POJO : contains the updates sent by clnt 
		  // change state of persistent POJO 
	  Manager manager = p;
	  manager.setFirstName(p1.getFirstName());
	  manager.setLastName(p1.getLastName());
	  manager.setContactNumber(p1.getContactNumber());
	  manager.setEmail(p1.getEmail());
	  manager.setPassword(p1.getPassword());
	  manager.setExperience(p1.getExperience());

	  return manager;
	  
	  }
	  
	  //in case of no Manager found : throw custom exception
	  throw new ResourceNotFoundException("Invalid Manager ID");

		}

	@Override
	public String deleteManager(int managerID) {
  		
		dao.deleteById(managerID);
		return "Manager with ID="+managerID+"deleted.";
	}
		 
	@Override
	  public Manager fetchManagerByEmailAndPassword(String email,String password){
		  return dao.findByEmailAndPassword(email, password);
	  }


	
	
	
}
