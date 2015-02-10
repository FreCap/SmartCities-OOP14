package it.unibo.oop.smac.model;

import it.unibo.oop.smac.datatypes.IStolenCar;
import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.datatypes.StolenCar;

import java.util.List;

public interface IStolenCarModel {
  static IStolenCarModel getInstance() {
    return null;
  }

  /**
   * Restituisce la lista delle stolenCars del tipo {@link IStolenCar} contenute nel database.
   * 
   * @return Lista di {@link IStolenCar}
   */
  List<IStolenCar> getStolenCarsInfoList();

  /**
   * Controlla se la macchina con una determinata {@link LicensePlate}, è nell'elenco delle
   * macchine. rubate
   * 
   * @return {@link Boolean se la macchina è stata rubata o meno}
   */
  Boolean checkStolenPlate(LicensePlate licensePlate);

  /**
   * Questo metodo deve aggiungere un nuovo {@link IStolenCar} a quelli già presenti nel Model.
   * 
   * @param stolenCar
   *          L'{@link StolenCar} da aggiungere.
   */

  void addNewStolenCar(StolenCar stolenCar);

}