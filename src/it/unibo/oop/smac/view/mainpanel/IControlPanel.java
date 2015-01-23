package it.unibo.oop.smac.view.mainpanel;

import java.awt.Component;

import javax.swing.JPanel;

public interface IControlPanel {

	// aggiunge uno street observer
	void addStreetObserver(Component comp);
	
	// torna il panel
	JPanel getPanel();
}
