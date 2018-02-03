package org.example.dummy.tests.resources;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;
import org.example.dummy.dto.CityDTO;
import org.example.dummy.resources.CityResource;
import org.example.dummy.tests.utility.TestDataHelper;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
public class CityResourceIT {
	
	@Autowired
	
	CityResource cityResource;
	
	@Test
	public void testgetAllCity() {
		cityResource.createCity(TestDataHelper.getDummyCityDTO());
		Response respone = cityResource.getAllCity();
		assertThat(respone.getStatus(),is(equalTo(Status.OK)));
	}
	

	@Test
	public void testCreateCity() {
		Response respone = cityResource.createCity(TestDataHelper.getDummyCityDTO());
		assertThat(respone.getStatus(),is(equalTo(Status.OK)));
	}
	
	
	@Test
	public void testUpdateCity() {
		CityDTO dummyCityDTO = TestDataHelper.getDummyCityDTO();
		cityResource.createCity(dummyCityDTO);
		Response cityByName = cityResource.getCityByName(dummyCityDTO.getName());
		List<CityDTO> dtos = (List<CityDTO>)cityByName.getData();
		CityDTO cityFromDb = dtos.get(0);
		cityFromDb.setDescription("new Description");
		Response response = cityResource.updateCity(cityFromDb);
		assertThat(response.getStatus(),is(equalTo(Status.OK)));
	}
	
	
	@Test
	public void tesDeleteCity() {
		CityDTO dummyCityDTO = TestDataHelper.getDummyCityDTO();
		cityResource.createCity(dummyCityDTO);
		Response cityByName = cityResource.getCityByName(dummyCityDTO.getName());
		List<CityDTO> dtos = (List<CityDTO>)cityByName.getData();
		CityDTO cityFromDb = dtos.get(0);
		Response response = cityResource.DeleteCity( Integer.toString(cityFromDb.getCode()));
		assertThat(response.getStatus(),is(equalTo(Status.OK)));
	}
	
}
