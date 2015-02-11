package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatypes.IStolenCar;
import it.unibo.oop.smac.datatypes.StolenCar;

import java.util.List;

/**
 * Interfaccia che permette (alla View) di accedere in lettura o scrittura ai dati contenuti nel
 * Model dell'applicazione, senza essere a conoscenza dell'implementazione reale del Model.
 * 
 * @author Francesco Capponi
 */
public interface IStolenCarsObserver {

  /**
   * Restituisce la lista di {@link IStolenCar} inserite nel Model fino ad ora.
   * 
   * @return Un oggetto {@link List} composto dalle macchine rubate {@link IStolenCar}.
   */
  List<IStolenCar> getStolenCarsInfoList();

  /**
   * Inserisce una nuova macchina rubata nel Model.
   * 
   * @param stolenCar
   *          L'auto da inserire nel Model tra quelle rubate.
   */
  void addNewStolenCar(StolenCar stolenCar);

}