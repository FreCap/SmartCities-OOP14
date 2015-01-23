package it.unibo.oop.smac.database.data.I;

import it.unibo.oop.smac.database.data.StolenCars;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

import java.util.List;

public interface IStolenCars {
	public static StolenCars getInstance() {
		return null;
	}

	public List<IInfoStolenCar> getStolenCarsInfoList();

	public Boolean checkStolenPlate(LicensePlate licensePlate);
	
}
