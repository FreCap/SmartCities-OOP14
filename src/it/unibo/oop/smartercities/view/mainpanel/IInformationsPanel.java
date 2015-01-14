package it.unibo.oop.smartercities.view.mainpanel;

import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;

import javax.swing.JPanel;

public interface IInformationsPanel {

	// mostra le info passate 
	void showInformations(IInfoStreetObserver iso);
	
	// torna il panel
	JPanel getPanel();
}
