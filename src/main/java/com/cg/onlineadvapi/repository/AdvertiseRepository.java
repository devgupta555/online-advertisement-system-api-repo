package com.cg.onlineadvapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineadvapi.domain.Advertise;
@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer>{
	@Query("from Advertise where user_id=?1")
	List<Advertise> viewAdvertisementByUser(int userId);
}
