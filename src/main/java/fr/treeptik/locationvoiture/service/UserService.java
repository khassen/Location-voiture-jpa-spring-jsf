package fr.treeptik.locationvoiture.service;
 
import java.util.List;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.User;
 
public interface UserService {
 
    public void addUser(User user) throws ServiceException;
    public void updateUser(User user) throws ServiceException;
    public void deleteUser(Integer Id) throws ServiceException;
    public User getUserById(Integer Id) throws ServiceException;
    public List<User> getAllUsers() throws ServiceException;
}