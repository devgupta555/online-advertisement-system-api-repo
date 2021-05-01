package com.cg.onlineadvapi.service;

import java.util.List;
import java.util.Optional;

import com.cg.onlineadvapi.domain.Advertise;

public interface AdvertiseService {

	public Advertise saveOrUpdateAdvertise(Advertise advertise);
	
	public void deleteAdvertiseById(Integer advertiseId);

	public Optional<Advertise> findAdvertiseById(Integer advertiseId);

	public Advertise findAdvertiseByTitle(String advertiseTitle);

	public List<Advertise> findAllAdvertise();


}
