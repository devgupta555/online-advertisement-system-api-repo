package com.cg.onlineadvertisementsystem.AdvertiseServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.domain.User;
import com.cg.onlineadvapi.repository.AdvertiseRepository;
import com.cg.onlineadvapi.serviceImpl.AdvertiseServiceImpl;
/**
 * 
 * @author dgupta8
 * 
 *
 */
/**
 * 
 * @author sunil
 *
 */
public class AdvertiseServiceTest {
	@Mock //- mock bean
	private AdvertiseRepository advertiseRepository;

	@InjectMocks // mock bean injection
	private AdvertiseServiceImpl advertiseServiceImpl;
	// stubs
	private Advertise firstAdvertise;
	private Advertise secondAdvertise;
	private Advertise lastAdvertise;
	
	private List<Advertise> thirdAdvertise;
	private Advertise fourthAdvertise;
	List<Advertise> advertiseList;
	private Advertise advertise;
	private Optional<Advertise> idAdvertise;
	
	@BeforeEach
	public void setUp() {
	MockitoAnnotations.initMocks(this); //invoke mock
	advertise = new Advertise();
	advertiseList = new ArrayList<>();
	
	}
	
	@AfterEach
	public void tearDown() {
	advertiseRepository.deleteAll();
	firstAdvertise = secondAdvertise =lastAdvertise=null;
	advertiseList = null;
	}

	@Test
	public void test_saveOrUpdateAdvertise_GivenAdvertise_ShouldReturnSavedAdvertise(){
	firstAdvertise=new Advertise("Bike","2-wheeler",100.00,"new bike");
	BDDMockito.given(advertiseRepository.save(advertise))
	.willReturn(firstAdvertise);
	secondAdvertise = advertiseServiceImpl.saveOrUpdateAdvertise(advertise);
	assertNotNull(secondAdvertise);
	assertEquals("Bike",secondAdvertise.getAdvertiseTitle() );
	assertEquals("2-wheeler",secondAdvertise.getCategory() );
	assertEquals(100.00,secondAdvertise.getPrice() );
	assertEquals("new bike",secondAdvertise.getDescription());
	}
	
	@Test
	public void test_saveOrUpdateAdvertise_GivenAdvertise_ShouldReturnUpdatedAdvertise(){
	firstAdvertise=new Advertise("Bike","2-wheeler",100.00,"new bike");
	firstAdvertise.setAdvertiseTitle("AutoRikshaw");
	BDDMockito.given(advertiseRepository.save(advertise))
	.willReturn(firstAdvertise);
	secondAdvertise = advertiseServiceImpl.saveOrUpdateAdvertise(advertise);
	assertNotNull(secondAdvertise);
	assertEquals("AutoRikshaw",secondAdvertise.getAdvertiseTitle() );
	assertEquals("2-wheeler",secondAdvertise.getCategory() );
	assertEquals(100.00,secondAdvertise.getPrice() );
	assertEquals("new bike",secondAdvertise.getDescription());
	}

	@Test
	public void test_deleteAdvertiseById_GivenAdvertiseId_ShouldDeleteAdvertiseById() {
	advertiseRepository.deleteById(advertise.getAdvertiseId());
	verify(advertiseRepository).deleteById(advertise.getAdvertiseId());
	assertNull(advertise.getAdvertiseTitle());
	assertNull(advertise.getCategory());
	assertNull(advertise.getDescription());
	assertNull(advertise.getPrice());
	}
	
	@Test
	public void test_findAdvertiseById_GivenAdvertiseId_ShouldReturnAdvertise() {
		idAdvertise=Optional.of(new Advertise("Sunil","thin boy",100.00,"new man"));
    	BDDMockito.given(advertiseRepository.findById(advertise.getAdvertiseId()))
    	.willReturn(idAdvertise);
    	Optional<Advertise> fourthAdvertise = advertiseServiceImpl.findAdvertiseById(advertise.getAdvertiseId());
    	assertNotNull(idAdvertise);	
    	assertNotNull(fourthAdvertise);	
    	assertEquals(idAdvertise,fourthAdvertise);
    	
   }
	
	@Test
	public void test_findAdvertiseByTitle_GivenAdvertiseTitle_ShouldReturnAdvertise() {
		lastAdvertise=new Advertise("Dev","thin boy",100.00,"new man");
    	BDDMockito.given(advertiseRepository.findAdvertiseByTitle(advertise.getAdvertiseTitle()))
    	.willReturn(lastAdvertise);
    	Advertise fourthAdvertise = advertiseServiceImpl.findAdvertiseByTitle(advertise.getAdvertiseTitle());
    	assertNotNull(lastAdvertise);
    	assertNotNull(fourthAdvertise);
   }
	
	@Test
	public void test_findAllAdvertise_Given_ShouldReturnAllAdvertise() {
		thirdAdvertise=new ArrayList<Advertise>();
		secondAdvertise=new Advertise("Pen","2-wheeler",100.00,"new pen");
		lastAdvertise=new Advertise("Pencil","2-wheeler",100.00,"new pencil");
		thirdAdvertise.add(secondAdvertise);
		thirdAdvertise.add(lastAdvertise);

    	BDDMockito.given(advertiseRepository.findAll())
    	.willReturn(thirdAdvertise);
    	List<Advertise> aAdvertise = advertiseServiceImpl.findAllAdvertise();
    	assertNotNull(thirdAdvertise);
    	assertNotNull(aAdvertise);
    	
   }
	
	
	
}
