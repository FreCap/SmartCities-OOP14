package it.unibo.oop.smartercities.view.locationpanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface ILocationPanel {
	
	// aggiunge un nuovo street observer alla mappa
	void addStreetObserver(IStreetObserver streetObserver);
	
	// torna il panel
	JPanel getPanel();
}
