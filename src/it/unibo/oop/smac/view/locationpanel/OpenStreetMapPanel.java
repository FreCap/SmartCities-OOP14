package it.unibo.oop.smac.view.locationpanel;

import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import it.unibo.oop.smac.datatype.I.IStreetObserver;

public class OpenStreetMapPanel extends JMapViewer implements ILocationPanel{

	private static final long serialVersionUID = -2763079963863167233L;
	
	public OpenStreetMapPanel() {
		this.setZoomButtonStyle(JMapViewer.ZOOM_BUTTON_STYLE.VERTICAL);
	}

	@Override
	public void addStreetObserver(IStreetObserver<?> streetObserver) {
		this.addMapMarker(new MyMapMarker(streetObserver));
		this.setDisplayToFitMapMarkers();
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

}
