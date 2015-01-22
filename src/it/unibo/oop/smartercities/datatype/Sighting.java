package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.database.StreetObserverRow;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Date;

// TODO
// oggetto che viene spedito dal client verso il server, contenente tutte le info rilevate
public class Sighting implements ISighting {

	private StreetObserverRow streetObserver;

	private Date date;

	private LicensePlate licensePlate;

	private Float speed;

	public IStreetObserver getStreetObserver() {
		return null; //streetObserver;
	}

	public void setStreetObserver(IStreetObserver streetObserver) {
		this.streetObserver = (StreetObserverRow) streetObserver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}


}
