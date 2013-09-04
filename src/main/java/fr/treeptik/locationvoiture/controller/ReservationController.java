package fr.treeptik.locationvoiture.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.ReservationService;

@ManagedBean(name = "reservationMB")
public class ReservationController {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{reservationService}")
	private ReservationService reservationService;

	// Variable pour recupérer les dates des champs des pages xhtml
	private Date dateResev;
	private Date datePriseVehicule;
	private Date dateRetour;
	
	
	private Reservation reservation;

	private ListDataModel<Reservation> listDataModel;

	public ReservationController() {

		reservation = new Reservation();
		reservation.setClient(new Client());
		reservation.setVoiture(new Voiture());
	}

	public String saveReservation() throws ServiceException {

		getReservationService().save(reservation);

		return "list-reservations";

	}

	public ListDataModel<Reservation> getResrvationList()
			throws ServiceException {

		listDataModel = new ListDataModel<Reservation>(
				reservationService.findAll());
		return listDataModel;
	}

	
	public void validateDatePriseVehicule(FacesContext context,
			UIComponent component, Object date) {
		dateResev = (Date) date;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = dateFormat.format(new Date()); 
		Date dateCourante = null;
		try {
			dateCourante = dateFormat.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dateCourante.after(dateResev) && !dateCourante.equals(dateResev)) {
			// Internationalisation des messages d'erreur
			ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot()
			.getLocale());
			throw new ValidatorException(new FacesMessage(
					bundle.getString("erreur.reservation.date.reservation")));
		}
	}
	
	
	

	
	public void reset() {
		reservation = new Reservation();
	}

	public String deleteReservation() throws Exception {

		reservation = listDataModel.getRowData();

		reservationService.remove(reservation.getId());

		return findAllReservation();

	}

	public String selectUpdate() throws ServiceException {

		reservation = listDataModel.getRowData();
		return "updateReservation";

	}

	public String updateReservation() throws ServiceException {

		getReservationService().update(reservation);
		listDataModel = new ListDataModel<>();
		listDataModel.setWrappedData(reservationService.findAll());

		return "list-reservations";

	}

	public String findAllReservation() throws ServiceException {
		listDataModel = new ListDataModel<Reservation>(
				reservationService.findAll());
		String result = "list-reservations";

		if (listDataModel.getRowCount() == 0) {

			result = "listVide";
		}

		return result;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ListDataModel<Reservation> getListDataModel() {
		return listDataModel;
	}

	public void setListDataModel(ListDataModel<Reservation> listDataModel) {
		this.listDataModel = listDataModel;
	}

}
