package it.unibo.oop.smartercities.datatype;

public class StreetObserver implements IStreetObserver{
	
	private int id;
	private final Coordinates location;
	
	public StreetObserver(int id, Double latitude, Double longitude) {
		this.id = id;
		this.location = new Coordinates(latitude, longitude);
	}
	
	@Override
	public void setID(int id) {
		this.id = id;
	}
	
	@Override
	public int getID() {
		int idCopy = this.id;
		return idCopy;
	}
	
	@Override
	public Coordinates getPosition() {
		return new Coordinates(this.location);
	}
}
