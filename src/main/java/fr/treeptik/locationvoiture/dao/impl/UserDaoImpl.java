package fr.treeptik.locationvoiture.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.UserDao;
import fr.treeptik.locationvoiture.model.User;

@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {


}