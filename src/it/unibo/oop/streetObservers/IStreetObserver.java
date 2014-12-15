package it.unibo.oop.streetObservers;

public interface IStreetObserver {
	
	void setID(int id);
	
	int getID();
	
	Double getLat();
	
	Double getLng();
}
