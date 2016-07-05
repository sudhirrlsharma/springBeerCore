package cybage.dao;

import java.util.List;

import cybage.spring.model.Beer;


public interface BeerDao {
	
	Beer getBeer(Long id);
	List<Beer> getListBeer(); 
	void saveBeer(Beer object );
	void deleteBeer(Integer beerId);
	
}
