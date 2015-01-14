package it.unibo.oop.smartercities.view.mainpanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.controller.IStreetObserverObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IMainPanel {

	// aggiunge uno street observer nella GUI
	void addStreetObserver(IStreetObserver streetObserver);
	
	// la gui mostra che c'è stato un passaggio(sono stati ricevuti dei dati)
	void notifyPassage(IStreetObserver streetObserver);
	
	// attacco degli observers
	void attachStreetObserverObserver(IStreetObserverObserver soo);
	
	// torna il panel
	JPanel getPanel();
}
