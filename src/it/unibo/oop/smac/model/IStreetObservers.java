package it.unibo.oop.smac.model;

import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.exception.NotFound;

/**
 * Interfaccia del Model dell'applicazione.
 * 
 * @author Federico Bellini
 *
 */
public interface IStreetObservers {

	/**
	 * Questo metodo deve aggiungere un nuovo {@link IStreetObserver} a quelli
	 * già salvati nel Model.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} da aggiungere.
	 */
	void addNewStreetObserver(IStreetObserver<?> streetObserver);

	/**
	 * Questo metodo deve aggiungere un nuovo {@link ISighting} a quelli già
	 * salvati nel Model.
	 * 
	 * @param sighting
	 *            L'{@link ISighting} da aggiungere.
	 * @throws NotFound 
	 * @throws IllegalArgumentException 
	 */
	void addSighting(ISighting sighting) throws IllegalArgumentException;

	/**
	 * Questo metodo deve restituire un oggetto del tipo
	 * {@link IInfoStreetObserver} contenente i dati dell'
	 * {@link IStreetObserver} richiesto.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} di cui si vogliono le informazioni.
	 * @return Un {@link IInfoStreetObserver} contenente le informazioni sull'
	 *         {@link IStreetObserver} richiesto.
	 * @throws NotFound 
	 * @throws IllegalArgumentException 
	 */
	IInfoStreetObserver getStreetObserverInfo(IStreetObserver<?> streetObserver) throws IllegalArgumentException, NotFound;

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
}
