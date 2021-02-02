package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.User;
import com.app.service.RegistrationServiceImpl;


@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods

@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {
	@Autowired
	public RegistrationServiceImpl service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public  User registerUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		if(tempEmail!=null  && "".equals(tempEmail)) {
			User userobj=service.fetchUserByEmail(tempEmail);
			if(userobj !=null) {
				throw new Exception("User this id "+tempEmail+"is already exist");
			}
			
		}
		User userobj = null;
		userobj=service.saveUser(user);
		if (userobj != null) {
			 service.sendAccountRegisterEmail(userobj);
				return userobj;
			}
			return null;
	
		
		
		
}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		String tempPass=user.getPassword();
		
		User userobj=null;
		if(tempEmail !=null  && tempPass!=null) {
			userobj=service.fetchUserByEmailAndPaasword(tempEmail, tempPass);
		}
		if(userobj ==null) {
			throw new Exception("Bad crendetial");
		}
		return userobj;
	}
}
	
	
	
	