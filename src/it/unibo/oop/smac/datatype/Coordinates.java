package it.unibo.oop.smac.datatype;

import java.io.Serializable;

public class Coordinates <X extends Number> implements Serializable{

	private static final long serialVersionUID = 6127098657709069219L;

	private static final int DECIMAL_PRECISION = 6;
	
	private final X latitude;
	private final X longitude;
	
	public Coordinates(X number, X number2) {
		this.latitude = number;
		this.longitude = number2;
	}
	
	public Coordinates(Coordinates<X> coord) {
		this(coord.getLatitude(), coord.getLongitude());
	}

	public X getLongitude() {
		return longitude;
	}

	public X getLatitude() {
		return latitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coordinates<?>){
			Coordinates<?> other = (Coordinates<?>)obj;
			return this.latitude == other.getLongitude() && 
					this.longitude == other.getLongitude();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Latitude = " + 
				latitude.toString().substring(0, latitude.toString().indexOf('.') + DECIMAL_PRECISION) + 
				", Longitude = " + 
				longitude.toString().substring(0, longitude.toString().indexOf('.') + DECIMAL_PRECISION);
	}

}
