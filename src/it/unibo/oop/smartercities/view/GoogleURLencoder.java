package it.unibo.oop.smartercities.view;

import java.net.MalformedURLException;
import java.net.URL;

// TODO
// estendi da qualche classe URL encored, per fare di questo un oggetto speciale di encoder
// UTILIZZALO COME PATTERN SINGLETON!!

public class GoogleURLencoder {
	
	private static final String STATIC_MAP_REQUEST_PREFIX = "https://maps.googleapis.com/maps/api/staticmap";
	private static final int DEFAULT_ZOOM = 13;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private static final String DEFAULT_MAPTYPE = "roadmap";
	private static final String DEFAULT_MARKERCOLOR = "red";
	
	private int zoom;
	private int sizeWidth;
	private int sizeHeight;
	private String maptype;
	private String markerColor;
	
	// TODO fallo privato tanto è inutile
	public GoogleURLencoder () {
		this.zoom = DEFAULT_ZOOM;
		this.sizeWidth = DEFAULT_WIDTH;
		this.sizeHeight = DEFAULT_HEIGHT;
		this.maptype = DEFAULT_MAPTYPE;
		this.markerColor = DEFAULT_MARKERCOLOR;
	}
	
	public URL getURLfor(int labelID, double lat, double lng) {
		try {
			return new URL( new StringBuilder()
								.append(STATIC_MAP_REQUEST_PREFIX)
								.append("?center=" + lat + "," + lng)
								.append("&zoom=" + zoom)
								.append("&size=" + sizeWidth + "x" + sizeHeight)
								.append("&maptype=" + maptype)
								.append("&markers=color:" + markerColor + "%7Clabel:" + labelID + "%7C" + lat + "," + lng)
								.toString());
		}
		catch(MalformedURLException e) {
			//TODO fa qualcosa per questa povera eccezione
			e.printStackTrace();
			return null;
		}
	}

}
