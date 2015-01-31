package it.unibo.oop.smac.datatype.I;

import it.unibo.oop.smac.datatype.LicensePlate;

import java.util.Date;

/**
 * Interfaccia per un'avvistamento di un osservatore. La classe che la implementa
 * deve raccogliere tutte le informazioni generate dall'osservatore, quali la data dell'
 * avvistamento, la targa dell'auto avvistata e la sua velocita'.
 * 
 * @author Federico Bellini
 */
public interface ISighting {

	/**
	 * Restituisce l'{@link IStreetObserver} che ha generato le informazioni di questo
	 * avvistamento.
	 * 
	 * @return
	 * 			L'{@link IStreetObserver} autore dell'avvistamento.
	 */
	public IStreetObserver getStreetObserver();

	/**
	 * Restituisce la {@link Date} relativa al momento dell'avvistamento.
	 * 
	 * @return
	 * 			la {@link Date} relativa al momento dell'avvistamento.
	 */
	public Date getDate();

	/**
	 * Restituisce la {@link LicensePlate} dell'auto avvistata.
	 * 
	 * @return
	 * 			La {@link LicensePlate} dell'auto avvistata.
	 */
	public LicensePlate getLicensePlate();

	/**
	 * Restituisce la velocita' dell'auto avvistata.
	 * 
	 * @return
	 * 			La velocita' dell'auto avvistata.
	 */
	public Float getSpeed();
	
}