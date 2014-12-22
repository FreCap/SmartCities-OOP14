package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class StreetObserver implements IStreetObserver {

	private Coordinates coordinates;

	public StreetObserver(Coordinates c) {
		this.coordinates = c;
	}

	@Override
	public Coordinates getCoordinates() {

		return coordinates;
	}

	@Override
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
