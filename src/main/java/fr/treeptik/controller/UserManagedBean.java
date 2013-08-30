package fr.treeptik.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.treeptik.model.User;
import fr.treeptik.service.UserService;

//@Component(value = "userMB")
//@Scope(value = "request")
@ManagedBean(name="userMB")
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Autowired
//	private UserService userService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	private List<User> userList;

	private User user = new User();

	public String addUser() throws Exception {

		getUserService().addUser(getUser());

		return "list-users";
	}

	public String listUsers() {
		return "list-users";
	}

	public void reset() {
		this.setUser(new User());
	}

	public List<User> getUserList() throws Exception {
		userList = new ArrayList<User>();
		userList = getUserService().getAllUsers();
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}