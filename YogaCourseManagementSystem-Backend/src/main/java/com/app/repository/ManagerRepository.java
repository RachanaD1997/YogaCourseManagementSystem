package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Manager;
import com.app.pojos.User;

public interface ManagerRepository extends JpaRepository <Manager, Integer>
{
	 //search by Manager name 
		//Manager  findByFirstName (String firstName);
	    Manager findById(int id);
		public Manager findByEmailAndPassword(String Email,String Password);
	//	void deleteByName(String firstname);


}

