package it.unibo.oop.smartercities.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// questo listener ha il compito di chiedere al controller delle info relative ad uno StreetObserver,
// quando viene richiesto dalla GUI
public interface IInfoObserverListener extends ActionListener{
	
	@Override
	void actionPerformed(ActionEvent e);

}
