package it.unibo.oop.smac.model;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

import java.util.List;

public interface IStolenCars {
	public static IStolenCars getInstance() {
		return null;
	}

	public List<IInfoStolenCar> getStolenCarsInfoList();

	public Boolean checkStolenPlate(LicensePlate licensePlate);

}