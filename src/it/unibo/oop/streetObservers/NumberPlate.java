package it.unibo.oop.streetObservers;

public class NumberPlate {

	private final String np;
	
	public NumberPlate(String np){
		this.np = np;
	}
	
	String get() {
		return np.toString();
	}
}
