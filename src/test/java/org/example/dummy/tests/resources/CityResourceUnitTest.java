package org.example.dummy.tests.resources;


import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import org.example.dummy.dto.CityDTO;
import org.example.dummy.impl.CityServiceImpl;
import org.example.dummy.model.City;
import org.example.dummy.resources.CityResource;
import org.example.dummy.tests.utility.TestDataHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CityResource.class)
public class CityResourceUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CityServiceImpl cityService;

	@InjectMocks
	CityResource cityResource;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testgetAllCityShouldReturn200OK() throws Exception {

		City city = new City("Dummy City", "Test Descs", 1000);
	    when(cityService.getAllCities()).thenReturn(Arrays.asList(new CityDTO(city)));
		mockMvc.perform(get("/city").with(httpBasic(TestDataHelper.TEST_USER, TestDataHelper.TEST_PASS)))
        .andExpect(status().isOk()).andReturn();	
		
	}
	

}
