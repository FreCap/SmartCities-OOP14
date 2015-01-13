package it.unibo.oop.smartercities.view;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.Coordinates;

public interface InfoPanelInterface {
	
	JPanel getPanel();

	void addStreetObserver(Coordinates<Double> c);
	
	void notifyPassage(Coordinates<Double> c);
}
