package fr.treeptik.locationvoiture.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

//@Controller
//@RequestMapping(value="/client")
@ManagedBean(name = "clientMB")
public class ClientController {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	private ListDataModel<Client> listDataModel;

	private Client client = new Client();

	private List<SelectItem> selectClient = new ArrayList<>();

	public String save() throws ServiceException {

		client = getClientService().save(client);

		return "list-clients";
	}

	public String listClients() {
		return "list-clients";
	}

	public void reset() {
		this.setClient(new Client());

	}

	// j'ai ma liste qui s'affiche
	public ListDataModel<Client> getClientList() throws Exception {
		listDataModel = new ListDataModel<Client>(clientService.findAll());
		return listDataModel;
	}

	// j'ai deja les donées, je passe pas par la base
	public void deleteClient() throws Exception {

		client = listDataModel.getRowData();
		clientService.remove(client.getId());

	}

	public String selectUpdate() throws ServiceException {

		client = listDataModel.getRowData();
		return "updateClient";

	}

	public String updateClient() throws ServiceException {

		getClientService().update(client);
		listDataModel = new ListDataModel<>();
		listDataModel.setWrappedData(clientService.findAll());

		return "list-clients";

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


	public List<SelectItem> getSelectClient() throws ServiceException {

		List<Client> allClient = clientService.findAll();
		for (Client client : allClient) {

			selectClient.add(new SelectItem(client.getId(), client.getNom()
					+ " - " + client.getPrenom()+ " - " +client.getEmail()));
		}

		return selectClient;
	}

	public void setSelectClient(List<SelectItem> selectClient) {
		this.selectClient = selectClient;
	}

}
