package it.unibo.oop.smac.database.data;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.SightingRow;
import it.unibo.oop.smac.database.StreetObserverRow;
import it.unibo.oop.smac.database.data.I.IDBStreetObservers;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

/**
 * Classe di utilità, che richiede i dati al database, li elabora, e attraverso il metodo getDataGathered
 * restituisce le informazioni richieste.
 * Questa classe è realizzata utilizzando il pattern Singleton.
 * 
 * @author Federico Bellini
 *
 */
public class DBStreetObserver implements IDBStreetObservers {

	private static DBStreetObserver instance;

	private DBStreetObserver() {
	}

	public static synchronized IDBStreetObservers getInstance() {
		if(instance == null){
			instance = new DBStreetObserver();
		}
		return instance;
	}
	
	/**
	 * Inserisce nel database un nuovo {@link IStreetObserver}.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} da inserire.
	 * 
	 * @throws SQLException
	 * 			Nel caso in cui l'inserimento non abbia successo.
	 */
	@Override
	public void addStreetObserver(IStreetObserver streetObserver) throws SQLException {
		StreetObserverRow streetObserverRow = new StreetObserverRow(streetObserver);
		Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
		streetObserverDao.createIfNotExists(streetObserverRow);
		System.out.println("Reading of data just added:  " + 
				streetObserverDao.queryForId(streetObserver.getID()));
	}

	/**
	 * Inserisce nel database un nuovo {@link ISighting}.
	 * 
	 * @param sighting
	 * 			L'{@link ISighting} da inserire.
	 * 
	 * @throws IllegalArgumentException
	 * 			Nel caso in cui le informazioni da inserire siano errate(lo StreetObserver che
	 * 			le ha inviate non esiste nel database).
	 * @throws SQLException
	 * 			Nel caso in cui l'inserimento non abbia successo.
	 */
	@Override
	public void addSighting(ISighting sighting) throws IllegalArgumentException, SQLException {
		StreetObserverRow streetObserverRow = getStreetObserverRow(sighting.getStreetObserver());
		SightingRow sightingRow = new SightingRow(sighting, streetObserverRow);
		
		streetObserverRow.addSightings(sightingRow);
	}

	// raccoglie dati di uno streetObserver, e restituisce un pacchetto
	// InfoStreetObserver
	public IInfoStreetObserver getDataGathered(IStreetObserver streetObserver) throws Exception {

		StreetObserverRow streetObserverRow = this.getStreetObserverRow(streetObserver);
		List<SightingRow> sightingList = streetObserverRow.getSightings();
		
		return new InfoStreetObserver.Builder()
						.streetObserver(streetObserverRow)
						.totalNOfSight(sightingList.size()).build();
	}
	
	private StreetObserverRow getStreetObserverRow(IStreetObserver streetObserver) 
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
	
	private Dao<StreetObserverRow, String> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

}
