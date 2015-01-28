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
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.addMapMarker(new MyMapMarker(streetObserver));
		this.setDisplayToFitMapMarkers();
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public void notifyPassage(IStreetObserver streetObserver) {
		removeStreetObserver(streetObserver);
		
		GreenMapMarker g = new GreenMapMarker(streetObserver);
		this.addMapMarker(g);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.removeMapMarker(g);
		
		this.addMapMarker(new MyMapMarker(streetObserver));
		
	}
	
	private void removeStreetObserver(IStreetObserver streetObserver){
		this.removeMapMarker(new MyMapMarker(streetObserver));
	}

}
