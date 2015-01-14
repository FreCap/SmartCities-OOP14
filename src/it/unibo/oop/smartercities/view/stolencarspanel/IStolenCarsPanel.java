package it.unibo.oop.smartercities.view.stolencarspanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.I.IStolenCar;

public interface IStolenCarsPanel {
	
	// mostra le informazioni su di una determinata auto
	void showInfo(IStolenCar sc);
	
	// torna il panel
	JPanel getPanel();
}
