package fr.treeptik.locationvoiture.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import fr.treeptik.locationvoiture.model.Voiture;

@ManagedBean(name="ImageMB")
public class GalleriaBean {
	
	   private List<String> images;  
	  
	    private List<Voiture> Voitures;  
	  
	    private Voiture selectedVoiture;  
	  
	    @PostConstruct  
	    public void init() {  
	        images = new ArrayList<String>();  
	  
	        for(int i=1;i<=12;i++) {  
	            images.add("galleria" + i + ".jpeg");  
	        }  
	  
	        Voitures = new ArrayList<Voiture>();  
	  
	        Voitures.add(new Voiture(null,"Fourgon Renault", "location.jpeg", new Date()));  
	        Voitures.add(new Voiture(null,"Pegeot", "pegeot.jpeg", new Date()));  
	        Voitures.add(new Voiture(null,"BMW", "bmw.jpeg", new Date()));  	       
	        Voitures.add(new Voiture(null,"Audi", "Promo.jpeg", new Date()));  	       
	    }  
	  
	    public Voiture getSelectedVoiture() {  
	        return selectedVoiture;  
	    }  
	  
	    public void setSelectedVoiture(Voiture selectedVoiture) {  
	        this.selectedVoiture = selectedVoiture;  
	    }  
	  
	     
	    public List<String> getImages() {  
	        return images;  
	    }  
	  
	    public List<Voiture> getVoitures() {  
	        return Voitures;  
	    }  
	}  


