package it.unibo.oop.smartercities.model;

import java.util.List;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.InfoStolenCars;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.NumberPlate;

public interface ModelInterface {
	
	// aggiunta di un nuovo street observer
	void addNewStreetObserver(Coordinates c);
	
	// restituisce le info di uno street observer
	InfoStreetObserver getInfoOf(Coordinates c);
	
	// verifica se un auto è rubata
	InfoStolenCars verifyStolenCar(NumberPlate np);

	// resituisce una lista di macchine rubate
	List<Object> getStolenCarsList();
}
