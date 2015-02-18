package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.database.model.DatabaseNotFoundException;
import it.unibo.oop.smac.database.model.StreetObserverModelDatabase;
import it.unibo.oop.smac.datatypes.IInfoStreetObserver;
import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.IStreetObserver;
import it.unibo.oop.smac.datatypes.InfoStreetObserver;
import it.unibo.oop.smac.model.IStreetObserverModel;
import it.unibo.oop.smac.view.IView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementazione del controller dell'applicazione. Tutta l'applicazione e' strutturata secondo il
 * pattern MVC. Questo controller funge anche da Observer per la parte della View.
 * 
 * @author Federico Bellini
 */
public class Controller implements IController {

  /**
   * Logger della classe
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

  /**
   * view dell'applicazione.
   */
  private final IView view;

  /**
   * model dell'applicazione.
   */
  private final IStreetObserverModel model;

  /**
   * Costruttore pubblico della classe. Come parametro prende l'oggetto che compone la View
   * dell'applicazione.
   * 
   * @param v
   *          L'oggetto che implementa la View dell'applicazione
   */
  public Controller(final IView v) {
    model = StreetObserverModelDatabase.getInstance();
    this.view = v;
    this.view.attachStreetObserverController(this);
  }

  /**
   * Notifica che si e' verificato un nuovo passaggio sotto ad un osservatore.
   * 
   * @param streetObserver
   *          L'osservatore che ha compiuto l'avvistamento.
   * @param sighting
   *          Oggetto di tipo {@link ISighting} contenente le informazioni rilevate
   *          dall'osservatore.
   */
  @Override
  public void newSighting(final IStreetObserver streetObserver, final ISighting sighting) {
    LOGGER.info("Car {} has been seen", sighting.getLicensePlate());

    if (!this.model.checkStreetObserverExists(streetObserver)) {
      this.addStreetObserver(streetObserver);
    }
    try {
      model.addSighting(sighting);
      view.newSighting(streetObserver);
    } catch (Exception e) {
      LOGGER.error("Error in signaling a new sighting ", e);
    }
  }

  /**
   * Aggiunge un nuovo {@link IStreetObserver} all'applicazione.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} da aggiungere.
   */
  private void addStreetObserver(final IStreetObserver streetObserver) {
    LOGGER.info("Add street observer", streetObserver.getCoordinates());
    model.addNewStreetObserver(streetObserver);
    view.addStreetObserver(streetObserver);
  }

  /**
   * Restituisce un oggetto del tipo {@link IInfoStreetObserver} contenente le informazioni sull'
   * {@link IStreetObserver} richiesto. In caso di qualche malfunzionamento nel model, viene
   * restituito un oggetto della classe {@link InfoStreetObserver} contenente nessuna informazione.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} di cui si richiedono informazioni.
   * @return Un oggetto {@link IStreetObserver} con le informazioni richieste.
   */
  @Override
  public IInfoStreetObserver getStreetObserverInfo(final IStreetObserver streetObserver) {
    IInfoStreetObserver info;
    try {
      info = model.getStreetObserverInfo(streetObserver);
    } catch (IllegalArgumentException | DatabaseNotFoundException e) {
      LOGGER.error("Error in fetching data ", e);
      // in caso di malfunzionamenti restituisco un info vuota
      info = new InfoStreetObserver.Builder().build();
    }
    return info;
  }

  /**
   * Restituisce la View dell'applicazione.
   * 
   * @return L'{@link IView} dell'applicazione.
   */
  protected IView getView() {
    return this.view;
  }

  /**
   * Restituisce il Model dell'applicazione.
   * 
   * @return Il {@link IStreetObserverModel} dell'applicazione.
   */
  protected IStreetObserverModel getModel() {
    return this.model;
  }

}
