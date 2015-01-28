package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.ICoordinates;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

public class StreetObserver<X extends ICoordinates> implements IStreetObserver<X>{

	private final X coordinates;

	public StreetObserver(IStreetObserver<X> iso) {
		this(iso.getCoordinates());
	}

	public StreetObserver(X coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public X getCoordinates() {
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
		if(obj instanceof IStreetObserver<?>) {
			return this.coordinates.equals(((IStreetObserver<?>)obj).getCoordinates());
		}
		return false;
	}

	@Override
	public String toString() {
		return "StreetObserver [coordinates=" + coordinates + "]";
	}

}
