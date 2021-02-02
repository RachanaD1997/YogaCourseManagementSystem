package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;

import com.app.repository.AdminRepository;


@Service
@Transactional
public class AdminServiceImpl  {
	// dependency
	@Autowired
	private AdminRepository dao;
	
	
	public Admin fetchAdminByEmailAndPaasword(String email,String password) {
		return dao.findByEmailAndPassword(email,password);
		
	}
	
}