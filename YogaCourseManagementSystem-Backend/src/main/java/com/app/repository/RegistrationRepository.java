package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.User;

public interface RegistrationRepository extends JpaRepository <User, Integer>
{

	//User  findByName (String Name);
	
	public User findByEmail(String Email);
	public User findByEmailAndPassword(String Email,String Password);

	

	
	//User getDetailsById(int userID);
	
	
}

