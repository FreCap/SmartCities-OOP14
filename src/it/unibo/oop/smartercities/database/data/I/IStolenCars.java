package it.unibo.oop.smartercities.database.data.I;

import it.unibo.oop.smartercities.database.data.StolenCars;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;

import java.util.List;

public interface IStolenCars {
	public static StolenCars getInstance() {
		return null;
	}

	public List<IInfoStolenCar> getStolenCarsInfoList();

	public Boolean checkStolenPlate(LicensePlate licensePlate);
	
}
