package fr.treeptik.locationvoiture.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.model.Voiture;

@Repository
public class VoitureDAOJPA extends GenericDAOJPA<Voiture, Integer> implements VoitureDAO{

	public VoitureDAOJPA() {
		super(Voiture.class);
	}

}
