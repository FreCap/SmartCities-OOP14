package it.unibo.oop.smartercities.database.data;

import it.unibo.oop.smartercities.database.Connection;
import it.unibo.oop.smartercities.database.SightingRow;
import it.unibo.oop.smartercities.database.StreetObserverRow;
import it.unibo.oop.smartercities.database.data.I.IStreetObservers;
import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver.Builder;
import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;

import java.util.Date;

import com.j256.ormlite.dao.Dao;

// classe di utilità, che richiede i dati al DB, li elabora e attraverso il metodo getDataGathered()
// torna una InfoStreetObserver
public class StreetObservers implements IStreetObservers {

	private static StreetObservers instance;

	private StreetObservers() {

	};

	public static synchronized StreetObservers getInstance() {
		if (instance != null)
			return instance;
		instance = new StreetObservers();
		return instance;
	}

	private Dao<StreetObserverRow, Coordinates<Double>> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

	private Dao<SightingRow, Integer> getSightingDao() {
		return Connection.getInstance().getSightingDao();
	}

	public StreetObserverRow getStreetObserver(Coordinates<Double> coordinate) throws Exception {
		Dao<StreetObserverRow, Coordinates<Double>> streetObserverDao = getStreetObserverDao();
		StreetObserverRow row = streetObserverDao.queryForId(coordinate);
		if (row == null) {
			throw new Exception();//TODO not found
		}
		return row;

	}

	// raccoglie dati di uno streetObserver, e restituisce un pacchetto
	// InfoStreetObserver
	public IInfoStreetObserver getDataGathered(StreetObserver streetObserver)
			throws Exception {

		StreetObserverRow streetObserverRow = getStreetObserver(streetObserver.getCoordinates());

		Date now = new Date();
		Date hourAgo = new Date(now.getTime() - (1000 * 3600));
		Date today = new Date(now.getTime() - (1000 * 3600 * 24));
		Date weekAgo = new Date(now.getTime() - (1000 * 3600 * 24 * 7));
		Date monthAgo = new Date(now.getTime() - (1000 * 3600 * 24 * 30));

		Builder builder = new InfoStreetObserver.Builder();

		builder.averageSpeedToday(streetObserverRow.getMediaVelocita(new Date(), today));
		builder.averageSpeedLastWeek(streetObserverRow.getMediaVelocita(new Date(), weekAgo));
		builder.averageSpeedLastMonth(streetObserverRow.getMediaVelocita(new Date(), monthAgo));
		builder.nOfSightLastHour(streetObserverRow.getSightings(new Date(),hourAgo).size());
		builder.nOfSightToday(streetObserverRow.getSightings(new Date(), today).size());
		builder.nOfSightLastWeek(streetObserverRow.getSightings(new Date(),weekAgo).size());
		builder.nOfSightLaatMonth(streetObserverRow.getSightings(new Date(),monthAgo).size());
		builder.totalNOfSight(streetObserverRow.getSightings().size());

		return builder.build();

	}

	@Override
	public StreetObserver add(Coordinates<Double> coordinate) throws Exception {
		StreetObserverRow streetObserver = new StreetObserverRow(coordinate);
		Dao<StreetObserverRow, Coordinates<Double>> streetObserverDao = getStreetObserverDao();
		streetObserverDao.create(streetObserver);
		return streetObserver;
	}

	@Override
	public StreetObserver sighting(PlainSighting sighting) throws Exception {
		StreetObserverRow streetObserver = getStreetObserver(sighting.getCoordinates());
		if (streetObserver == null) {
			// TODO better throw
			throw new Exception();
		}
		SightingRow row = new SightingRow(sighting, streetObserver);
		Dao<SightingRow, Integer> sightingDao = getSightingDao();
		sightingDao.create(row);
		return null;
	}

}
