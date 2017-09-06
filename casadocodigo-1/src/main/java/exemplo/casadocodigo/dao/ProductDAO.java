package exemplo.casadocodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import exemplo.casadocodigo.model.Book;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Book book) {
		manager.persist(book);
	}

}
