package fr.treeptik.locationvoiture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.UserDao;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.User;
import fr.treeptik.locationvoiture.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void addUser(User user) throws ServiceException {
		try {
			userDao.saveOrUpdate(user);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		try {
			return userDao.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public void updateUser(User user) throws ServiceException {
		// TODO A implementer
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public void deleteUser(Integer id) throws ServiceException {
		try {
			userDao.remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public User getUserById(Integer id) throws ServiceException {
		// TODO A implementer
		throw new UnsupportedOperationException();
	}

}