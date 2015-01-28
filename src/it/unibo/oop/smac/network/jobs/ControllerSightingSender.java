package it.unibo.oop.smac.network.jobs;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.Sighting;
import it.unibo.oop.smac.datatype.StreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.network.Dispatcher;
import it.unibo.oop.smac.network.datatye.PlainSighting;

import java.util.Observable;
import java.util.Observer;

public class ControllerSightingSender implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof PlainSighting) {
			PlainSighting sighting = (PlainSighting) arg;
			StreetObserver streetObserver = new StreetObserver(
					sighting.getCoordinates());

			ISighting s = new Sighting.Builder().date(sighting.getDate())
					.streetObserver(streetObserver).speed(sighting.getSpeed())
					.licensePlate(new LicensePlate(sighting.getLicensePlate()))
					.build();
			Dispatcher dispatcher = (Dispatcher) o;
			dispatcher.getController().newPassage(streetObserver, s);
		}
	}

}
