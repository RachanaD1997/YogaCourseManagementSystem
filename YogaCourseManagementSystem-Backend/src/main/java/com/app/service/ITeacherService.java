package com.app.service;

import java.util.List;
import com.app.pojos.Teacher;

public interface ITeacherService {

	  List<Teacher> getAllTeachers();
	  // get  details by name 
	
	  Teacher getTeacherDetailsById(int id);
	  
	  // add new  details 
	  Teacher addTeacherDetails(Teacher transientPOJO);
	  
	
	  // update existing  details 
	  Teacher updateTeacherDetails(int teacherID, Teacher detachedPOJO);
	
	String deleteTeacher(int teacherID);
	
}
