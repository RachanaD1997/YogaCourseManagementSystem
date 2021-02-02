package com.app.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



import com.app.pojos.User;
import com.app.service.IUserService;


@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods
//@CrossOrigin(origins= {"http://localhost:4200"})
@Validated
	@RequestMapping("/user")
	public class UserController {
		// dependency
		@Autowired
		private IUserService service;
	

		public UserController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		// RESTful end point or API end point or API provider
		@GetMapping
		@CrossOrigin(origins= {"http://localhost:4200"})

		public ResponseEntity<?> listAllUser() {
			System.out.println("in list all ");
			// invoke service layer's method : controller --> service impl (p) --->JPA
			// repo's impl class(SC)
			List<User> User = service.getAllUsers();
			if (User.isEmpty())
				// empty  list : set sts code : HTTP 204 (no contents)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// in case of non empty list : OK, send the list
			return  ResponseEntity.ok(User);  //200 ok
		}
		
		// get prduct details by its name : supplied by clnt using path var
		@GetMapping("/{UserID}")
		@CrossOrigin(origins= {"http://localhost:4200"})

		public ResponseEntity<?> getUserDetailsById(@PathVariable int UserID) {
		System.out.println("in get  details " + UserID);
			// invoke service method
		User Details = service.getUserDetailsById(UserID);
			// valid name : HTTP 200 , marshalled center details
		if (Details!=null)
		return ResponseEntity.ok(Details);
			// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		  @GetMapping("/name/{userName}")
		  @CrossOrigin(origins= {"http://localhost:4200"})

		  public ResponseEntity<?>getUserDetails(@PathVariable String userName) 
		  {
		  System.out.println("in get  details " + userName); 
		  // invoke s  method
		  User Details = service.getUserDetails(userName);
		  //valid name : HTTP 200 , marshalled center details 
		  if (Details!=null)
		  return ResponseEntity.ok(Details); // in case of invalid name : HTTP404
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		 
		
		
		  @PostMapping 
		  @CrossOrigin(origins= {"http://localhost:4200"})

		  public ResponseEntity<?> addUserDetails(@RequestBody @Valid User p)
		  {
		  System.out.println("in add center " + p); 
		  
		  try { 
			  User c =service.addUserDetails(p); 
			  return  ResponseEntity.ok(c);
		  
		  }
		  catch (RuntimeException e) 
		  {
			  e.printStackTrace(); 
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
			  }
		  }
		  
		  
		 @PutMapping("/update/{userID}")
		 @CrossOrigin(origins= {"http://localhost:4200"})

		    public ResponseEntity<?> updateCourseDetails(@PathVariable int userID, @RequestBody User p) 
		 {
		  System.out.println("in update " + userID + " " + p); 
		  try 
		  {
			  User updatedDetails = service.updateUserDetails(userID, p); 
			  return  ResponseEntity.ok(updatedDetails); 
			  } 
		  catch (RuntimeException e)
		  { 
			  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
		  
		 }
		 @DeleteMapping("/{userID}")
		 @CrossOrigin(origins= {"http://localhost:4200"})

		 public String deleteUser(@PathVariable int userID)
		 {
			 System.out.println("in delete center"+userID);
			 return service.deleteUser(userID);
			 
		 }
		 
	}



