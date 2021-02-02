package com.app.service;

import java.util.List;


import com.app.pojos.Manager;

public interface IManagerService {
	
	List<Manager> getAllManager();

	// get Manager details by name 
	//Manager getManagerDetails(String firstname  );
	
	 Manager getManagerDetailsById(int id);
	  
	  // add new Manager details 
	  Manager addManagerDetails(Manager transientPOJO);
	  
	   // update existing  
	  Manager updateManagerDetails(int managerID, Manager detachedPOJO);
	  
	  String deleteManager(int managerID);
	  
	  //String deleteManagerByName(String firstname);
	  
	  Manager fetchManagerByEmailAndPassword(String email, String password);
	  
	 
}
