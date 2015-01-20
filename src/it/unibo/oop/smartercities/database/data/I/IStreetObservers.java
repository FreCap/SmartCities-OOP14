package it.unibo.oop.smartercities.database.data.I;

import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IStreetObservers {
	public StreetObserver add(IStreetObserver streetObserver) throws Exception;

	public StreetObserver sighting(PlainSighting sighting) throws Exception;

}
