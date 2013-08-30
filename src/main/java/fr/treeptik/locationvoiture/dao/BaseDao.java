package fr.treeptik.locationvoiture.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.BaseEntity;

public interface BaseDao<T extends BaseEntity<I>, I extends Serializable> {

	T saveOrUpdate(T entity) throws DAOException;
	void remove(I id) throws DAOException;
	T findById(I id) throws DAOException;
	List<T> findAll() throws DAOException;	
	void deleteAll(Collection<T> entity)throws DAOException;
	List<T> saveOrUpdateAll(List<T> entities) throws DAOException;	
	
}
