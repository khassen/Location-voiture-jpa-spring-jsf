package fr.treeptik.locationvoiture.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.treeptik.locationvoiture.dao.GenericDAO;
import fr.treeptik.locationvoiture.exception.DAOException;

public class GenericDAOJPA<T, PK> implements GenericDAO<T, PK> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> type;

	public GenericDAOJPA(Class<T> type) {
		super();
		this.type = type;
	}

	@Override
	public T save(T entite) throws DAOException {
		try {
			entityManager.persist(entite);
			return entite;
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void remove(PK id) throws DAOException {
		try {
			Query query = entityManager.createQuery("DELETE FROM "
					+ type.getSimpleName() + " o where o.id= :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	public T findById(PK id) throws DAOException {
		try {
			return entityManager.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws DAOException {
		try {
			return entityManager.createQuery(
					"select o from " + type.getSimpleName() + " o", type)
					.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public T update(T entite) throws DAOException {
		try {
			entityManager.merge(entite);
			return entite;
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

}
