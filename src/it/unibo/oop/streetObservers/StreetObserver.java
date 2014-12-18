package it.unibo.oop.streetObservers;

public class StreetObserver implements IStreetObserver{
	
	private int id;
	private final Double LATITUDE;
	private final Double LONGITUDE;
	
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
