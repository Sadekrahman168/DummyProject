package org.example.dummy.service;

import java.util.List;

import org.example.dummy.dto.CityDTO;

/**
 * 
 * responsible for all CRUD operations on City Entity.
 * 
 * @author sadekrahman
 *
 */
public interface CityService {
	/**
	 * Query For all Cities.
	 */
	public List<CityDTO> getAllCities();

	/**
	 * Get a Specific City using id/city code
	 */
	CityDTO getCity(Integer id);

	/**
	 * Get cities by Name. Will return all the cities with matching name.
	 * 
	 */
	List<CityDTO> getCityByName(String name);

	/**
	 * Create a City Entity.
	 * 
	 */
	CityDTO create(CityDTO cityDTO);

	/**
	 * update a City Entity.
	 * 
	 */
	CityDTO update(CityDTO cityDTO);

	/**
	 * Delete a City Entity.
	 * 
	 */

	void delete(CityDTO cityDTO);

}
