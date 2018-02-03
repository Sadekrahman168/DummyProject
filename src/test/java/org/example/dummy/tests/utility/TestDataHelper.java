package org.example.dummy.tests.utility;

import java.io.IOException;

import org.example.dummy.dto.CityDTO;
import org.example.dummy.model.City;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataHelper {
	
	public static final String TEST_DESCS = "Test Descs";
	public static final String DUMMY_CITY_NAME = "Dummy City";
	public static final String TEST_USER = "dummy";
	public static final String TEST_PASS = "dummy";
	
	
	public static City getDummyCityEntity(){
		return new City(DUMMY_CITY_NAME, TEST_DESCS, 1000);
	}
	
	public static CityDTO getDummyCityDTO(){
		return new CityDTO(getDummyCityEntity());
	}
	
	public static String getFieldValueFromJsonString(String jsonString,String fieldName) throws JsonProcessingException, IOException {
		
		String cityName ="";
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonNode = mapper.readTree(jsonString);
	    cityName = (jsonNode.get(fieldName)).textValue();
	    
	    return cityName;
		
	}
	
	
	

}
