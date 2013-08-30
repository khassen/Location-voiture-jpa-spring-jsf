package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.exception.ServiceException;

public interface GenericService<T, PK> {
	
	
	T save(T entite) throws ServiceException;
	void remove(PK id) throws ServiceException;
	T findById(PK id) throws ServiceException;
	List<T> findAll() throws ServiceException;
	T update(T entite) throws ServiceException;

}
