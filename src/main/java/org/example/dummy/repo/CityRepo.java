package org.example.dummy.repo;

import java.util.List;
import org.example.dummy.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Performs all DB operatins.
 * 
 * @author sadekrahman
 *
 */
@Repository
public interface CityRepo extends CrudRepository<City, Integer> {

	@Override
	void delete(Integer arg0);

	@Override
	void delete(Iterable<? extends City> arg0);

	@Override
	void delete(City arg0);

	@Override
	void deleteAll();

	@Override
	<S extends City> Iterable<S> save(Iterable<S> arg0);

	@Override
	<S extends City> S save(S arg0);

	List<City> findByName(String name);

}
