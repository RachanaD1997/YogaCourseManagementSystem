package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
import com.app.repository.RegistrationRepository;

@Service
@Transactional
public class RegistrationServiceImpl  {
	// dependency
	@Autowired
	private RegistrationRepository dao;
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	public User saveUser(User user) {
		 return dao.save(user);
		
	}
	public User fetchUserByEmail(String email) {
		return dao.findByEmail(email);
		
	}
	public User fetchUserByEmailAndPaasword(String email,String password) {
		return dao.findByEmailAndPassword(email,password);
		
	}
	
	public void sendAccountRegisterEmail(User user) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailUser = new SimpleMailMessage();
		mailUser.setTo(user.getEmail());
		mailUser.setFrom("yogawebsite0@gmail.com");
		mailUser.setSubject("User Account Successfully Registerd !" + user.getName());
		mailUser.setText("Account Registered Successfully your \n User Id : "+ user.getId() + "\n Password :" + user.getPassword());
		mailSender.send(mailUser);
		
	}
	
}