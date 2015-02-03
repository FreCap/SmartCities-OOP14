package it.unibo.oop.smac.model;

import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.exception.DuplicateFoundException;
import it.unibo.oop.smac.model.exception.NotFoundException;

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
	 * @throws DuplicateFoundException
	 * 			//TODO
	 */
	void addNewStreetObserver(IStreetObserver streetObserver)
			throws DuplicateFoundException;

	/**
	 * Questo metodo deve aggiungere un nuovo {@link ISighting} a quelli già
	 * salvati nel Model.
	 * 
	 * @param sighting
	 *            L'{@link ISighting} da aggiungere.
	 * @throws IllegalArgumentException
	 * 			//TODO
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
	 * @throws NotFoundException
	 * 			//TODO
	 * @throws IllegalArgumentException
	 * 			//TODO
	 */
	IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver)
			throws IllegalArgumentException, NotFoundException;
}
