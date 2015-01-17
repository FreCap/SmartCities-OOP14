package it.unibo.oop.smartercities.view.locationpanel;

import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class OpenStreetMapPanel extends JMapViewer implements ILocationPanel{

	private static final long serialVersionUID = -2763079963863167233L;
	
	public OpenStreetMapPanel() {
		this.setZoomButtonStyle(JMapViewer.ZOOM_BUTTON_STYLE.VERTICAL);
	}

	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.addMapMarker(new MapMarkerDot(streetObserver.getCoordinates().getLatitude(), streetObserver.getCoordinates().getLongitude()));
		this.setDisplayToFitMapMarkers();
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

}
