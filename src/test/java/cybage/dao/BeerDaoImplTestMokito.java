package cybage.dao;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cybage.spring.model.DomesticBeer;

@RunWith(MockitoJUnitRunner.class)
public class BeerDaoImplTestMokito {

	@Mock
	private BeerDaoImpl classUnderTest;

	@Mock
	private SessionFactory sessionFactory;

	@Mock
	private HibernateTemplate hibernateTemplate;

	@Before
	public void setup() {
		classUnderTest = Mockito.spy(new BeerDaoImpl());
		Mockito.doReturn(hibernateTemplate).when(classUnderTest).createHibernateTemplate(sessionFactory);
		classUnderTest.setSessionFactory(sessionFactory);
	}

	@Test
	public void testGetListBeer() {
		final String query = "From DomesticBeer";
		// execution
		classUnderTest.getListBeer();
		// expectations
		Mockito.verify(hibernateTemplate).find(query);

	}

	@Test
	public void testGetBeer() {

		final Long query = Long.parseLong("123");
		// execution
		classUnderTest.getBeer(query);
		// expectations
		Mockito.verify(hibernateTemplate).get(DomesticBeer.class, query);

	}

}
