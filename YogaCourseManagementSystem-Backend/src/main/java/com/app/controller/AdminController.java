package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Admin;

import com.app.service.AdminServiceImpl;


@RestController // => @Controller at class level +
public class AdminController {
	@Autowired
	public AdminServiceImpl service;
	
	

	@PostMapping("/adminlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception {
		String tempEmail=admin.getEmail();
		String tempPass=admin.getPassword();
		
		Admin obj=null;
		if(tempEmail !=null  && tempPass!=null) {
			obj=service.fetchAdminByEmailAndPaasword(tempEmail, tempPass);
		}
		if(obj ==null) {
			throw new Exception("Bad crendetial");
		}
		return obj;
	}
}
	
	
	
	