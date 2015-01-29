package it.unibo.oop.smac.view.locationpanel;

import it.unibo.oop.smac.datatype.I.ICoordinates;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapObjectImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

/**
 * Questa classe implementa la logica interna di un MapMarker personalizzato da
 * utilizzare in una {@link org.openstreetmap.gui.jmapviewer.JMapViewer}.
 * Questa classe e le sue implementazioni sono implementate secondo il pattern
 * Template Method.
 * 
 * @author Federico Bellini
 */
public abstract class MyMapMarker extends MapObjectImpl implements MapMarker {
	
	private final Coordinate coordinate;
	private Image locationImage = null;
	
	/**
	 * Costruttore pubblico.
	 * 
	 * @param id
	 * 			ID che si vuole impostare per il MapMarker.
	 * @param coordinates
	 * 			Coordinate di posizione del MapMarker.
	 */
	public MyMapMarker(String id, ICoordinates coordinates) {
		super(id);
		this.coordinate = new Coordinate(coordinates.getLatitude(), coordinates.getLongitude());
		this.locationImage = this.getImageForMarker();
	}

	/**
	 * Questo metodo astratto deve restituire l'immagine che si vuole utilizzare come
	 * MapMarker. L'implementazione di esso è lasciato alle sottoclassi, come definito
	 * dal pattern Template Method.
	 * 
	 * @return
	 * 			L'Image che si vuole utilizzare come MapMarker.
	 */
	protected abstract Image getImageForMarker();
	
	/**
	 *  Questa operazione non è supportata
	 *  
	 *  @throws UnsupportedOperationException
	 *  			Questa eccezione viene lanciata quando viene utilizzato questo metodo.
	 */
	@Override
	public void setLat(double arg0) {
		throw new UnsupportedOperationException("Method setLat is unsupported.");
	}

	/**
	 *  Questa operazione non è supportata
	 *  
	 *  @throws UnsupportedOperationException
	 *  			Questa eccezione viene lanciata quando viene utilizzato questo metodo.
	 */
	@Override
	public void setLon(double arg0) {
		throw new UnsupportedOperationException("Method setLon is unsupported.");
	}

	/**
	 * Restituisce le coordinate del punto.
	 * 
	 * @return
	 * 			Le coordinate del punto.
	 */
	@Override
	public Coordinate getCoordinate() {
		// safety copy
		return new Coordinate(this.coordinate.getLat(), this.coordinate.getLon());
	}

	/**
	 * Restituisce la latitudine del punto.
	 * 
	 * @return
	 * 			La latitudine del punto.
	 */
	@Override
	public double getLat() {
		return this.coordinate.getLat();
	}

	/**
	 * Restituisce la longitudine del punto.
	 * 
	 * @return
	 * 			La longitudine del punto.
	 */
	@Override
	public double getLon() {
		return this.coordinate.getLon();
	}

	/**
	 * Restituisce lo stile del mapMarker.
	 * 
	 * @return
	 * 			Lo stile del mapMarker.
	 */
	@Override
	public STYLE getMarkerStyle() {
		return STYLE.VARIABLE;
	}

	/**
	 * Restituisce il raggio del marker.
	 * 
	 * @return
	 * 			Il raggio del marker.
	 */
	@Override
	public double getRadius() {
		return 0;
	}

	/**
	 * Disegna sul {@link Graphics} l'immagine alla posizione p
	 *  
	 *  @param g 
	 *  		Il {@link Graphics}
	 *  @param p 
	 *  		Il {@link Point} dove disegnare l'immagine
	 *  @param radio
	 *  		Inutilizzato
	 */
	@Override
	public void paint(Graphics g, Point p, int radio) {
		g.drawImage(locationImage, (int)p.getX(), (int)p.getY(), null);
	}

	/**
	 * Override della funzione hashCode della classe Object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinate == null) ? 0 : coordinate.hashCode());
		return result;
	}

	/**
	 * Override della funzione equals della classe Object.
	 * In questo caso due MyMapMarker vengono ritenuti uguali se hanno stesse coordinate.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyMapMarker){
			return this.coordinate.getLat() == ((MyMapMarker)obj).getLat()
					&& this.coordinate.getLon() == ((MyMapMarker)obj).getLon();
		}
		return false;
	}

}
