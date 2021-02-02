package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.Center;
import com.app.pojos.Manager;
import com.app.repository.CenterRepository;

@Service
@Transactional
public class CenterServiceImpl implements ICenterService {
	// dependency
	@Autowired
	private CenterRepository dao;
	
	@Autowired
	private IManagerService mdao;
	

	@Override
	public List<Center> getAllCenters() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	
	@Override
	  public Center  getCenterDetails(String cname) 
	 { 
		  
	  return dao.findByName(cname);
		  
	  
	  }
	 
		
		  @Override 
		  public Center getCenterDetailsById(int id)
		  { 
			  return dao.findById(id); 
		  }
		 
		 

	@Override //
	public Center addCenterDetails(Center p) {  
	Manager m=mdao.getManagerDetailsById(p.getManager().getId());
	Center c=new Center();
	  c.setName(p.getName());
	  c.setAddress(p.getAddress());
	  c.setContactNumber(p.getContactNumber());
	  c.setManager(m);
	
	  return dao.save(c); 
	  }
	  
	  @Override 
	  public Center updateCenterDetails(int centerID, Center p1) 
	  { 
	  
	 Center c=dao.findById(centerID); 
	  if (c!=null) 
	  { 
		  
		  // p.get() : PERSISTENT // p1 : detached POJO : contains the updates sent by clnt 
		  // change state of persistent POJO 
		  Center center = c;
		  center.setName(p1.getName());
		  center.setAddress(p1.getAddress());
		  center.setContactNumber(p1.getContactNumber());
		  return center;
	  
	  }
	  
		//in case of no product found : throw custom exception
	  throw new ResourceNotFoundException("Invalid  ID");

		}
	  
	  @Override
		public String deleteCenter(int centerID) {
	  		
			dao.deleteById(centerID);
			return "Manager with ID="+centerID+"deleted.";
		}


	@Override
	public Center findByManager(int id) {
		return dao.findByManager(id);
	}
		 
	  
}
