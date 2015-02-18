package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.database.model.StolenCarModelDatabase;
import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.IStolenCar;
import it.unibo.oop.smac.datatypes.IStreetObserver;
import it.unibo.oop.smac.datatypes.StolenCar;
import it.unibo.oop.smac.model.IStolenCarModel;
import it.unibo.oop.smac.view.stolencars.IViewStolenCars;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementazione del Controller dell'applicazione, con l'aggiunta dei metodi necessari per la
 * gestione delle auto rubate. Questo controller funge anche da Observer per la parte della View.
 * 
 * @author Francesco Capponi
 */
public class StolenCarsController extends Controller implements IStolenCarsController {

  /**
   * Model dell'applicazione.
   */
  private final IStolenCarModel modelStolenCars;

  /**
   * Observer che si metterà in ascolto degli eventi passati dalla GUI
   */
  private final IStolenCarsObserver observer = new IStolenCarsObserver() {
    /**
     * Restituisce la lista dele stolen cars.
     * 
     * @return lista delle macchine rubate
     */
    @Override
    public List<IStolenCar> getStolenCarsInfoList() {
      return modelStolenCars.getStolenCarsInfoList();
    }

    /**
     * Aggiunge una nuova stolen car al model.
     * 
     * @param stolenCar
     *          L'auto rubata
     */
    @Override
    public void addNewStolenCar(final StolenCar stolenCar) {
      modelStolenCars.addNewStolenCar(stolenCar);
    }

    /**
     * Avvisa il controller che c'è stato un nuovo sighting
     * 
     * @param streetObserver
     *          streetObserver che effettua l'avvistamento
     * @param sighting
     *          sighting da aggiungere
     */
    @Override
    public void newSighting(final IStreetObserver streetObserver, final ISighting sighting) {
      StolenCarsController.this.newSighting(streetObserver, sighting);
    }
  };

  /**
   * Costruttore pubblico della classe. Presume che le view saranno aggiunte successivamente
   * 
   */
  public StolenCarsController() {
    super();
    modelStolenCars = StolenCarModelDatabase.getInstance();
  }

  /**
   * Costruttore pubblico della classe. Come parametro prende l'oggetto che compone la View
   * dell'applicazione.
   * 
   * @param view
   *          L'oggetto che implementa la View dell'applicazione
   */
  public StolenCarsController(final IViewStolenCars view) {
    super();
    modelStolenCars = StolenCarModelDatabase.getInstance();
    this.addView(view);
  }

  /**
   * Viene aggiunta una View all'applicazione
   * 
   * @param v
   *          view da aggiungere
   */
  @Override
  public void addView(final IViewStolenCars v) {
    super.addView(v);
    v.attachStolenCarsController(observer);
  }

  /**
   * Aggiunge un pasaggio al model, e notifica la view Controlla se la macchina è stata rubata e
   * agisce di conseguenza.
   * 
   * @param streetObserver
   *          streetObserver che effettua l'avvistamento
   * @param sighting
   *          sighting da aggiungere
   */
  @Override
  public void newSighting(final IStreetObserver streetObserver, final ISighting sighting) {
    super.newSighting(streetObserver, sighting);

    // controllo che non si tratti di una rubata
    if (modelStolenCars.checkStolenPlate(sighting.getLicensePlate())) {
      this.getViewsStolenCars().forEach((view) -> view.newSightingStolenCar(sighting));

    }
  }

  /**
   * Restituisce il Model dell'applicazione.
   * 
   * @return Il {@link IStolenCarModel} dell'applicazione.
   */
  @Override
  protected IStolenCarModel getModel() {
    return this.modelStolenCars;
  }

  /**
   * Restituisce le view associate all'applicazione
   * 
   * @return views attive nell'applicazione
   */
  @Override
  public List<IViewStolenCars> getViewsStolenCars() {
    final List<IViewStolenCars> list = new ArrayList<IViewStolenCars>();
    super.getViews().forEach((view) -> {
      if (view instanceof IViewStolenCars) {
        list.add((IViewStolenCars) view);
      }
    });
    return list;
  }
}
