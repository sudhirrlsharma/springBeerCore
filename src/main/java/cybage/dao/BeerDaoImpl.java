package cybage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cybage.spring.model.Beer;
import cybage.spring.model.DomesticBeer;

@Repository
@Transactional(readOnly = true)
public class BeerDaoImpl extends BaseDao implements BeerDao{
	
	public Beer getBeer(Long id) {
		return (Beer)this.hibernateTamplate.get(DomesticBeer.class, id);
	}

	public List<Beer> getListBeer() {
		return (List<Beer>) this.hibernateTamplate.find("From DomesticBeer");
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {RuntimeException.class})
	public void saveBeer(Beer object) {
		this.hibernateTamplate.saveOrUpdate(object);
//		if(true){
//			throw new RuntimeException("Transaction should rollback");
//		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteBeer(Integer beerId) {
		this.hibernateTamplate.getSessionFactory().getCurrentSession().getTransaction();
		this.hibernateTamplate.delete(this.hibernateTamplate.load(DomesticBeer.class, beerId));
		// 
	}

}
