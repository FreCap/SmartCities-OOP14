package it.unibo.oop.smac.view.locationpanel;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unibo.oop.smac.datatype.I.ICoordinates;
import it.unibo.oop.smac.view.mainpanel.MainPanel;

/**
 * Implementazione concreta di un {@link MyMapMarker}.
 * Questa implementazione restituisce come immagine per il MapMarker un pin 
 * di colore rosso.
 * Implementazione secondo il pattern Template Method.
 * 
 * @author Federico Bellini
 */
public class RedMapMarker extends MyMapMarker {
	private static final String DEFAULT_RED_PATH = "/images/redPin.png";
	
	/**
	 * Costruttore pubblico.
	 * 
	 * @param id
	 * 			ID che si vuole impostare per il MapMarker.
	 * @param coordinates
	 * 			Coordinate di posizione del MapMarker.
	 */
	public RedMapMarker(String id, ICoordinates coordinates) {
		super(id, coordinates);
	}
	
	/**
	 * Restituisce un'immagine contenente il tipo di MapMarker che si vuole utilizzare.
	 * In questo caso e' un pin di colore rosso.
	 * 
	 * @return
	 * 			I'Image contenente il MapMarker desiderato.
	 */
	@Override
	protected Image getImageForMarker() {
		Image image = null;
		try {
			image = ImageIO.read(MainPanel.class.getResource(DEFAULT_RED_PATH));
		} catch (IOException e) {
		}
		return image;
	}

}