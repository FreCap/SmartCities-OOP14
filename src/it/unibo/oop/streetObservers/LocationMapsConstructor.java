package it.unibo.oop.streetObservers;

import java.net.URL;
import java.util.Optional;

import javax.swing.*;


/**
 * 
 * @author Federico Bellini
 *
 * PATTERN SINGLETON!!
 * 
 */
public class LocationMapsConstructor {
	
	private static LocationMapsConstructor SOL_MAP = null;
	
	private static final String DEFAULT_ICON_PATH = "res/images/somethingWrongHappened.png";
	private Optional<ImageIcon> controlIcon;
	
	private LocationMapsConstructor () {
	}
	
	public static synchronized LocationMapsConstructor getLMC() {
		if(SOL_MAP == null){
			SOL_MAP = new LocationMapsConstructor();
		}
		return SOL_MAP;
	}
	
	public ImageIcon getMapOf(int id, Double lat, Double lng){
		URL url = new URLencoder().getURLfor(id, lat, lng);
		controlIcon = GetImageFromGoogle.get(url);
		if(controlIcon.isPresent()){
			return controlIcon.get();
		}
		else{
			return new ImageIcon(DEFAULT_ICON_PATH);
		}
	}
}
