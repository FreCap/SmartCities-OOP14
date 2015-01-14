package it.unibo.oop.smartercities.view.mainpanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.InfoStreetObserver;

public interface IInformationsPanel {

	// mostra le info passate 
	void showInformations(InfoStreetObserver iso);
	
	// torna il panel
	JPanel getPanel();
}
