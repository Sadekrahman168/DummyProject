package org.example.dummy.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.example.dummy.model.City;
import org.springframework.beans.BeanUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A conduit for City Entity.
 * @author sadekrahman
 *
 */
@JsonInclude(Include.NON_NULL)
public class CityDTO {
	
	private static String IGNORE_PROPERTIES = ""
			+ "code";
	
	Integer code;
	@Size(max=20, min=5)
	String name;
	@Size(max=255)
	String description;
	@NotNull
	Integer totalPopulation;
	

	public CityDTO() {
		super();
	}

	public CityDTO(City city) {
		BeanUtils.copyProperties(city, this,IGNORE_PROPERTIES);
		this.code = city.getCode();
	}

	public CityDTO(Integer code, String name, String description, Integer totalPopulation) {
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
	
}
