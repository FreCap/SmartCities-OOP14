package it.unibo.oop.smartercities.datatype.I;

import it.unibo.oop.smartercities.datatype.LicensePlate;

import java.util.Date;


public interface IStolenCar {

	public LicensePlate getLicensePlate();

	public void setLicensePlate(LicensePlate licensePlate);

	public Date getInsertionDate();

	public void setInsertionDate(Date insertionDate);

}