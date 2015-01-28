package it.unibo.oop.smac.view.locationpanel;

import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.view.mainpanel.MainPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapObjectImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

/**
 * Questa classe implementa un MapMarker personalizzato da utilizzare in una 
 * {@link org.openstreetmap.gui.jmapviewer.JMapViewer}
 * 
 * @author Federico Bellini
 */
public class MyMapMarker extends MapObjectImpl implements MapMarker {
	
	private static final String DEFAULT_PATH = "/images/redPin.png";
	private static final STYLE style = STYLE.VARIABLE;
	
	private final Coordinate coordinate;
	private Image locationImage = null;
	
	public MyMapMarker(IStreetObserver streetObserver) {
		super(streetObserver.getID());
		Coordinates<Double> c = streetObserver.getCoordinates();
		this.coordinate = new Coordinate(c.getLatitude(),c.getLongitude());
		try {
			this.locationImage = ImageIO.read(MainPanel.class.getResource(DEFAULT_PATH));
		} catch (IOException e) {
		}
	}

	/**
	 *  Questa operazione non è supportata
	 *  
	 *  @throws java.lang.UnsupportedOperationException Questa eccezione viene lanciata
	 *  		quando viene utilizzato questo metodo.
	 */
	@Override
	public void setLat(double arg0) {
		throw new UnsupportedOperationException("Method setLat is unsupported.");
	}

	/**
	 *  Questa operazione non è supportata
	 *  
	 *  @throws java.lang.UnsupportedOperationException Questa eccezione viene lanciata
	 *  		quando viene utilizzato questo metodo.
	 */
	@Override
	public void setLon(double arg0) {
		throw new UnsupportedOperationException("Method setLon is unsupported.");
	}

	@Override
	public Coordinate getCoordinate() {
		return new Coordinate(this.coordinate.getLat(), this.coordinate.getLon());
	}

	@Override
	public double getLat() {
		return this.coordinate.getLat();
	}

	@Override
	public double getLon() {
		return this.coordinate.getLon();
	}

	@Override
	public STYLE getMarkerStyle() {
		return style;
	}

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

}
