package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.IStreetObserver;

public class StreetObserver implements IStreetObserver{

	private final Coordinates coordinates;

	public StreetObserver(IStreetObserver iso) {
		this(iso.getCoordinates());
	}

	public StreetObserver(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	@Override
	public Float getLatitude() {
		return this.coordinates.getLatitude();
	}

	@Override
	public Float getLongitude() {
		return this.coordinates.getLongitude();
	}
	
	@Override
	public String getID() {
		return this.getLatitude().toString() + this.getLongitude().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IStreetObserver) {
			return this.coordinates.equals(((IStreetObserver)obj).getCoordinates());
		}
		return false;
	}

	@Override
	public String toString() {
		return "StreetObserver [coordinates=" + coordinates + "]";
	}

}
