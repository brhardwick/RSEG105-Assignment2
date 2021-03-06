package rseg105.project2.part3.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rseg105.project2.part3.models.Category;

@Transactional
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

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
