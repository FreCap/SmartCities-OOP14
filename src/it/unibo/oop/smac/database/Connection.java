package it.unibo.oop.smac.database;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Connection {

	private static Connection instance;
	private Dao<SightingDB, Integer> sightingDao;
	private Dao<StolenCarDB, Integer> stolenCarDao;
	private Dao<StreetObserverDB, String> streetObserverDao;
	private JdbcConnectionSource connectionSource;

	private final static String DATABASE_URL = "jdbc:h2:mem:account";

	private Connection() {
		try {
			connectionSource = new JdbcConnectionSource(DATABASE_URL);
			setupDatabase(connectionSource);
			System.out.println("Connection succeed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized Connection getInstance() {
		if (instance != null)
			return instance;
		instance = new Connection();
		return instance;
	}

	/**
	 * creazione delle tabelle
	 * 
	 * @param connectionSource
	 * @throws Exception
	 */
	private void setupDatabase(ConnectionSource connectionSource) throws Exception {

		this.sightingDao = DaoManager.createDao(connectionSource, SightingDB.class);
		this.stolenCarDao = DaoManager.createDao(connectionSource, StolenCarDB.class);
		this.streetObserverDao = DaoManager.createDao(connectionSource, StreetObserverDB.class);

		TableUtils.createTable(connectionSource, SightingDB.class);
		TableUtils.createTable(connectionSource, StolenCarDB.class);
		TableUtils.createTable(connectionSource, StreetObserverDB.class);
	}

	/**
	 * chiusura connessione
	 */
	private void close() {
		if (connectionSource != null) {
			try {
				connectionSource.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Dao<SightingDB, Integer> getSightingDao() {
		return sightingDao;
	}

	public Dao<StolenCarDB, Integer> getStolenCarDao() {
		return stolenCarDao;
	}

	public Dao<StreetObserverDB, String> getStreetObserverDao() {
		return streetObserverDao;
	}

}
