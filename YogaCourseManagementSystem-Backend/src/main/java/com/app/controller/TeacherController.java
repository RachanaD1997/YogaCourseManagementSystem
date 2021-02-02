package com.app.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Teacher;
import com.app.service.ITeacherService;


@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods
@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
	@RequestMapping("/teacher")
	public class TeacherController {
		// dependency
		@Autowired
		private ITeacherService service;
	

		public TeacherController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		// RESTful end point or API end point or API provider
		@GetMapping
		@CrossOrigin(origins= {"http://localhost:4200"})

		public ResponseEntity<?> listAllTeacher() {
			System.out.println("in list all ");
			// invoke service layer's method : controller --> service impl (p) --->JPA
			// repo's impl class(SC)
			List<Teacher> teacher = service.getAllTeachers();
			if (teacher.isEmpty())
				// empty  list : set sts code : HTTP 204 (no contents)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// in case of non empty list : OK, send the list
			return  ResponseEntity.ok(teacher);  //200 ok
		}

		// get prduct details by its name : supplied by clnt using path var
		@GetMapping("/{teacherId}")
		@CrossOrigin(origins= {"http://localhost:4200"})

		public ResponseEntity<?> getTeacherDetailsById(@PathVariable int teacherId) {
		System.out.println("in get  details " + teacherId);
			// invoke service method
		Teacher teacherDetails = service.getTeacherDetailsById(teacherId);
			// valid name : HTTP 200 , marshalled center details
		if (teacherDetails!=null)
		return ResponseEntity.ok(teacherDetails);
			// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		 // req handling method to create a new product : post
		  
		  @PostMapping 
		  @CrossOrigin(origins= {"http://localhost:4200"})

		  public ResponseEntity<?> addTeacherDetails(@RequestBody @Valid Teacher p)
		  {
		  System.out.println("in add  " + p); 
		  
		  try { 
			  Teacher c =service.addTeacherDetails(p); 
			  return  ResponseEntity.ok(c);
		  
		  }
		  catch (RuntimeException e) 
		  {
			  e.printStackTrace(); 
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
			  }
		  }
		  
	
		  
		  // req handling method to update existing product
		  
		 @PutMapping("/update/{teacherID}") 
		 @CrossOrigin(origins= {"http://localhost:4200"})

		    public ResponseEntity<?> updateTeacherDetails(@PathVariable int teacherID, @RequestBody Teacher p) 
		 {
		  System.out.println("in update " + teacherID + " " + p); 
		  try 
		  {
			  Teacher updatedDetails = service.updateTeacherDetails(teacherID, p); 
			  return  ResponseEntity.ok(updatedDetails); 
			  } 
		  catch (RuntimeException e)
		  { 
			  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		  
		 }
		 @DeleteMapping("/{teacherID}")
		 @CrossOrigin(origins= {"http://localhost:4200"})

		 public String deleteTeacher(@PathVariable int teacherID)
		 {
			 System.out.println("in delete center"+teacherID);
			 return service.deleteTeacher(teacherID);
			 
		 }
		 
	}



