package com.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Teacher;



public interface TeacherRepository extends JpaRepository <Teacher, Integer>
{
	
		//Teacher findByName(String cname);
		Teacher findById(int id);
}