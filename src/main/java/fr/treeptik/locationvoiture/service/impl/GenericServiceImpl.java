package fr.treeptik.locationvoiture.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.GenericDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.service.GenericService;

public abstract class GenericServiceImpl<T, PK, D extends GenericDAO<T, PK>> implements GenericService<T, PK>{

	protected abstract D getDAO();
	

	@Override
	@Transactional
	public T save(T entite) throws ServiceException {
		try {
			getDAO().save(entite);
			return entite;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	@Transactional
	public void remove(PK id) throws ServiceException {
		try {
			getDAO().remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public T findById(PK id) throws ServiceException {
		try {
			return getDAO().findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
//	@Transactional(propagation=Propagation.MANDATORY)
	public List<T> findAll() throws ServiceException {
		try {
			return getDAO().findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	

	@Override
	@Transactional
	public T update(T entite) throws ServiceException {
		try {
			getDAO().update(entite);
			return entite;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	
}
