package com.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Manager;
import com.app.service.IManagerService;

@RestController // => @Controller at class level +
	//@ResponseBody annotation added on ret types of all req handling methods
@CrossOrigin(origins = "http://localhost:4200")	
@RequestMapping("/manager")
	public class ManagerController {
		// dependency
		@Autowired
		private IManagerService service;

		public ManagerController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		// RESTful end point or API end point or API provider
		//for retrieve the details of one manager
		@GetMapping
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> listAllManager() {
			System.out.println("in list all manager");
			// invoke service layer's method : controller --> service impl (p) --->JPA
			// repo's impl class(SC)
			List<Manager> manager = service.getAllManager();
			if (manager.isEmpty())
				// empty  list : set sts code : HTTP 204 (no contents)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// in case of non empty list : OK, send the list
			return  ResponseEntity.ok(manager);
		}

		// get manager details by its name : supplied by clnt using path var
		
		/*
		 * @GetMapping("/{managerName}") public ResponseEntity<?>
		 * getManagerDetails(@PathVariable String managerName) {
		 * System.out.println("in get  details " + managerName); // invoke service
		 * method Manager managerDetails = service.getManagerDetails(managerName); //
		 * valid name : HTTP 200 , marshalled center details if (managerDetails!=null)
		 * return ResponseEntity.ok(managerDetails); // in case of invalid name : HTTP
		 * 404 return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 */
		
		 

		@GetMapping("/{managerId}")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> getManagerDetailsById(@PathVariable  int managerId) 
		{
			System.out.println("in get Manager details " + managerId);
			// invoke service method
			Manager managerDetails = service.getManagerDetailsById(managerId);
			// valid name : HTTP 200 , 
			if (managerDetails !=null)
				return  ResponseEntity.ok(managerDetails);
						// in case of invalid name : HTTP 404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
		  // req handling method to create a new manager : post
		  
		  @PostMapping
		  @CrossOrigin(origins = "http://localhost:4200")
		  public ResponseEntity<?> addManagerDetails(@RequestBody Manager m)
		  
		  {
			  System.out.println("in add manager " + m); 
			  
			  try { 
				  Manager m1 =service.addManagerDetails(m); 
				  return  ResponseEntity.ok(m1);
			  
			  }
			  catch (RuntimeException e) 
			  {
				  e.printStackTrace(); 
				  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
				  }
			  }
		  
		  // req handling method to update existing Manager data
		  
		 @PutMapping("/{managerID}") 
		 @CrossOrigin(origins = "http://localhost:4200")
		    public ResponseEntity<?> updateManagerDetails(@PathVariable int managerID, @RequestBody Manager m) 
		 {
			  System.out.println("in update " + managerID + " " + m); 
			  try 
			  {
				  Manager updatedDetails = service.updateManagerDetails(managerID, m); 
				  return  ResponseEntity.ok(updatedDetails); 
				  } 
			  catch (RuntimeException e)
			  { 
				  e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			  }
		 }
		 
		 @DeleteMapping("/{managerID}")
		 @CrossOrigin(origins = "http://localhost:4200")
		 public String deleteManager(@PathVariable int managerID)
		 {
			 System.out.println("in delete center"+managerID);
			 return service.deleteManager(managerID);
			 
		 }
		
		 
	
		 
		 
	}



