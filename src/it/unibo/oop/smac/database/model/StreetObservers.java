package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.SightingDB;
import it.unibo.oop.smac.database.StreetObserverDB;
import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.IStreetObservers;
import it.unibo.oop.smac.model.Model;
import it.unibo.oop.smac.model.exception.NotFound;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

/**
 * 
 * Questa classe è realizzata utilizzando il pattern Singleton.
 *
 */

public class StreetObservers implements IStreetObservers {

	private static StreetObservers instance;

	/**
	 * Costruttore privato della classe.
	 */
	protected StreetObservers() {
	}

	/**
	 * Metodo getInstance per realizzare pattern Singleton
	 * 
	 * @return Un istanza della classe {@link Model}
	 */
	public static synchronized StreetObservers getInstance() {
		if (instance == null) {
			instance = new StreetObservers();
		}
		return instance;
	}

	/**
	 * Inserisce nel database un nuovo {@link IStreetObserver}.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} da inserire.
	 */
	@Override
	public void addNewStreetObserver(IStreetObserver streetObserver) {
		// TODO sarebbe meglio aggiungere anche alla classe streetObserverDB la
		// genericità
		StreetObserverDB streetObserverDB = new StreetObserverDB(
				(IStreetObserver) streetObserver);
		Dao<StreetObserverDB, String> streetObserverDao = this
				.getStreetObserverDao();
		try {
			streetObserverDao.createIfNotExists(streetObserverDB);
			System.out.println("Reading datas just added: "
					+ streetObserverDao.queryForId(streetObserver.getID()));
		} catch (SQLException e) {
			System.err
					.println("The creation on database of the new SteetObserver "
							+ streetObserver + " is failed!");
		}
	}

	/**
	 * Inserisce nel database un nuovo {@link ISighting}.
	 * 
	 * @param sighting
	 *            L'{@link ISighting} da inserire.
	 * @throws NotFound
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addSighting(ISighting sighting) throws IllegalArgumentException {
		addNewStreetObserver(sighting.getStreetObserver());
		StreetObserverDB streetObserverDB = null;
		try {
			streetObserverDB = getStreetObserverDB(sighting.getStreetObserver());
		} catch (NotFound e) {
			new Exception("Non può succedere");
		}
		SightingDB sightingDB = new SightingDB(sighting, streetObserverDB);
		streetObserverDB.addSightings(sightingDB);
	}

	/**
	 * Questo metodo raccoglie i dati su di un {@link IStreetObserver}, e li
	 * organizza restituendo al chiamante un {@link IInfoStreetObserver}
	 * contenente i dati sull'osservstore richiesto.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} di cui si vogliono conoscere le
	 *            informazioni.
	 * @return Un oggetto del tipo {@link IInfoStreetObserver} contenente le
	 *         informazioni sull'{@link IStreetObserver} richiesto.
	 * @throws NotFound
	 * @throws IllegalArgumentException
	 */
	@Override
	public IInfoStreetObserver getStreetObserverInfo(
			IStreetObserver streetObserver) throws IllegalArgumentException,
			NotFound {

		// TODO raccogli ed elabora tutti i dati!!
		StreetObserverDB streetObserverDB = getStreetObserverDB(streetObserver);
		List<SightingDB> sightingList = streetObserverDB.getSightingsList();

		return new InfoStreetObserver.Builder()
				.streetObserver(streetObserverDB)
				.totalNOfSight(sightingList.size()).build();
	}

	/**
	 * Questo metodo raccoglie i dati su di un {@link IStolenCar}, e li
	 * organizza restituendo al chiamante un {@link IInfoStolenCar} contenente i
	 * dati sull'osservstore richiesto.
	 * 
	 * @param stolenCar
	 *            L'{@link IStolenCar} di cui si vogliono conoscere le
	 *            informazioni.
	 * @return Un oggetto del tipo {@link IInfoStolenCar} contenente le
	 *         informazioni sull'{@link IStolenCar} richiesto.
	 */
	@Override
	public IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar) {
		// TODO
		return null;
	}

	/**
	 * Restituisce lo {@link StreetObserverDB} corrispondente all'
	 * {@link IStreetObserver} passato come argomento.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} da cercare.
	 * @return Un oggetto {@link StreetObserverDB} corrispondente all'
	 *         {@link IStreetObserver} passato.
	 * 
	 * @throws IllegalArgumentException
	 *             Quando l'{@link IStreetObserver} passato non viene trovato
	 *             nel database.
	 * @throws NotFound
	 */
	private StreetObserverDB getStreetObserverDB(
			IStreetObserver streetObserver) throws IllegalArgumentException,
			NotFound {
		Dao<StreetObserverDB, String> streetObserverDao = this
				.getStreetObserverDao();
		StreetObserverDB streetObserverDB = null;
		try {
			streetObserverDB = streetObserverDao.queryForId(streetObserver
					.getID());
			if (streetObserverDB == null)
				throw new NotFound();
		} catch (SQLException e) {
			throw new IllegalArgumentException(
					"Problems occured in the database");
		}
		return streetObserverDB;
	}

	/**
	 * Restituisce il Dao<> degli streetObserver della classe Connection
	 * 
	 * @return il Dao<> richiesto.
	 */
	private Dao<StreetObserverDB, String> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

}
