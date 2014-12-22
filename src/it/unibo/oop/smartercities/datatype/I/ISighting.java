package it.unibo.oop.smartercities.datatype.I;

import java.util.Date;

public interface ISighting {

	public IStreetObserver getStreetObserver();

	public void setStreetObserver(IStreetObserver streetObserver);

	public Date getDate();

	public void setDate(Date date);

	public String getPlateLicense();

	public void setPlateLicense(String plateLicense);

	public Float getSpeed();

	public void setSpeed(Float speed);
}