package it.unibo.oop.smartercities.data;

import it.unibo.oop.smartercities.data.I.IStreetObservers;
import it.unibo.oop.smartercities.database.Connection;
import it.unibo.oop.smartercities.database.StreetObserverRow;
import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.InfoSighting;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;

import java.util.Date;
import java.util.List;

import com.j256.ormlite.dao.Dao;

public class StreetObservers implements IStreetObservers {

	@Override
	public StreetObserver add(Coordinates coordinate) throws Exception {
		StreetObserverRow streetObserver = new StreetObserverRow(
				coordinate);
		Dao<StreetObserverRow, Integer> streetObserverDao = Connection
				.getInstance().getStreetObserverDao();
		streetObserverDao.create(streetObserver);
		return streetObserver;
	}

	@Override
	public StreetObserver sighting(InfoSighting sighting) {
		
		
		return null;
	}

	@Override
	public List<Sighting> getSighting(StreetObserver streetObserver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sighting> getSighting(StreetObserver streetObserver,
			Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sighting> getMediaVelocita(StreetObserver streetObserver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sighting> getMediaVelocita(StreetObserver streetObserver,
			Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

}
