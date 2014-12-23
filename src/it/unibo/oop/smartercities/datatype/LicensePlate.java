package it.unibo.oop.smartercities.datatype;

public class LicensePlate implements java.io.Serializable {

	private static final long serialVersionUID = 1683170909211988083L;
	private final String licensePlate;	
	
	public LicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	String get() {
		return licensePlate;
	}
}
