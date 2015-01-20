package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class StreetObserver implements IStreetObserver {

	private final Coordinates<Double> coordinates;

	public StreetObserver(Coordinates<Double> c, int id) {
		this.coordinates = c;
	}

	public StreetObserver(IStreetObserver iso) {
		this(iso.getCoordinates());
	}

	public StreetObserver(Coordinates<Double> coordinate) {
		this.coordinates = coordinate;
	}

	@Override
	public Coordinates<Double> getCoordinates() {
		return new Coordinates<>(this.coordinates);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StreetObserver) {
			return this.coordinates.equals(((StreetObserver) obj)
					.getCoordinates());
		}
		return false;
	}

	@Override
	public String toString() {
		return "StreetObserver [coordinates=" + coordinates + "]";
	}

}
