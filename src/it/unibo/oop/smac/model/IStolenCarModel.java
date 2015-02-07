package it.unibo.oop.smac.model;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.List;


public interface IStolenCarModel {
	public static IStolenCarModel getInstance() {
		return null;
	}

	public List<IInfoStolenCar> getStolenCarsInfoList();

	public Boolean checkStolenPlate(LicensePlate licensePlate);
	
	/**
	 * Questo metodo deve restituire un oggetto del tipo {@link IInfoStolenCar}
	 * contenente i dati dell'{@link IStolenCar} richiesto.
	 * 
	 * @param stolenCar
	 *            L'{@link IStolenCar} di cui si vogliono le informazioni.
	 * @return Un {@link IInfoStolenCar} contenente le informazioni sull'
	 *         {@link IStolenCar} richiesto.
	 */
	IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar);

	void addNewStolenCar(LicensePlate licensePlate);

}