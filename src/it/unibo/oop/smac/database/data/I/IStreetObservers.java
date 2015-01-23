package it.unibo.oop.smac.database.data.I;

import java.sql.SQLException;

import it.unibo.oop.smac.datatype.PlainSighting;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

public interface IStreetObservers {
	
	public static IStreetObserver getInstance() {return null;}
	
	public void add(IStreetObserver streetObserver) throws SQLException;

	public IStreetObserver sighting(PlainSighting sighting) throws Exception;
	
	public IInfoStreetObserver getDataGathered(IStreetObserver streetObserver) throws Exception;

}
