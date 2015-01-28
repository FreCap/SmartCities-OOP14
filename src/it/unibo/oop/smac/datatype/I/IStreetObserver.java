package it.unibo.oop.smac.datatype.I;

import it.unibo.oop.smac.datatype.Coordinates;

public interface IStreetObserver {

	Coordinates getCoordinates();

	Float getLatitude();

	Float getLongitude();

	public String getID();

}