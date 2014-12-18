package it.unibo.oop.streetObservers;

public class StreetObserver implements IStreetObserver{
	
	// tollero che cambi id, ma non che cambi posizione
	private int id;
	private final Double LATITUDE;
	private final Double LONGITUDE;
	
	// TODO
	//private final dataCreazione
	//private final dataUltimoAvvistamento
	
	public StreetObserver(int id, Double lat, Double lng) {
		this.id = id;
		this.LATITUDE = lat;
		this.LONGITUDE= lng;
	}
	
	@Override
	public void setID(int id) {
		this.id = id;
	}
	
	@Override
	public int getID() {
		return this.id;
	}
	
	@Override
	public Double getLat() {
		return LATITUDE;
	}
	
	@Override
	public Double getLng() {
		return LONGITUDE;
	}
}
