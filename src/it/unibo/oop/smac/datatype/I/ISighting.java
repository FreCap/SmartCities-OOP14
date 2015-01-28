package it.unibo.oop.smac.datatype.I;

import it.unibo.oop.smac.datatype.LicensePlate;

import java.util.Date;

public interface ISighting {

	public IStreetObserver getStreetObserver();

	public Date getDate();

	public LicensePlate getLicensePlate();

	public Float getSpeed();
	
}