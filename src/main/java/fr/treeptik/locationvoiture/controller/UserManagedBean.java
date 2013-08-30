package fr.treeptik.locationvoiture.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;

import fr.treeptik.locationvoiture.model.User;
import fr.treeptik.locationvoiture.service.UserService;

//@Component(value = "userMB")
//@Scope(value = "request")
@ManagedBean(name="userMB")
//L'EQUIVALEN DE CONTROLLER EN JSF
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Autowired
//	private UserService userService;
// j'inject a la mode jsf, si je veux annoter à la mode spring je dois mettre d'abort @controller 
// puis l'injection Autowired, donc 2 methodes #
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	private ListDataModel<User> listDataModel ;

	private User user = new User();

	public String addUser() throws Exception {

		getUserService().addUser(user);

		return "list-users";
	}

	public String listUsers() {
		return "list-users";
	}

	public void reset() {
		this.setUser(new User());
	}
//je ma liste qui s'affiche
	public ListDataModel<User> getUserList() throws Exception {
		listDataModel = new ListDataModel<User>(userService.getAllUsers());
		return listDataModel;
	}

//	j'ai deja les donées, je passe pas par la base
	public void deleteUser() throws Exception{
		
		user = listDataModel.getRowData();
		userService.deleteUser(user.getId());
		
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