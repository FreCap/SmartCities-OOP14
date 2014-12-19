package it.unibo.oop.smartercities.view;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.IStreetObserver;

public interface InfoPanelInterface {
	
	JPanel getPanel();

	void addStreetObserver(IStreetObserver iSo);
	
	void notifyPassage(int id);
}
