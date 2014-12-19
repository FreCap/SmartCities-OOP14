package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.control.ControllerInterface;
import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.IStreetObserver;

public interface ViewInterface {
	
	void newPlug(Coordinates c);
	
	void addStreetObserver(IStreetObserver so);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	// all'osservetore con corrispettivo id
	void newPassage(int id);
	
	// aggiunge un osservatore(controller)
	void attachViewObserver(final ControllerInterface controller);
}
