package rseg105.project2.part2.services;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rseg105.project2.part2.models.*;

@Service("BookService")
@Repository
@Transactional
public class BookServiceImpl implements BookService {

	private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Book> getAll() {
		List<Book> books = em.createNamedQuery("Book.findAll", Book.class).getResultList();
		return books;
	}

	@Override
	public Book getByID(int Id) {
		try {
		TypedQuery<Book> query = em.createNamedQuery("Book.findById", Book.class);
		query.setParameter("id", Id);
		return query.getSingleResult();
		}
		catch (NoResultException ex)
		{
			return null;
		}
	}

	@Override
	public void delete(Book book) {
		Book contextBook = em.merge(book);
		em.remove(contextBook);
	}

	@Override
	public Book insert(Book book) {
		 em.persist(book);
		 return book;
	}

}
