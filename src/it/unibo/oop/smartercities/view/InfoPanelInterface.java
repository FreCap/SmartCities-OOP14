package it.unibo.oop.smartercities.view;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.Coordinates;

public interface InfoPanelInterface {
	
	// torna il panel
	JPanel getPanel();

	// aggiunge uno street observer nella GUI
	void addStreetObserver(Coordinates<Double> c);
	
	// la gui mostra che c'è stato un passaggio(sono stati ricevuti dei dati)
	void notifyPassage(Coordinates<Double> c);
}
