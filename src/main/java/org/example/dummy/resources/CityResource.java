package org.example.dummy.resources;


import java.util.NoSuchElementException;
import org.example.dummy.dto.CityDTO;
import org.example.dummy.impl.CityServiceImpl;
import org.example.dummy.service.CityService;
import org.example.dummy.utility.Response;
import org.example.dummy.utility.Response.CustomError;
import org.example.dummy.utility.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/city")
@Api(value = "city api",tags = "REQ [ 5 ]  City API to perform CRUD operation.")
public class CityResource {
	
	CityService  cityService;

	@Autowired
	public CityResource(CityServiceImpl cityService) {
		this.cityService = cityService;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Response createCity(@RequestBody @Validated CityDTO dto) {
		cityService.create(dto);
		return new Response(Status.OK, null, null);

	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response updateCity(@RequestBody @Validated CityDTO dto) {
		try {
			CityDTO  dtoFromDB = verify(dto.getCode());
			dto.setCode(dtoFromDB.getCode());
			cityService.update(dto);
		} catch (NoSuchElementException e) {
			return new Response(Status.ERROR, null, new CustomError(404, e.getMessage()) );
		}
		
		return new Response(Status.OK, null, null);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Response getAllCity() {
		return new Response(Status.OK, cityService.getAllCities(), null);

	}
	

	@RequestMapping(path="/{name}",method = RequestMethod.GET)
	public Response getCityByName(@PathVariable(value = "name") String name) {
		try {
			return new Response(Status.OK, cityService.getCityByName(name), null);
		} catch (Exception e) {
			return new Response(Status.ERROR, null, new CustomError(404, e.getMessage()) );
		}

	}
	
	@RequestMapping(path="/{id}",method = RequestMethod.DELETE)
	public Response DeleteCity(@PathVariable(value = "id") String id) {
		try {
			CityDTO dto = verify(Integer.parseInt(id));
			cityService.delete(dto);
			return new Response(Status.OK, null, null);
		} catch (NumberFormatException e ) {
			return new Response(Status.ERROR, null, new CustomError(400, e.getMessage()) );
		} catch (NoSuchElementException e) {
			return new Response(Status.ERROR, null, new CustomError(404, e.getMessage()) );
		}

	}
	
	//===  Verify DTO
	private CityDTO verify(Integer id) throws NoSuchElementException {
		CityDTO city = cityService.getCity(id);
		if (null == city) {
			throw new NoSuchElementException("Invalid City " + id);
		}
		return city;
	}
	
	

}
