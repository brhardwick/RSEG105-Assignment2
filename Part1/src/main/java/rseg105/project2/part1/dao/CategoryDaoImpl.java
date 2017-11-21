package rseg105.project2.part1.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rseg105.project2.part1.models.Category;

@Transactional
@Repository("categoryDao")
@SuppressWarnings("restriction")
public class CategoryDaoImpl implements CategoryDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly = true)
	public Category getByID(int id) {
		return (Category) sessionFactory.getCurrentSession().
				  getNamedQuery("Category.findById").setParameter("id", id).uniqueResult();
	}

}
