package it.unibo.oop.smartercities.data.I;

import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.LicensePlate;

import java.util.List;

public interface IStolenCars {

	public List<InfoStreetObserver> getStolenCarsList();

	public Boolean verifyStolenCars(LicensePlate licensePlate);
	
}
