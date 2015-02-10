package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.IStreetObserver;

/**
 * Interfaccia per il controller dell'applicazione. In questo caso la classe che lo implementa deve
 * fungere anche da Observer per gli StreetObserver e per le StolenCars.
 * 
 * @author Federico Bellini
 */
public interface IController extends IStreetObserverObserver {

  /**
   * Notifica che si e' verificato un nuovo passaggio sotto ad un osservatore.
   * 
   * @param streetObserver
   *          L'osservatore che ha compiuto l'avvistamento.
   * @param sighting
   *          Oggetto di tipo {@link ISighting} contenente le informazioni rilevate
   *          dall'osservatore.
   */
  void newPassage(IStreetObserver streetObserver, ISighting sighting);
}
