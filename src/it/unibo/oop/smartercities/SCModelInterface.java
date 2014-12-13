package it.unibo.oop.smartercities;

import it.unibo.oop.streetObservers.NumberPlate;

public interface SCModelInterface {

	// aggiunta di un nuovo street observer
	void addNewStreetObserver(int id, Double latitude, Double longitude);
	
	// restituisce le info di uno street observer
	Object takeInfoOf(int id);
	
	// verifica se un auto è rubata
	boolean verifyStolenCar(NumberPlate np);
}
