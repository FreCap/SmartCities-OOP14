package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.database.model.NotFoundException;
import it.unibo.oop.smac.datatypes.IInfoStreetObserver;
import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.IStreetObserver;
import it.unibo.oop.smac.datatypes.InfoStreetObserver;
import it.unibo.oop.smac.model.IStreetObserverModel;
import it.unibo.oop.smac.model.Model;
import it.unibo.oop.smac.view.IView;

/**
 * Implementazione del controller dell'applicazione. Tutta l'applicazione e' strutturata secondo il
 * pattern MVC.
 * 
 * @author Federico Bellini
 */
public class Controller implements IController {

  // view dell'applicazione
  protected final IView view;
  // model dell'applicazione
  protected final IStreetObserverModel model;

  /**
   * Costruttore pubblico della classe. Come parametro prende l'oggetto che compone la View
   * dell'applicazione.
   * 
   * @param view
   *          L'oggetto che implementa la View dell'applicazione
   */
  public Controller(final IView view) {
    model = Model.getInstance();
    this.view = view;
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
  public void newPassage(IStreetObserver streetObserver, ISighting sighting) {
    if (!this.model.checkStreetObserverExists(streetObserver)) {
      this.addStreetObserver(streetObserver);
    }
    try {
      model.addSighting(sighting);
      view.newPassage(streetObserver);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Aggiunge un nuovo {@link IStreetObserver} all'applicazione.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} da aggiungere.
   */
  private void addStreetObserver(final IStreetObserver streetObserver) {
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
    } catch (IllegalArgumentException | NotFoundException e) {
      e.printStackTrace();
      // in caso di malfunzionamenti restituisco un info vuota
      info = new InfoStreetObserver.Builder().build();
    }
    return info;
  }

}
