package config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;





public class HibernateDAO<T, Type extends Serializable> implements IGenericDAO<T, Type>  {
	private Class<T> persistentClass;
	private List<T> listAllEntities;

	public HibernateDAO(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
		listAllEntities = new ArrayList<T>();
	}

	protected void beginTransaction() {
		HibernateUtils.getSession().getTransaction().begin();
	}

	protected void commitTransaction() {
		HibernateUtils.getSession().getTransaction().commit();
	}

	protected void rollBackTransaction() {
		HibernateUtils.getSession().getTransaction().rollback();
	}

	@Override
	public void saveOrUpdate(T entity) throws IllegalArgumentException {
		try {
			beginTransaction();
			HibernateUtils.getSession().saveOrUpdate(entity);
			commitTransaction();
		} catch (Exception e) {
			rollBackTransaction();
			throw new IllegalArgumentException();
		}
	}
	
	
	
	@Override
	public void save(T entity) throws IllegalArgumentException {
		try {
			beginTransaction();
			HibernateUtils.getSession().save(entity);
			commitTransaction();
		} catch (Exception e) {
			rollBackTransaction();
			throw new IllegalArgumentException("Register invalid!");
		}
	}

	@Override
	public List<T> listAll() {
		beginTransaction();
		Session session = HibernateUtils.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(persistentClass);

		Root<T> root = criteria.from(persistentClass);

		criteria.select(root);

		listAllEntities.addAll(session.createQuery(criteria).list());
		commitTransaction();
		return listAllEntities;
	}
}
