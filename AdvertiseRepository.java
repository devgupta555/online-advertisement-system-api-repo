package com.cg.onlineadvapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineadvapi.domain.Advertise;
@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer>{
	
	@Query("select a from Advertise a where a.advertiseTitle LIKE %?1%")
	public Advertise findAdvertiseByTitle(String advertiseTitle);


}
