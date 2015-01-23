package it.unibo.oop.smac.datatype.I;

import it.unibo.oop.smac.datatype.Coordinates;

public interface IStreetObserver {

	// TODO è giusto mettere qui Double come generico, o è meglio rendere
	// generica anche StreetObserver?
	Coordinates<Double> getCoordinates();

	public String getID();
}