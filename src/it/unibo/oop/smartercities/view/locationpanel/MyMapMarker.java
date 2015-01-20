package it.unibo.oop.smartercities.view.locationpanel;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;
import it.unibo.oop.smartercities.view.mainpanel.MainPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.Random;

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
	
	private static final String DEFAULT_PATH = "/images/";
	private static final STYLE style = STYLE.VARIABLE;
	
	private final String actualPath = DEFAULT_PATH + PinColor.getRandomPin() + ".png";
	private final Coordinate coordinate;
	private Image locationImage = null;
	
	private static enum PinColor{
		redPin(), bluePin(), greenPin(), pinkPin();
		
		private static Random r = new Random();
		
		private PinColor(){
		}
		
		public static String getRandomPin() {
			int c = r.nextInt(1000);
			switch(c% (PinColor.values().length)){
				case 0: return PinColor.bluePin.toString();
				case 1: return PinColor.greenPin.toString();
				case 2: return PinColor.pinkPin.toString();
				default: return PinColor.redPin.toString();
			}
		}
	}
	
	public MyMapMarker(IStreetObserver streetObserver) {
		super(String.valueOf(streetObserver.getID()));
		Coordinates<Double> c = streetObserver.getCoordinates();
		this.coordinate = new Coordinate(c.getLatitude(),c.getLongitude());
		try {
			this.locationImage = ImageIO.read(MainPanel.class.getResource(actualPath));
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
	 *  Paint over the Graphics the image at the position p
	 *  
	 *  @param g the {@link Graphics}
	 *  @param p the point where to paint the image
	 *  @param radio unused
	 */
	@Override
	public void paint(Graphics g, Point p, int radio) {
		g.drawImage(locationImage, (int)p.getX(), (int)p.getY(), null);
	}

}
