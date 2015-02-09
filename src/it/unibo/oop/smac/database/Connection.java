package it.unibo.oop.smac.database;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Classe che permette la connessione al database, e la creazione delle tabelle
 */
public final class Connection {

	/**
	 * Indirizzo del database
	 */
	private final static String DATABASE_URL = "jdbc:h2:mem:account";

	/**
	 * Attributo che contiene l'istanza del singleton
	 */
	private static Connection instance;

	// tabelle gestite
	private Dao<SightingRow, Integer> sightingDao;
	private Dao<StolenCarRow, Integer> stolenCarDao;
	private Dao<StreetObserverRow, String> streetObserverDao;

	/**
	 * Costruttore che inizializza la connessione
	 * 
	 * @throws SQLException
	 */
	private Connection() throws SQLException {
		final JdbcConnectionSource connectionSource = new JdbcConnectionSource(
				DATABASE_URL);
		setupDatabase(connectionSource);
		System.out.println("Connection succeed");
	}

	/**
	 * Implementazione del pattern Singleton
	 * 
	 * @return istanza della connessione
	 * @throws SQLException
	 */
	public synchronized static Connection getInstance() throws SQLException {
		if (instance != null) {
			return instance;
		}
		instance = new Connection();
		return instance;
	}

	/**
	 * Creazione delle tabelle
	 * 
	 * @param connectionSource
	 * @throws SQLException
	 */
	private void setupDatabase(final ConnectionSource connectionSource)
			throws SQLException {

		this.sightingDao = DaoManager.createDao(connectionSource, SightingRow.class);
		this.stolenCarDao = DaoManager.createDao(connectionSource, StolenCarRow.class);
		this.streetObserverDao = DaoManager.createDao(connectionSource,
				StreetObserverRow.class);

		TableUtils.createTable(connectionSource, SightingRow.class);
		TableUtils.createTable(connectionSource, StolenCarRow.class);
		TableUtils.createTable(connectionSource, StreetObserverRow.class);
	}

	/**
	 * Restituisce un'istanza della tabella dei sighting
	 * 
	 * @return tabella dei sighting
	 */
	public Dao<SightingRow, Integer> getSightingDao() {
		return sightingDao;
	}

	/**
	 * Restituisce un'istanza della tabella delle stolen car
	 * 
	 * @return tabella delle stolen car
	 */
	public Dao<StolenCarRow, Integer> getStolenCarDao() {
		return stolenCarDao;
	}

	/**
	 * Restituisce un'istanza della tabella degli street observer
	 * 
	 * @return tabella degli street observer
	 */
	public Dao<StreetObserverRow, String> getStreetObserverDao() {
		return streetObserverDao;
	}

}
