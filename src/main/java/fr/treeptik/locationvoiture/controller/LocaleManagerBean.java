package fr.treeptik.locationvoiture.controller;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="localeMB")
@SessionScoped
public class LocaleManagerBean {

	private Locale locale = Locale.FRENCH;

	public void changeLocaleToFr() {
		FacesContext.getCurrentInstance().getViewRoot()
				.setLocale(Locale.FRENCH);
		setLocale(Locale.FRENCH);
	}

	public void changeLocaleToEn() {
		FacesContext.getCurrentInstance().getViewRoot()
				.setLocale(Locale.ENGLISH);
		setLocale(Locale.ENGLISH);

	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	

}
