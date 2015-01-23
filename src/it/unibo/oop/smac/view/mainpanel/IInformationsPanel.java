package it.unibo.oop.smac.view.mainpanel;

import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;

import javax.swing.JPanel;

public interface IInformationsPanel {

	// mostra le info passate 
	void showInformations(IInfoStreetObserver iso);
	
	// torna il panel
	JPanel getPanel();
}
