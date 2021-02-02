package com.app.service;


import com.app.pojos.Admin;

public interface IAdminService {
	
	
	  Admin fetchAdminByEmailAndPassword(String email, String password);
	  
	 
}
