package it.unibo.oop.smac.network.jobs;

import it.unibo.oop.smac.model.Model;

import java.util.Observable;
import java.util.Observer;

public class StreetObserverLogger implements Observer{

	@Override
	public void update(Observable o, Object arg) {/*
		if(arg instanceof PlainSighting){
			PlainSighting sighting = (PlainSighting) arg;
			try {
				IStreetObservers streetObserverData = StreetObservers.getInstance();
				try{
					streetObserverData.getStreetObserver(sighting.getCoordinates());
				}catch(Exception notFound){
					//TODO change exception
					//streetObserverData.add(sighting.getCoordinates());
				}
				streetObserverData.sighting(sighting);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	}

}
