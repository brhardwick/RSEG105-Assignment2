package rseg105.project2.part2.services;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rseg105.project2.part2.models.*;

@Transactional
@Service("CategoryService")
@SuppressWarnings("restriction")
public class CategoryServiceImpl implements CategoryService {

	private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public Category getByID(int Id) {
		
		TypedQuery<Category> query = em.createNamedQuery("Category.getById", Category.class);
		query.setParameter("id", Id);
		return query.getSingleResult();
	}

}
