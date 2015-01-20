package it.unibo.oop.smartercities.database.data.I;

import it.unibo.oop.smartercities.database.StreetObserverRow;
import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IStreetObservers {
	public static IStreetObserver getInstance() {
		return null;
	}
	
	public StreetObserver add(Coordinates<Double> streetObserver) throws Exception;

	public StreetObserver sighting(PlainSighting sighting) throws Exception;

	public StreetObserver getStreetObserver(Coordinates<Double> coordinate) throws Exception;

}
