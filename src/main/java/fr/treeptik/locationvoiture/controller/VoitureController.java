package fr.treeptik.locationvoiture.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;

@ManagedBean(name = "voitureMB", eager = true)
//Pour utiliser Primefaces
//@SessionScoped
public class VoitureController {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{voitureService}")
	private VoitureService voitureService;

	private ListDataModel<Voiture> listDataModel;

	private Voiture voiture = new Voiture();

	private Logger logger = Logger.getLogger(ClientController.class);
	
	// Les Validators
	public void validateDateMiseEnCirculation(FacesContext context,
			UIComponent component, Object date)   {
		dateMiseEnCirculation = (Date) date;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String stringCourant = dateFormat.format(new Date());
		Date dateCourante = null;
	
	    try {
			dateCourante = dateFormat.parse(stringCourant);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (dateCourante.before(dateMiseEnCirculation)) {
			// Internationalisation des messages d'erreur
			ResourceBundle bundle = ResourceBundle.getBundle("messages",
					context.getViewRoot().getLocale());
			throw new ValidatorException(new FacesMessage(
					bundle.getString("erreur.voiture.date")));
		}

	}

	
	
	private List<SelectItem> selectVoiture = new ArrayList<>();

	private Date dateMiseEnCirculation;

	public String saveVoiture() throws ServiceException {
		logger.info("Appel formCreate Methode GET");
		voiture = getVoitureService().save(voiture);

		return "list-voitures";

	}

	public void reset() {
		voiture = new Voiture();
	}

	public ListDataModel<Voiture> getVoituretList() throws Exception {
		listDataModel = new ListDataModel<Voiture>(voitureService.findAll());
		return listDataModel;
	}

	public String findAllVoiture() throws ServiceException {
		listDataModel.setWrappedData(voitureService.findAll());
		String result = "list-voitures";

		if (listDataModel.getRowCount() == 0) {

			result = "listVide";
		}

		return result;
	}

	public String removeVoiture() throws ServiceException {
		voiture = listDataModel.getRowData();
		voitureService.remove(voiture.getId());
		voiture = new Voiture();
		return findAllVoiture();
	}

	public String selectVoiture() throws ServiceException {

		voiture = listDataModel.getRowData();
		return "update-voiture";
	}

	public String updateVoiture() throws ServiceException {

		getVoitureService().update(voiture);
		listDataModel = new ListDataModel<>();
		listDataModel.setWrappedData(voitureService.findAll());

		return "list-voitures";
	}

	public VoitureService getVoitureService() {
		return voitureService;
	}

	public void setVoitureService(VoitureService voitureService) {
		this.voitureService = voitureService;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public ListDataModel<Voiture> getListDataModel() {
		return listDataModel;
	}

	public void setListDataModel(ListDataModel<Voiture> listDataModel) {
		this.listDataModel = listDataModel;
	}

	public List<SelectItem> getSelectVoiture() throws ServiceException {

		List<Voiture> voitures = voitureService.findAll();
		for (Voiture voiture : voitures) {

			selectVoiture.add(new SelectItem(voiture.getId(), voiture
					.getMarque() + " - " + voiture.getModel()));

		}

		return selectVoiture;

	}

	public void setSelectVoiture(List<SelectItem> selectVoiture) {
		this.selectVoiture = selectVoiture;
	}
}
