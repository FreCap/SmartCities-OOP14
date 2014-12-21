package it.unibo.oop.smartercities.model;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.IStreetObserver;
import it.unibo.oop.smartercities.datatype.NumberPlate;

public interface ModelInterface {

	// aggiunta di un nuovo street observer
	IStreetObserver addNewStreetObserver(Coordinates c);
	
	// restituisce le info di uno street observer
	Object takeInfoOf(Coordinates c);
	
	// verifica se un auto è rubata
	boolean verifyStolenCar(NumberPlate np);
}
