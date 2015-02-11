package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.database.model.StolenCarModelDatabase;
import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.IStolenCar;
import it.unibo.oop.smac.datatypes.IStreetObserver;
import it.unibo.oop.smac.datatypes.StolenCar;
import it.unibo.oop.smac.model.IStolenCarModel;
import it.unibo.oop.smac.view.IView;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO utilizzato pattern Decorator.
 * 
 */
public class StolenCarsController extends Controller implements IStolenCarsObserver {

  /**
   * Logger della classe
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(StolenCarsController.class);

  /**
   * Model dell'applicazione.
   */
  protected final IStolenCarModel modelStolenCars;

  /**
   * Costruttore pubblico della classe. Come parametro prende l'oggetto che compone la View
   * dell'applicazione.
   * 
   * @param view
   *          L'oggetto che implementa la View dell'applicazione
   */
  public StolenCarsController(final IView view) {
    super(view);
    modelStolenCars = StolenCarModelDatabase.getInstance();
    this.view.attachStolenCarsController(this);
  }

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
   * @param licensePlate
   *          targa della macchina rubata
   */
  @Override
  public void addNewStolenCar(final StolenCar stolenCar) {
    modelStolenCars.addNewStolenCar(stolenCar);
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
  public void newPassage(final IStreetObserver streetObserver, final ISighting sighting) {
    super.newPassage(streetObserver, sighting);

    // controllo che non si tratti di una rubata
    if (modelStolenCars.checkStolenPlate(sighting.getLicensePlate())) {
      this.view.newPassageStolenCar(sighting);
    }
  }

}
