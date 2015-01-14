package it.unibo.oop.smartercities.view.mainpanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.Coordinates;

public interface IMainPanel {

	// aggiunge uno street observer nella GUI
	void addStreetObserver(Coordinates<Double> c);
	
	// la gui mostra che c'è stato un passaggio(sono stati ricevuti dei dati)
	void notifyPassage(Coordinates<Double> c);
	
	// torna il panel
	JPanel getPanel();
}
