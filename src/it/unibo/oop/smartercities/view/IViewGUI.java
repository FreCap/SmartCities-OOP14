package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.listeners.IInfoObserverListener;
import it.unibo.oop.smartercities.listeners.IStolenCarsListener;

public interface IViewGUI {
	
	void addStreetObserver(Coordinates<Double> c);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	// all'osservetore con corrispettivo id
	void newPassage(Coordinates<Double> c);
	
	//attacca i due listener della gui
	void attachInfoSOListener(IInfoObserverListener ioL);
	void attachStolenCarsListener(IStolenCarsListener scL);
}
