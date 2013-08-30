package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="voiture")
public class Voiture implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	private String marque;

	private String model;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateMiseEnCirculation;
	
	@OneToMany(mappedBy="voiture")
	private List<Reservation> reservations;
	
	public Voiture() {
		super();
	}

	public Voiture(Integer id, String marque, String model,
			Date dateMiseEnCirculation) {
		super();
		this.id = id;
		this.marque = marque;
		this.model = model;
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}
	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
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
		Voiture other = (Voiture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
