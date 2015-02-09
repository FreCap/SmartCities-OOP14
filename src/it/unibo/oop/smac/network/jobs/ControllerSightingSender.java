package it.unibo.oop.smac.network.jobs;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.Sighting;
import it.unibo.oop.smac.datatype.StreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.network.Dispatcher;
import it.unibo.oop.smac.network.datatype.PlainSighting;

import java.util.Observable;
import java.util.Observer;

import javax.management.InvalidAttributeValueException;

/**
 * Classe implementata con il pattern Observer che alla ricezione da parte di un
 * client di un messaggio di sighting, notifica il controller
 */
public class ControllerSightingSender implements Observer {

	@Override
	public void update(final Observable o, final Object arg) {
		if (arg instanceof PlainSighting) {
			final PlainSighting sighting = (PlainSighting) arg;
			final StreetObserver streetObserver = new StreetObserver(
					sighting.getCoordinates());

			ISighting s = null;
			try {
				s = new Sighting.Builder().date(sighting.getDate())
						.streetObserver(streetObserver).speed(sighting.getSpeed())
						.licensePlate(new LicensePlate(sighting.getLicensePlate()))
						.build();
				final Dispatcher dispatcher = (Dispatcher) o;
				dispatcher.getController().newPassage(streetObserver, s);
			} catch (InvalidAttributeValueException e) {
				// Targa non valida, interrompo la notifica
				e.printStackTrace();
			}

		}
	}

}
