package it.unibo.oop.smartercities.datatype.I;

import it.unibo.oop.smartercities.datatype.Coordinates;

public interface IStreetObserver {

	// TODO è giusto mettere qui Double come generico, o è meglio rendere
	// generica anche StreetObserver?
	Coordinates<Double> getCoordinates();

	public String getID();
}