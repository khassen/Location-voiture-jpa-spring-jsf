package fr.treeptik.locationvoiture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

@Service("clientService")
public class ClientServiceImpl extends
		GenericServiceImpl<Client, Integer, ClientDAO> implements ClientService {
	@Autowired
	private ClientDAO clientDAO;

	@Override
	protected ClientDAO getDAO() {
		return clientDAO;
	}

}
