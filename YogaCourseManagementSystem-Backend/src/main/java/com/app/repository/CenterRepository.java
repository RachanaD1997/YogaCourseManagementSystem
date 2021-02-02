package com.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Center;



public interface CenterRepository extends JpaRepository <Center, Integer>
{
	    Center findByName(String cname);
		Center findById(int id);
		@Query(value="select * from center q where q.managerid = ?1",nativeQuery=true)
	    Center findByManager(int id);
}