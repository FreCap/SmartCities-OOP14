package it.unibo.oop.smartercities.datatype;

public class Coordinates {
	
	private final double latitude;
	private final double longitude;
	
	public Coordinates(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coordinates(Coordinates coord) {
		this(coord.getLatitude(), coord.getLongitude());
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Coordinates) {
			return this.getLatitude() == ((Coordinates)o).getLatitude() && this.getLongitude() == ((Coordinates)o).getLongitude();
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
