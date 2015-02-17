package it.unibo.oop.smac.controller;


/**
 * Interfaccia che permette (alla View) di accedere in lettura o scrittura ai dati contenuti nel
 * Model dell'applicazione, senza essere a conoscenza dell'implementazione reale del Model.
 * 
 * @author Francesco Capponi
 */
public interface IStolenCarsController extends IStolenCarsObserver, IController {

}