package it.unibo.oop.smac.view.locationpanel;

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

// TODO fallo per bene!! questo è un copia e incolla
public class GreenMapMarker extends MapObjectImpl implements MapMarker {
	
	private static final String DEFAULT_PATH = "/images/greenPin.png";
	private static final STYLE style = STYLE.VARIABLE;
	
	private final Coordinate coordinate;
	private Image locationImage = null;
	
	public GreenMapMarker(IStreetObserver streetObserver) {
		super(streetObserver.getID());
		this.coordinate = new Coordinate(streetObserver.getLatitude(), streetObserver.getLongitude());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinate == null) ? 0 : coordinate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyMapMarker){
			return this.coordinate.getLat() == ((MyMapMarker)obj).getLat()
					&& this.coordinate.getLon() == ((MyMapMarker)obj).getLon();
		}
		return false;
	}
	

}