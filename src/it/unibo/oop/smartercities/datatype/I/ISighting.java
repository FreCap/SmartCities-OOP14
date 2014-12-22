package it.unibo.oop.smartercities.datatype.I;

import java.util.Date;

public interface ISighting {

	public IStreetObserver getStreetObserver();

	public void setStreetObserver(IStreetObserver streetObserver);

	public Date getDate();

	public void setDate(Date date);

	public String getLicensePlate();

	public void setLicensePlate(String licensePlate);

	public Float getSpeed();

	public void setSpeed(Float speed);
}