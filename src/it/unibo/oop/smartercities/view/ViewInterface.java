package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.control.ControllerInterface;
import it.unibo.oop.smartercities.datatype.Coordinates;

public interface ViewInterface {
	
	void addStreetObserver(Coordinates<Double> c);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	// all'osservetore con corrispettivo id
	void newPassage(Coordinates<Double> c);
	
	// aggiunge un osservatore(controller)
	void attachViewObserver(final ControllerInterface controller);
}
