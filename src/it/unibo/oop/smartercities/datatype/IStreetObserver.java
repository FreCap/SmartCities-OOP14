package it.unibo.oop.smartercities.datatype;

public interface IStreetObserver {
	
	void setID(int id);
	
	int getID();
	
	Coordinates getPosition();
}
