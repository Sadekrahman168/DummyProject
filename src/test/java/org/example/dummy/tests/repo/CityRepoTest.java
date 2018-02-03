package org.example.dummy.tests.repo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.example.dummy.model.City;
import org.example.dummy.repo.CityRepo;
import org.example.dummy.tests.utility.TestDataHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)  
@TestExecutionListeners({
DependencyInjectionTestExecutionListener.class,
DirtiesContextTestExecutionListener.class,
TransactionalTestExecutionListener.class,
DbUnitTestExecutionListener.class
	
})
public class CityRepoTest {
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	TestEntityManager testEntityManager;

	@Test
	public void testFindAll() {
		cityRepo.save(TestDataHelper.getDummyCityEntity()); 
		List<City> cities = (List<City>)cityRepo.findAll();
		assertThat(cities.get(0).getName(), is(equalTo(TestDataHelper.DUMMY_CITY_NAME)));

	}
	
	
	@Test
	public void testFindByName() {
		cityRepo.save(TestDataHelper.getDummyCityEntity()); 
		List<City> cities = cityRepo.findByName(TestDataHelper.DUMMY_CITY_NAME);
		assertThat(cities.get(0).getDescription(), is(equalTo(TestDataHelper.TEST_DESCS)));

	}
	
	@Test
	public void testSave() {
		City city = cityRepo.save(TestDataHelper.getDummyCityEntity()); 
		assertThat((city).getDescription(), is(equalTo(TestDataHelper.TEST_DESCS)));

	}
	


}
