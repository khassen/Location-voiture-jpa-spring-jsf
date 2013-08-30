package fr.treeptik.locationvoiture.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.treeptik.locationvoiture.dao.BaseDao;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.BaseEntity;


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T extends BaseEntity<I>, I extends Serializable>
		implements BaseDao<T, I> {

	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> type;

	
//	L EQUIVALET DE 
//	public GenericDAOJPA(Class<T> type) {
//		super();
//		this.type = type;
//	} DANS LE PROJET LOCATION-VOITURE
	
	public BaseDaoImpl() {
		this.type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}


	@Override
	public T saveOrUpdate(T entite) throws DAOException {
		
		try {
			entityManager.merge(entite);
			return entite;
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}
	
	@Override
	public void remove(I id) throws DAOException {
		
		try {
			Query query = entityManager.createQuery("DELETE FROM " + type.getSimpleName() + " t WHERE t.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public T findById(I id) throws DAOException {
		
		try {
			return entityManager.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public List<T> findAll() throws DAOException {
		
		try {
			return entityManager.createQuery("SELECT t FROM " + type.getSimpleName() + " t", type).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public List<T> saveOrUpdateAll(List<T> entities) throws DAOException {
		if (entities != null)
			for (T entity : entities) {
				this.saveOrUpdate(entity);
			}
		return entities;
	}

	@Override
	public void deleteAll(Collection<T> entities) throws DAOException {
		if (entities != null)
			for (T entity : entities) {
				this.remove(entity.getId());
			}
	}


}
