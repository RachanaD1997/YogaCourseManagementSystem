package com.app.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.app.pojos.Course;
import com.app.service.ICourseService;


@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
	@RequestMapping("/course")
	public class CourseController {
		// dependency
		@Autowired
		private ICourseService service;
	

		public CourseController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		// RESTful end point or API end point or API provider
		@GetMapping
		@CrossOrigin(origins= {"http://localhost:4200"})

		public ResponseEntity<?> listAllCourse() {
			System.out.println("in list all ");
			// invoke service layer's method : controller --> service impl (p) --->JPA
			// repo's impl class(SC)
			List<Course> course = service.getAllCourses();
			if (course.isEmpty())
				// empty  list : set sts code : HTTP 204 (no contents)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// in case of non empty list : OK, send the list
			return  ResponseEntity.ok(course);  //200 ok
		}

		// get prduct details by its name : supplied by clnt using path var
		@GetMapping("/{courseId}")
		@CrossOrigin(origins= {"http://localhost:4200"})

		public ResponseEntity<?> getCourseDetailsById(@PathVariable int courseId) {
		System.out.println("in get  details " + courseId);
			// invoke service method
		Course Details = service.getCourseDetailsById(courseId);
			// valid name : HTTP 200 , marshalled center details
		if (Details!=null)
		return ResponseEntity.ok(Details);
			// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		  @GetMapping("/name/{courseName}")
		  @CrossOrigin(origins= {"http://localhost:4200"})

		  public ResponseEntity<?>getCourseDetails(@PathVariable String courseName) 
		  {
		  System.out.println("in get  details " + courseName); 
		  // invoke s  method
		  Course Details = service.getCourseDetails(courseName);
		  //valid name : HTTP 200 , marshalled center details 
		  if (Details!=null)
		  return ResponseEntity.ok(Details); // in case of invalid name : HTTP404
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		 
		
		
		  @PostMapping 
		  @CrossOrigin(origins= {"http://localhost:4200"})

		  public ResponseEntity<?> addCourseDetails(@RequestBody @Valid Course p)
		  {
		  System.out.println("in add center " + p); 
		  
		  try { 
			  Course c =service.addCourseDetails(p); 
			  return  ResponseEntity.ok(c);
		  
		  }
		  catch (RuntimeException e) 
		  {
			  e.printStackTrace(); 
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
			  }
		  }
		  
		  
		 @PutMapping("/update/{courseID}") 
		 @CrossOrigin(origins= {"http://localhost:4200"})

		    public ResponseEntity<?> updateCourseDetails(@PathVariable int courseID, @RequestBody Course p) 
		 {
		  System.out.println("in update " + courseID + " " + p); 
		  try 
		  {
			  Course updatedDetails = service.updateCourseDetails(courseID, p); 
			  return  ResponseEntity.ok(updatedDetails); 
			  } 
		  catch (RuntimeException e)
		  { 
			  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		  
		 }
		 @DeleteMapping("/{courseID}")
		 @CrossOrigin(origins= {"http://localhost:4200"})

		 public String deleteCourse(@PathVariable int courseID)
		 {
			 System.out.println("in delete center"+courseID);
			 return service.deleteCourse(courseID);
			 
		 }
		 
	}



