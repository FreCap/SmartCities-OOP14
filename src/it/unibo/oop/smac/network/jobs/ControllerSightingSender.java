package it.unibo.oop.smac.network.jobs;

import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.datatypes.Sighting;
import it.unibo.oop.smac.datatypes.StreetObserver;
import it.unibo.oop.smac.network.Dispatcher;
import it.unibo.oop.smac.network.datatype.PlainSighting;

import java.util.Observable;
import java.util.Observer;

import javax.management.InvalidAttributeValueException;

/**
 * Classe implementata con il pattern Observer che alla ricezione da parte di un client di un
 * messaggio di sighting, notifica il controller.
 */
public class ControllerSightingSender implements Observer {

  @Override
  public void update(final Observable observable, final Object arg) {
    if (arg instanceof PlainSighting) {
      final PlainSighting netSighting = (PlainSighting) arg;
      final StreetObserver streetObserver = new StreetObserver(netSighting.getCoordinates());

      ISighting sighting = null;
      try {
        sighting = new Sighting.Builder().date(netSighting.getDate())
            .streetObserver(streetObserver).speed(netSighting.getSpeed())
            .licensePlate(new LicensePlate(netSighting.getLicensePlate())).build();
        final Dispatcher dispatcher = (Dispatcher) observable;
        dispatcher.getController().newPassage(streetObserver, sighting);
      } catch (InvalidAttributeValueException e) {
        // Targa non valida, interrompo la notifica
        e.printStackTrace();
      }

    }
  }

}
