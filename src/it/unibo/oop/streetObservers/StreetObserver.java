package it.unibo.oop.streetObservers;

import javax.swing.ImageIcon;

public class StreetObserver {

	private final int ID;
	private final Double LATITUDE;
	private final Double LONGITUDE;
	private final ImageIcon ICON;
	
	// TODO
	//private final dataCreazione
	//private final dataUltimoAvvistamento
	
	public StreetObserver(int id, Double lat, Double lng) {
		this.ID = id;
		this.LATITUDE = lat;
		this.LONGITUDE= lng;
		this.ICON = new StreetObserverLocationMap().getMapOf(this. ID, this.LATITUDE, this.LONGITUDE);
	}
	
	public int getID() {
		return ID;
	}
	
	public Double getLat() {
		return LATITUDE;
	}

	public Double getLng() {
		return LONGITUDE;
	}
	
	public ImageIcon getPositionMap() {
		return ICON;
	}

}
