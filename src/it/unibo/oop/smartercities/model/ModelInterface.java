package it.unibo.oop.smartercities.model;

import java.util.List;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.StolenCar;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.Sighting;

public interface ModelInterface {
	
	// aggiunta di un nuovo street observer
	void addNewStreetObserver(Coordinates<Double> c);
	
	// notifica di un passaggio
	void newPassage(Coordinates<Double> c, Sighting s);
	
	// restituisce le info di uno street observer
	InfoStreetObserver getInfoOf(Coordinates<Double> c);
	
	// verifica se un auto è rubata
	StolenCar verifyStolenCar(LicensePlate lp);

	// resituisce una lista di macchine rubate
	List<Object> getStolenCarsList();
}
