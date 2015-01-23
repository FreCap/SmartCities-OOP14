package it.unibo.oop.smac.datatype.I;

import it.unibo.oop.smac.datatype.LicensePlate;

import java.util.Date;

public interface ISighting {

	public IStreetObserver getStreetObserver();

	public void setStreetObserver(IStreetObserver streetObserver);

	public Date getDate();

	public void setDate(Date date);

	public LicensePlate getLicensePlate();

	public void setLicensePlate(LicensePlate plateLicense);

	public Float getSpeed();

	public void setSpeed(Float speed);
}