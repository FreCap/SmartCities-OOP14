package it.unibo.oop.smartercities.database.data.I;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IStreetObservers {
	
	public static IStreetObserver getInstance() {return null;}
	
	public IStreetObserver add(Coordinates<Double> streetObserver) throws Exception;

	public IStreetObserver sighting(PlainSighting sighting) throws Exception;

	public IStreetObserver getStreetObserver(Coordinates<Double> coordinate) throws Exception;

}
