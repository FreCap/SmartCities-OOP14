package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.Date;

// classe che rappresenta un oggetto di tipo stolenCars
// (ma serve davvero? non è un oggetto che solo il DB deve conoscere?)
public class StolenCar implements IStolenCar {

	private LicensePlate licensePlate;
	private Date insertionDate;

	public StolenCar(LicensePlate licensePlate, Date insertionDate) {
		this.licensePlate = licensePlate;
		this.insertionDate = insertionDate;
	}

	@Override
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	@Override
	public Date getInsertionDate() {
		return insertionDate;
	}

}
