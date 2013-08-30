package fr.treeptik.locationvoiture.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

//@Controller
//@RequestMapping(value="/client")
@ManagedBean(name="clientMB")
public class ClientController {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;
	
	private  ListDataModel<Client>  listDataModel ;

	private Client client = new Client();


	
	public String save() throws ServiceException {
	
		getClientService().save(client);
	
		return "list-clients";
	}

	
	public String listClients() {
		return "list-clients";
	}
	
	

	public void reset() {
		this.setClient(new Client());
		
	}
	
	
		
//je ma liste qui s'affiche
	public ListDataModel<Client> getClientList() throws Exception {
		listDataModel = new ListDataModel<Client>(clientService.findAll());
		return listDataModel;
	}

//	j'ai deja les donées, je passe pas par la base
	public void deleteClient() throws Exception{
		
		client = listDataModel.getRowData();
		clientService.remove(client.getId());
		
	}
	
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ListDataModel<Client> getListDataModel() {
		return listDataModel;
	}


	public void setListDataModel(ListDataModel<Client> listDataModel) {
		this.listDataModel = listDataModel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private ClientService clientService;
//	
//	
//	
////	mysql> select * from client c 
////	join reservation r on c.id = r.id_client where c.id in(select id_client from reservation);
//
//	
//	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
//	public ModelAndView initForm() throws ServiceException {
//		Client cli = new Client();
//		ModelAndView modelAndView = new ModelAndView("client/save-client",
//				"client", cli);
//		return modelAndView;
//	}
//
//	@RequestMapping(value="/client.do", method=RequestMethod.POST)
//	public ModelAndView save(Client client) throws ServiceException{
//		
//		clientService.save(client);
//		
//		return new ModelAndView("redirect:clients.do");
//		
//	}
//	
//
//	@RequestMapping(value="/clients.do", method=RequestMethod.GET)
//	public ModelAndView findAll() throws ServiceException{
//		
//		Map<String, Object> params = new HashMap<String,Object>();
//		params.put("listClients", clientService.findAll());
//		
//		
//		return new ModelAndView("client/list-client",params);
//		
//	}
//	
//	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
//	public ModelAndView delete(@RequestParam("id") Integer id)
//			throws ServiceException {
//
//		clientService.remove(id);
//
//		return new ModelAndView("client/delete-client");
//
//	}
//
//	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
//	public ModelAndView updateClient(Client cli) throws ServiceException {
//
//		clientService.update(cli);
//
//		return new ModelAndView("redirect:clients.do");
//
//	}
//	
//	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
//	public ModelAndView initUpdateClient(Client cli) throws ServiceException {
//
//		cli = clientService.findById(cli.getId());
//
//		return new ModelAndView("client/update-client", "client", cli);
//
//	}
}
