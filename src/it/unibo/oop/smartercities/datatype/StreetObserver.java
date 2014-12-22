package it.unibo.oop.smartercities.datatype;

public class StreetObserver implements IStreetObserver{
	
	private final Coordinates coordinates;
	
	// TODO si può implementare come classe generica!
	public StreetObserver(Coordinates c) {
		this.coordinates = c;
	}
	
	@Override
	public Coordinates getPosition() {
		return new Coordinates(this.coordinates);
	}
}
