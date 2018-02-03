package org.example.dummy.tests.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.example.dummy.dto.CityDTO;
import org.example.dummy.impl.CityServiceImpl;
import org.example.dummy.model.City;
import org.example.dummy.repo.CityRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * 
 * 
 * @author sadekrahman
 *
 * Unitest Service Layer of City Entity.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class CityServiceUnitTest {

	@Mock
	CityRepo cityRepo;

	@InjectMocks
	CityServiceImpl cityService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/***
	 * Test create operation.
	 */
	@Test
	public void testCreateCity() {

		City city = new City("Dummy City", "Test Descs", 1000);
		when(cityRepo.save(any(City.class))).thenReturn(city);
		CityDTO savedDto = cityService.create(new CityDTO(city));
		assertEquals("Dummy City", savedDto.getName());

	}

	/**
	 * Test update operation.
	 * 
	 */
	@Test
	public void testUpdateCity() {

		City city = new City(1,"Updated Name", "Test Descs", 1000);
		when(cityRepo.save(any(City.class))).thenReturn(city);
		when(cityRepo.findOne(any(Integer.class))).thenReturn(city);
		CityDTO savedDto = cityService.update(new CityDTO(city));
		assertEquals("Updated Name", savedDto.getName());

	}

	/**
	 * Test get City By Name.
	 * 
	 */
	@Test
	public void testGetCityByName() {

		City city = new City("Small City", "Small City Test Descs", 90);
		when(cityRepo.findByName(any(String.class))).thenReturn(Arrays.asList(city));
		List<CityDTO> dtos = cityService.getCityByName("");
		assertTrue(dtos.size() > 0);

	}

	/**
	 * Test get a Singl city By ID
	 * 
	 */
	@Test
	public void testCity() {

		City city = new City("Small City", "Small City Test Descs", 90);
		when(cityRepo.findOne(any(Integer.class))).thenReturn(city);
		CityDTO dto = cityService.getCity(23);
		assertEquals(city.getName(), dto.getName());

	}

	/***
	 * Test Get All Cities.
	 * 
	 */
	@Test
	public void testgetAllCities() {

		City city1 = new City("Small City", "Small City Test Descs", 90);
		City city2 = new City("Big City", "Big City Test Descs", 90);
		when(cityRepo.findAll()).thenReturn(Arrays.asList(city1, city2));
		List<CityDTO> dtos = cityService.getAllCities();
		assertTrue(dtos.size() >= 2);

	}

	/**
	 * Test delete operation.
	 * 
	 */
	@Test
	public void testDelete() {

		City city = new City(null, "Small City Test Descs", 90);
		doThrow(new IllegalArgumentException("Name cant be NULL")).when(cityRepo).delete(city);
		try {
			cityRepo.delete(city);
			Assert.fail();
		} catch (IllegalArgumentException e) {

		}

	}

}
