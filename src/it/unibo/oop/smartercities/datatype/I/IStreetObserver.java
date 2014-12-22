package it.unibo.oop.smartercities.datatype.I;

import it.unibo.oop.smartercities.datatype.Coordinates;

public interface IStreetObserver {

	public Coordinates getCoordinates();

	public void setCoordinates(Coordinates coordinates);

}