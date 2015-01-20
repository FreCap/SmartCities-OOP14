package it.unibo.oop.smartercities.network.jobs;

import it.unibo.oop.smartercities.database.data.StreetObservers;
import it.unibo.oop.smartercities.datatype.PlainSighting;

import java.util.Observable;
import java.util.Observer;

public class StreetObserverLogger implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof PlainSighting){
			PlainSighting sighting = (PlainSighting) arg;
			try {
				StreetObservers.getInstance().sighting(sighting);
			} catch (Exception e) {
				// errore nell'inserimento
				e.printStackTrace();
			}
		}
	}

}
