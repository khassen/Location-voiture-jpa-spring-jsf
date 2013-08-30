package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;


	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateResev;


	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datePrise;


	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateRetour;


	@ManyToOne()
	@JoinColumn(name = "id_client")
	private Client client;


	@ManyToOne
	@JoinColumn(name = "id_voiture")
	private Voiture voiture;

	public Reservation() {
		super();
	}

	public Reservation(Integer id, Date dateResev, Date datePrise,
			Date dateRetour, Client client, Voiture voiture) {
		super();
		this.id = id;
		this.dateResev = dateResev;
		this.datePrise = datePrise;
		this.dateRetour = dateRetour;
		this.client = client;
		this.voiture = voiture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getdateResev() {
		return dateResev;
	}

	public void setdateResev(Date dateResev) {
		this.dateResev = dateResev;
	}

	public Date getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(Date datePrise) {
		this.datePrise = datePrise;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
