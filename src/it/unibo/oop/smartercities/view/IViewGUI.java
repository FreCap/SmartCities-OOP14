package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.controller.IStolenCarsObserver;
import it.unibo.oop.smartercities.controller.IStreetObserverObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IViewGUI {
	
	// aggiunge uno streetObserver alla gui
	void addStreetObserver(IStreetObserver streetObserver);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	void newPassage(IStreetObserver streetObserver);
	
	// attacco degli observers
	void attachStreetObserverObserver(IStreetObserverObserver soo);
		
	// attacco degli observers
	void attachStolenCarsObserver(IStolenCarsObserver sco);
}
