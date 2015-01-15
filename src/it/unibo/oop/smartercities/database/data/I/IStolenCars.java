package it.unibo.oop.smartercities.database.data.I;

import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;

import java.util.List;

public interface IStolenCars {

	public List<IInfoStolenCar> getStolenCarsList();

	public Boolean verifyStolenCars(LicensePlate licensePlate);
	
}
