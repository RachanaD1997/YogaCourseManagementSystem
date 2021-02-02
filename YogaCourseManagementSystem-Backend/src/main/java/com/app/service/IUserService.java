package com.app.service;

import java.util.List;



import com.app.pojos.User;

public interface IUserService {

	  List<User> getAllUsers();
	  // get  details by name 
	  User getUserDetails(String cname );
	  User getUserDetailsById(int id);
	  
	  // add new  details 
	  User addUserDetails(User transientPOJO);
	  
	
	  // update existing  details 
	  User updateUserDetails(int userID, User detachedPOJO);
	
	String deleteUser(int userID);
	
	

}
