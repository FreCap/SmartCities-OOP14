package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.control.ControllerInterface;
import it.unibo.oop.smartercities.datatype.Coordinates;

public interface ViewInterface {
	
	void newPlug(Coordinates c);
	
	void addStreetObserver(Coordinates c);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	// all'osservetore con corrispettivo id
	void newPassage(Coordinates c);
	
	// aggiunge un osservatore(controller)
	void attachViewObserver(final ControllerInterface controller);
}
