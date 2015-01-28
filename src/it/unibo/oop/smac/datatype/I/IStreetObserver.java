package it.unibo.oop.smac.datatype.I;

public interface IStreetObserver <X extends ICoordinates> {

	X getCoordinates();
	
	Float getLatitude();
	
	Float getLongitude();

	public String getID();

}