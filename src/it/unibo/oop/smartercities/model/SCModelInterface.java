package it.unibo.oop.smartercities.model;

import it.unibo.oop.stolenCars.NumberPlate;
import it.unibo.oop.streetObservers.IStreetObserver;

public interface SCModelInterface {

	// aggiunta di un nuovo street observer
	IStreetObserver addNewStreetObserver(Double latitude, Double longitude);
	
	// restituisce le info di uno street observer
	Object takeInfoOf(int id);
	
	// verifica se un auto è rubata
	boolean verifyStolenCar(NumberPlate np);
}
