package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.database.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Date;

// TODO
// oggetto che viene spedito dal client verso il server, contenente tutte le info rilevate
public class InfoSighting implements ISighting {

	private StreetObserver streetObserver;

	private Date date;

	private String plateLicense;

	private Float speed;

	public IStreetObserver getStreetObserver() {
		return streetObserver;
	}

	public void setStreetObserver(IStreetObserver streetObserver) {
		this.streetObserver = (StreetObserver) streetObserver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlateLicense() {
		return plateLicense;
	}

	public void setPlateLicense(String plateLicense) {
		this.plateLicense = plateLicense;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

}
