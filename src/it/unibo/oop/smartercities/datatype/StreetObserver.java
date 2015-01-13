package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class StreetObserver implements IStreetObserver {

	private Coordinates<Double> coordinates;

	public StreetObserver(Coordinates<Double> c) {
		this.coordinates = c;
	}
	
	public StreetObserver(IStreetObserver iso) {
		this(iso.getCoordinates());
	}

	@Override
	public Coordinates<Double> getCoordinates() {
		return this.coordinates;
	}
}
