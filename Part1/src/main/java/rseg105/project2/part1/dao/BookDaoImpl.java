package rseg105.project2.part1.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rseg105.project2.part1.models.*;

@Transactional
@Repository("bookDao")
@SuppressWarnings("restriction")
public class BookDaoImpl implements BookDao {

	private static Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
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
	public List<Book> getAll() {
		return sessionFactory.getCurrentSession().getNamedQuery("Book.getAll").list();
	}
}
