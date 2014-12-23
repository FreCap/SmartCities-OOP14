package it.unibo.oop.smartercities.database;

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
	private Dao<StreetObserverRow, Integer> streetObserverDao;
	private JdbcConnectionSource connectionSource = null;

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

	public static Connection getInstance() {
		if (instance != null)
			return instance;
		instance = new Connection();
		return instance;
	}

	/**
	 * creazione delle tabelle
	 * @param connectionSource
	 * @throws Exception
	 */
	private void setupDatabase(ConnectionSource connectionSource)
			throws Exception {

		sightingDao = DaoManager.createDao(connectionSource, SightingRow.class);
		stolenCarDao = DaoManager.createDao(connectionSource, StolenCarRow.class);
		streetObserverDao = DaoManager.createDao(connectionSource,
				StreetObserverRow.class);

		TableUtils.createTable(connectionSource, SightingRow.class);
		TableUtils.createTable(connectionSource, StolenCarRow.class);
		TableUtils.createTable(connectionSource, StreetObserverRow.class);
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

	public Dao<SightingRow, Integer> getSightingDao() {
		return sightingDao;
	}

	public Dao<StolenCarRow, Integer> getStolenCarDao() {
		return stolenCarDao;
	}


	public Dao<StreetObserverRow, Integer> getStreetObserverDao() {
		return streetObserverDao;
	}

}
