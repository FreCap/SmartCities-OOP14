package it.unibo.oop.smac.database;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Connection {

	private static Connection instance;
	private Dao<SightingRow, Integer> sightingDao;
	private Dao<StolenCarRow, Integer> stolenCarDao;
	private Dao<StreetObserverRow, String> streetObserverDao;
	private JdbcConnectionSource connectionSource;

	private final static String DATABASE_URL = "jdbc:h2:mem:account";

	private Connection() throws SQLException  {
		connectionSource = new JdbcConnectionSource(DATABASE_URL);
		setupDatabase(connectionSource);
		System.out.println("Connection succeed");
	}

	public static synchronized Connection getInstance() throws SQLException {
		if (instance != null)
			return instance;
		instance = new Connection();
		return instance;
	}

	/**
	 * creazione delle tabelle
	 * 
	 * @param connectionSource
	 * @throws SQLException
	 */
	private void setupDatabase(ConnectionSource connectionSource) throws SQLException {

		this.sightingDao = DaoManager.createDao(connectionSource, SightingRow.class);
		this.stolenCarDao = DaoManager.createDao(connectionSource, StolenCarRow.class);
		this.streetObserverDao = DaoManager.createDao(connectionSource, StreetObserverRow.class);

		TableUtils.createTable(connectionSource, SightingRow.class);
		TableUtils.createTable(connectionSource, StolenCarRow.class);
		TableUtils.createTable(connectionSource, StreetObserverRow.class);
	}

	/**
	 * chiusura connessione
	 * @throws SQLException 
	 */
	private void close() throws SQLException {
		if (connectionSource != null) {
			connectionSource.close();
		}
	}

	public Dao<SightingRow, Integer> getSightingDao() {
		return sightingDao;
	}

	public Dao<StolenCarRow, Integer> getStolenCarDao() {
		return stolenCarDao;
	}

	public Dao<StreetObserverRow, String> getStreetObserverDao() {
		return streetObserverDao;
	}

}
