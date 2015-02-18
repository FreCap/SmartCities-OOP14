package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.view.stolencars.IViewStolenCars;

import java.util.List;

/**
 * Interfaccia che permette (alla View) di accedere in lettura o scrittura ai dati contenuti nel
 * Model dell'applicazione, senza essere a conoscenza dell'implementazione reale del Model.
 * 
 * @author Francesco Capponi
 */
public interface IStolenCarsController extends IController {

  /**
   * Restituisce le view associate all'applicazione
   * 
   * @return views attive nell'applicazione
   */
  List<IViewStolenCars> getViewsStolenCars();

  /**
   * Viene aggiunta una View all'applicazione
   * 
   * @param v
   *          view da aggiungere
   */
  void addView(IViewStolenCars v);

}