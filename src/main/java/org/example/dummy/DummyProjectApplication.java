package org.example.dummy;

import java.util.Date;

import org.example.dummy.dto.CityDTO;
import org.example.dummy.impl.CityServiceImpl;
import org.example.dummy.model.City;
import org.example.dummy.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude=AopAutoConfiguration.class)
public class DummyProjectApplication{ //implements CommandLineRunner {
	
	/*
	@Autowired
	CityService cityService;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(DummyProjectApplication.class, args);
	}
	
	/*
	@Override
	public void run(String... arg0) throws Exception {
		//===  Create some Dummy Data.
		  	cityService.create(new CityDTO( 
        			new City( "Kansas City","City of Foo",12000)
        		));
		  	
		  	cityService.create(new CityDTO( 
        			new City( "Madison","OMG! so Cold",12)
        		));
       
		  	cityService.create(new CityDTO( 
        			new City( "Dallas","Cowboy City",15000)
        		));
 	}*/
}
