package it.unibo.oop.smartercities.view.mainpanel;

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
public class GoogleStaticMapsConstructor extends Thread{
	
	private static GoogleStaticMapsConstructor SOL_MAP = null;
	
	private static final String DEFAULT_ICON_PATH = "/images/somethingWrongHappened.png";
	private Optional<ImageIcon> controlIcon;
	
	private GoogleStaticMapsConstructor () {
	}
	
	public static synchronized GoogleStaticMapsConstructor getLMC() {
		if(SOL_MAP == null){
			SOL_MAP = new GoogleStaticMapsConstructor();
		}
		return SOL_MAP;
	}
	
	public ImageIcon getMapOf(int id, Double lat, Double lng){
		URL url = new GoogleURLencoder().getURLfor(id, lat, lng);
		controlIcon = GoogleStaticMaps.get(url);
		if(controlIcon.isPresent()){
			return controlIcon.get();
		}
		else{
			return new ImageIcon(GoogleStaticMapsConstructor.class.getResource(DEFAULT_ICON_PATH));
		}
	}
}
