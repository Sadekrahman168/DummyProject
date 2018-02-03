package org.example.dummy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for City.
 * 
 * @author sadekrahman
 *
 */
@Entity
public class City {

	/**
	 * Unique ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer code;
	/**
	 * City Name
	 * 
	 */
	@Column
	String name;
	/**
	 * Short Summary of the City.
	 * 
	 */
	@Column
	String description;
	/**
	 * Total population of the City.
	 * 
	 */
	@Column
	Integer totalPopulation;

	public City() {
	}

	public City(String name, String description, Integer totalPopulation) {
		this.name = name;
		this.description = description;
		this.totalPopulation = totalPopulation;
	}

	public City(Integer code, String name, String description, Integer totalPopulation) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.totalPopulation = totalPopulation;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(Integer totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	@Override
	public String toString() {
		return "City [code=" + code + ", name=" + name + ", description=" + description + ", totalPopulation="
				+ totalPopulation + "]";
	}
	
	

}
