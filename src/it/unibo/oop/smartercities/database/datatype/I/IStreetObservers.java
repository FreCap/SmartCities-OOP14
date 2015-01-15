package it.unibo.oop.smartercities.database.datatype.I;

import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Date;
import java.util.List;

public interface IStreetObservers {
	public StreetObserver add(IStreetObserver streetObserver) throws Exception;

	public StreetObserver sighting(PlainSighting sighting);

	public List<Sighting> getSighting(IStreetObserver streetObserver);

	public List<Sighting> getSighting(IStreetObserver streetObserver,
			Date from, Date to);

	public List<Sighting> getMediaVelocita(IStreetObserver streetObserver);
	
	public List<Sighting> getMediaVelocita(IStreetObserver streetObserver,
			Date from, Date to);

}
