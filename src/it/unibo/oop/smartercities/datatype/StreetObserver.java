package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class StreetObserver implements IStreetObserver {

	private Coordinates coordinates;

	public StreetObserver(Coordinates c) {
		this.coordinates = c;
	}
	
	public StreetObserver(IStreetObserver iso) {
		this(iso.getCoordinates());
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coordinates;
	}
}
