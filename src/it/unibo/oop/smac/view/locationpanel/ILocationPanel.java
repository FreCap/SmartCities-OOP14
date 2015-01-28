package it.unibo.oop.smac.view.locationpanel;

import javax.swing.JPanel;

import it.unibo.oop.smac.datatype.I.IStreetObserver;

public interface ILocationPanel {
	
	// aggiunge un nuovo street observer alla mappa
	void addStreetObserver(IStreetObserver streetObserver);

	// torna il panel
	JPanel getPanel();
}
