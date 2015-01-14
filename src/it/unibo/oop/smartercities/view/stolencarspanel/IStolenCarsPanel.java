package it.unibo.oop.smartercities.view.stolencarspanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;

public interface IStolenCarsPanel {
	
	// mostra le informazioni su di una determinata auto
	void showInfo(IInfoStolenCar isc);
	
	// torna il panel
	JPanel getPanel();
}
