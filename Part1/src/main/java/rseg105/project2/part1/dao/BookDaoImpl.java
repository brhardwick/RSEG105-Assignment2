package rseg105.project2.part1.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rseg105.project2.part1.models.Book;

@Transactional
@Repository("bookDao")
@SuppressWarnings("restriction")
@Proxy(lazy=false)
public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Book> getAllWithDetail() {
		return sessionFactory.getCurrentSession().getNamedQuery("Book.findAll").list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Book> getAllWithoutDetail() {
		return sessionFactory.getCurrentSession().createQuery("from Book b").list();
	}

	@Override
	public Book getByID(int Id) {
		return (Book) sessionFactory.getCurrentSession().createQuery("select distinct b from Book b left join fetch b.authors a left join fetch b.category c where b.id = :id").setParameter("id", Id).uniqueResult();
	}	

	@Override
	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);		
	}

	@Override
	public Book save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		return book;
	}
}
