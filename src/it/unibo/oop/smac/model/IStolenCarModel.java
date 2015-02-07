package it.unibo.oop.smac.model;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.List;

public interface IStolenCarModel {
	public static IStolenCarModel getInstance() {
		return null;
	}

	/**
	 * Restituisce la lista delle stolenCars del tipo {@link IStolenCar}
	 * contenute nel database
	 * 
	 * @return Lista di {@link IStolenCar}
	 */
	public List<IStolenCar> getStolenCarsInfoList();

	/**
	 * Controlla se la macchina con una determinata {@link LicensePlate}, è
	 * nell'elenco delle macchine rubate
	 * 
	 * @return {@link Boolean se la macchina è stata rubata o meno}
	 */
	public Boolean checkStolenPlate(LicensePlate licensePlate);

	/**
	 * Questo metodo deve aggiungere un nuovo {@link IStolenCar} a quelli già
	 * presenti nel Model.
	 * 
	 * @param licensePlate
	 *            L'{@link LicensePlate} da aggiungere.
	 */

	void addNewStolenCar(LicensePlate licensePlate);

}