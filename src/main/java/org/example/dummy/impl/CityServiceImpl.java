package org.example.dummy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.example.dummy.dto.CityDTO;
import org.example.dummy.model.City;
import org.example.dummy.repo.CityRepo;
import org.example.dummy.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service class is responsible for all CRUD operations on City Entity.
 * 
 * @author sadekrahman
 *
 */
@Service
public class CityServiceImpl implements CityService {

	CityRepo cityRepo;

	@Autowired
	public CityServiceImpl(CityRepo cityRepo) {
		this.cityRepo = cityRepo;

	}

	/**
	 * Query For all Cities.
	 */
	public List<CityDTO> getAllCities() {
		List<CityDTO> cityDtos = new ArrayList<>();

		List<City> cities = (List<City>) cityRepo.findAll(); // TODO : Bad idea to return all Entity, should have
																// pagination support.
		cities.forEach(city -> cityDtos.add(new CityDTO(city)));

		return cityDtos;

	}

	/**
	 * Get a Specific City using id/city code
	 */
	public CityDTO getCity(Integer id) {
		return new CityDTO(cityRepo.findOne(id));
	}

	/**
	 * Get cities by Name. Will return all the cities with matching name.
	 * 
	 */
	public List<CityDTO> getCityByName(String name) {

		List<CityDTO> cityDtos = new ArrayList<>();
		List<City> cities = (List<City>) cityRepo.findByName(name);

		if (cities.isEmpty()) {
			throw new NoSuchElementException("City Doesn't Exist. With the Name :" + name);
		}

		cities.forEach(city -> cityDtos.add(new CityDTO(city))

		);
		return cityDtos;
	}

	/**
	 * Create a City Entity.
	 * 
	 */
	public CityDTO create(CityDTO cityDTO) {
		cityRepo.save(convertToEntity(cityDTO));
		return cityDTO;
	}

	/**
	 * Update a City Entity.
	 * 
	 */
	public CityDTO update(CityDTO dto) {

		City entityToUpdate = cityRepo.findOne(dto.getCode());

		if (null != dto.getName() && !dto.getName().isEmpty()) {
			entityToUpdate.setName(dto.getName());
		}
		if (null != dto.getDescription() && !dto.getDescription().isEmpty()) {
			entityToUpdate.setDescription(dto.getDescription());
		}
		if (dto.getTotalPopulation() >= 0) {
			entityToUpdate.setTotalPopulation(dto.getTotalPopulation());
		}
		cityRepo.save(entityToUpdate);
		return new CityDTO(entityToUpdate);
	}

	/**
	 * Update a City Entity.
	 * 
	 */
	public void delete(CityDTO cityDTO) {
		cityRepo.delete(cityDTO.getCode());
	}

	/**
	 * A helper method to convert DTO to Entity.
	 * 
	 * @param dto
	 * @return
	 * @throws NoSuchElementException
	 */
	private City convertToEntity(CityDTO dto) throws NoSuchElementException {
		return new City(dto.getName(), dto.getDescription(), dto.getTotalPopulation());
	}

}
