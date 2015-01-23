package it.unibo.oop.smac.view.stolencarspanel;

import javax.swing.JPanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

public interface IStolenCarsPanel {
	
	// mostra le informazioni su di una determinata auto
	void showInfo(IInfoStolenCar isc);
	
	// attacco degli observers
	void attachStolenCarsObserver(IStolenCarsObserver sco);
	
	// torna il panel
	JPanel getPanel();
}
