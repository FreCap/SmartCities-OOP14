package it.unibo.oop.smac.view;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Interfaccia realizzata per la gestione della parte di view del programma
 * 
 * @author Federico Bellini
 */
public interface IView {
	
	// aggiunge uno streetObserver alla gui
	void addStreetObserver(IStreetObserver streetObserver);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	void newPassage(IStreetObserver streetObserver);
	
	// attacco degli observers
	void attachStreetObserverObserver(IStreetObserverObserver soo);
		
	// attacco degli observers
	void attachStolenCarsObserver(IStolenCarsObserver sco);
}
