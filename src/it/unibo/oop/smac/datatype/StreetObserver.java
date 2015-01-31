package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.ICoordinates;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Implementazione concreta di un'{@link IStreetObserver}.
 * 
 * @author Federico Bellini
 */
public class StreetObserver implements IStreetObserver{

	private final ICoordinates coordinates;

	/**
	 * Costruttore che prende in ingresso un'{@link IStreetObserver} e ne crea una copia.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} riprodurre.
	 */
	public StreetObserver(IStreetObserver streetObserver) {
		this(streetObserver.getCoordinates());
	}

	/**
	 * Costruttore che crea un nuovo osservatore in base alle coordinate fornite.
	 * 
	 * @param coordinates
	 * 			Le coordinate di posizione dell'osservatore.
	 */
	public StreetObserver(ICoordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	/**
	 * Restituisce le coordinate dove è posizionato l'osservatore.
	 * 
	 * @return
	 * 			Le {@link ICoordinates} relative alla posizione dell'osservatore.
	 */
	@Override
	public ICoordinates getCoordinates() {
		return new Coordinates(this.coordinates); //defensive copy
	}

	/**
	 * Restituisce la latitudine dell'osservatore.
	 * 
	 * @return
	 * 			La latitudine dell'osservatore.
	 */
	@Override
	public Float getLatitude() {
		return new Float(this.coordinates.getLatitude()); //defensive copy
	}

	/**
	 * Restituisce la longitudine dell'osservatore.
	 * 
	 * @return
	 * 			La longitudine dell'osservatore.
	 */
	@Override
	public Float getLongitude() {
		return new Float(this.coordinates.getLongitude()); //defensive copy
	}
	
	/**
	 * Restituisce una stringa contenente un identificatore univoco per l'osservatore.
	 * 
	 * @return
	 * 			L'identificatore univoco dell'osservatore.
	 */
	@Override
	public String getID() {
		return this.getLatitude().toString() + "." + this.getLongitude().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IStreetObserver) {
			return this.coordinates.equals(((IStreetObserver)obj).getCoordinates());
		}
		return false;
	}

	@Override
	public String toString() {
		return "StreetObserver positioned in : " + coordinates;
	}

}
