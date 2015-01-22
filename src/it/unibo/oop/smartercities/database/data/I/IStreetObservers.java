package it.unibo.oop.smartercities.database.data.I;

import java.sql.SQLException;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IStreetObservers {
	
	public static IStreetObserver getInstance() {return null;}
	
	public void add(IStreetObserver streetObserver) throws SQLException;
	
	public void add(Coordinates<Double> coordinates) throws SQLException;

	public IStreetObserver sighting(PlainSighting sighting) throws Exception;

	public IStreetObserver getStreetObserver(Coordinates<Double> coordinate) 
			throws IllegalArgumentException;
	
	public IInfoStreetObserver getDataGathered(IStreetObserver streetObserver) throws Exception;

}
