package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.StolenCar;
import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.List;

/**
 * Interfaccia che permette alla View di accedere ai dati del model, senza
 * essere a conoscenza dell'implementazione del model
 */

public interface IStolenCarsObserver {
	/**
	 * Restituisce la lista di oggetti del tipo {@link IStolenCar} delle
	 * macchine rubate inserite nel model fino ad ora
	 * 
	 * @return Un oggetto {@link List} composto dalle macchine rubate
	 *         {@link IStolenCar}
	 */
	public List<IStolenCar> getStolenCarsInfoList();

	/**
	 * Inserisce una nuova macchina rubata nel model
	 * 
	 * @param stolenCar
	 *            Inserisce la macchina con una determianta targa nella lista
	 *            delle macchine rubate
	 */
	void addNewStolenCar(StolenCar stolenCar);

}