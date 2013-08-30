package fr.treeptik.service;
 
import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.User;
 
public interface UserService {
 
    public void addUser(User user) throws ServiceException;
    public void updateUser(User user) throws ServiceException;
    public void deleteUser(Integer Id) throws ServiceException;
    public User getUserById(Integer Id) throws ServiceException;
    public List<User> getAllUsers() throws ServiceException;
}