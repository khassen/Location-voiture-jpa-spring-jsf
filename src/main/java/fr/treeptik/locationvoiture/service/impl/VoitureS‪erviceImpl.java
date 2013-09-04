package fr.treeptik.locationvoiture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;



@Service("voitureService")
public class VoitureS‪erviceImpl extends GenericServiceImpl<Voiture, Integer, VoitureDAO> implements VoitureService{

	
	@Autowired
	private VoitureDAO voitureDAO;
	
	@Override
	protected VoitureDAO getDAO() {
		// TODO Auto-generated method stub
		return voitureDAO;
	}



}
