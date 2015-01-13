package it.unibo.oop.smartercities.datatype;

public class Coordinates <X extends Number>{
	
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

}
