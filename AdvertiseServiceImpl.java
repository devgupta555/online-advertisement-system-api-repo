package com.cg.onlineadvapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.repository.AdvertiseRepository;
import com.cg.onlineadvapi.service.AdvertiseService;

public class AdvertiseServiceImpl implements AdvertiseService {
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Override
	public Advertise saveOrUpdateAdvertise(Advertise advertise) {
		return advertiseRepository.save(advertise);
	}

	@Override
	public void deleteAdvertiseById(Integer advertiseId) {
		advertiseRepository.deleteById(advertiseId);
	}

	@Override
	public Optional<Advertise> findAdvertiseById(Integer advertiseId) {
		return advertiseRepository.findById(advertiseId) ;
		
	}
	
	@Override
	public Advertise  findAdvertiseByTitle(String advertiseTitle) {
		return advertiseRepository.findAdvertiseByTitle(advertiseTitle);
	}
	
	@Override
	public List<Advertise> findAllAdvertise() {
		
		return advertiseRepository.findAll();
	}

}
