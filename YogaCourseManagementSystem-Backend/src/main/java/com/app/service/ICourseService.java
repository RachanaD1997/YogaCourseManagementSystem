package com.app.service;

import java.util.List;
import com.app.pojos.Course;

public interface ICourseService {

	  List<Course> getAllCourses();
	  // get  details by name 
	  Course getCourseDetails(String cname );
	  Course getCourseDetailsById(int id);
	  
	  // add new  details 
	  Course addCourseDetails(Course transientPOJO);
	  
	
	  // update existing  details 
	  Course updateCourseDetails(int courseID, Course detachedPOJO);
	
	String deleteCourse(int courseID);
	
}
