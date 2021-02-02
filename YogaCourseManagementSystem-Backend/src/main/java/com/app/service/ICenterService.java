package com.app.service;

import java.util.List;


import com.app.pojos.Center;

public interface ICenterService {

	  List<Center> getAllCenters();
	  // get  details by name 
	Center getCenterDetails(String cname );
	Center getCenterDetailsById(int id);
	  
	  // add new  details 
	Center addCenterDetails(Center transientPOJO);
	
	Center findByManager(int id);
	  
	
	  // update existing  details 
	Center updateCenterDetails(int centerID, Center detachedPOJO);
	
	String deleteCenter(int centerID);
	
}
