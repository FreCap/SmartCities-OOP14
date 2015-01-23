package it.unibo.oop.smac.database.data;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.SightingRow;
import it.unibo.oop.smac.database.StreetObserverRow;
import it.unibo.oop.smac.database.data.I.IDBStreetObservers;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.datatype.InfoStreetObserver.Builder;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.dao.Dao;

// classe di utilità, che richiede i dati al DB, li elabora e attraverso il metodo getDataGathered()
// torna una InfoStreetObserver
/**
 * 
 * Classe di utilità,
 * 
 * @author Federico Bellini
 *
 */
public class DBStreetObserver implements IDBStreetObservers {

	private static DBStreetObserver instance;

	/**
	 * Costruttore privato della classe. Utilizzato pattern Singleton
	 */
	private DBStreetObserver() {
	}

	public static synchronized IDBStreetObservers getInstance() {
		if(instance == null){
			instance = new DBStreetObserver();
		}
		return instance;
	}

	public StreetObserverRow getStreetObserver(IStreetObserver streetObserver) 
			throws IllegalArgumentException {
		Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
		StreetObserverRow row = null;
		try {
			row = streetObserverDao.queryForId(streetObserver.getID());
		} catch (SQLException e) {
			throw new IllegalArgumentException("Problems occured in the database");
		}
		return row;
	}
	
	/**
	 * Inserisce nel database un nuovo {@link IStreetObserver}.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} da inserire.
	 * @throws SQLException
	 * 			Nel caso in cui l'inserimento non abbia successo.
	 */
	@Override
	public void addStreetObserver(IStreetObserver streetObserver) throws SQLException {
		StreetObserverRow streetObserverRow = new StreetObserverRow(streetObserver);
		Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
		streetObserverDao.createIfNotExists(streetObserverRow);
		
		System.out.println("Leggo il dato che è appena stato aggiunto: " + streetObserverDao.queryForId(streetObserver.getID()));
	}

	@Override
	public void addSighting(ISighting sighting) throws Exception {/*
		StreetObserverRow streetObserver = getStreetObserver(sighting.getCoordinates());
		if (streetObserver == null) {
			// TODO better throw
			throw new Exception();
		}
		SightingRow row = new SightingRow(sighting, streetObserver);
		Dao<SightingRow, Integer> sightingDao = this.getSightingDao();
		sightingDao.create(row);*/
	}

	// raccoglie dati di uno streetObserver, e restituisce un pacchetto
	// InfoStreetObserver
	public IInfoStreetObserver getDataGathered(IStreetObserver streetObserver) throws Exception {

		StreetObserverRow streetObserverRow = this.getStreetObserver(streetObserver);

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
	
	private Dao<StreetObserverRow, String> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

	private Dao<SightingRow, Integer> getSightingDao() {
		return Connection.getInstance().getSightingDao();
	}

}
