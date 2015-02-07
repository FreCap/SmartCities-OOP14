package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.Date;

/**
 * Implementazione concreta di un'{@link IStolenCar}.
 */
public class StolenCar implements IStolenCar {

	/**
	 * Attributo contente la targa della macchina rubata.
	 */
	private LicensePlate licensePlate;

	/**
	 * Attributo contenente la data del furto della macchina
	 */
	private Date insertionDate;

	/**
	 * Costruttore della classe che permette l'inizializzazione dei suoi campi
	 * 
	 * @param licensePlate
	 * @param insertionDate
	 */
	public StolenCar(LicensePlate licensePlate, Date insertionDate) {
		this.licensePlate = licensePlate;
		this.insertionDate = insertionDate;
	}

	/**
	 * Restituisce la targa della macchina rubata.
	 * 
	 * @return targa della macchina rubata
	 */
	@Override
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Restituisce la data del furto della macchina
	 * 
	 * @return data del furto
	 */
	@Override
	public Date getInsertionDate() {
		return insertionDate;
	}

}
