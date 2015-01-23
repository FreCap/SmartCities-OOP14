package it.unibo.oop.smac.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.SightingDB;
import it.unibo.oop.smac.database.StreetObserverDB;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

/**
 * Implementazione del Model dell'applicazione. Questa classe riceve le richieste di lettura
 * e scrittura di informazioni su degli oggetti.
 * Questa classe è realizzata utilizzando il pattern Singleton.
 * 
 * @author Federico Bellini
 *
 */
public class Model implements IModel {

	private static Model instance;

	/**
	 * Costruttore privato della classe.
	 */
	private Model() {
	}

	/**
	 * Metodo getInstance per realizzare pattern Singleton
	 * 
	 * @return
	 * 			Un istanza della classe {@link Model}
	 */
	public static synchronized Model getInstance() {
		if(instance == null){
			instance = new Model();
		}
		return instance;
	}
	
	/**
	 * Inserisce nel database un nuovo {@link IStreetObserver}.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} da inserire.
	 */
	@Override
	public void addNewStreetObserver(IStreetObserver streetObserver) {
		StreetObserverDB streetObserverRow = new StreetObserverDB(streetObserver);
		Dao<StreetObserverDB, String> streetObserverDao = this.getStreetObserverDao();
		try {
			streetObserverDao.createIfNotExists(streetObserverRow);
			System.out.println("Reading datas just added: " + 
					streetObserverDao.queryForId(streetObserver.getID()));
		} catch(SQLException e) {
			System.err.println("The creation on database of the new SteetObserver " + 
							   streetObserver + " is failed!");
		}
	}

	/**
	 * Inserisce nel database un nuovo {@link ISighting}.
	 * 
	 * @param sighting
	 * 			L'{@link ISighting} da inserire.
	 */
	@Override
	public void addSighting(ISighting sighting) {
		StreetObserverDB streetObserverRow = getStreetObserverDB(sighting.getStreetObserver());
		SightingDB sightingRow = new SightingDB(sighting, streetObserverRow);
		
		streetObserverRow.addSightings(sightingRow);
	}

	/**
	 * Questo metodo raccoglie i dati su di un {@link IStreetObserver}, e li organizza
	 * restituendo al chiamante un {@link IInfoStreetObserver} contenente i dati
	 * sull'osservstore richiesto.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} di cui si vogliono conoscere le informazioni.
	 * @return
	 * 			Un oggetto del tipo {@link IInfoStreetObserver} contenente le informazioni
	 * 			sull'{@link IStreetObserver} richiesto.
	 */
	@Override
	public IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver) {

		StreetObserverDB streetObserverRow = this.getStreetObserverDB(streetObserver);
		List<SightingDB> sightingList = streetObserverRow.getSightings();
		
		return new InfoStreetObserver.Builder()
						.streetObserver(streetObserverRow)
						.totalNOfSight(sightingList.size()).build();
	}
	
	/**
	 * Questo metodo raccoglie i dati su di un {@link IStolenCar}, e li organizza
	 * restituendo al chiamante un {@link IInfoStolenCar} contenente i dati
	 * sull'osservstore richiesto.
	 * 
	 * @param stolenCar
	 * 			L'{@link IStolenCar} di cui si vogliono conoscere le informazioni.
	 * @return
	 * 			Un oggetto del tipo {@link IInfoStolenCar} contenente le informazioni
	 * 			sull'{@link IStolenCar} richiesto.
	 */
	@Override
	public IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar) {
		// TODO
		return null;
	}
	
	/**
	 * Restituisce lo {@link StreetObserverDB} corrispondente all'{@link IStreetObserver}
	 * passato come argomento.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} da cercare.
	 * @return
	 * 			Un oggetto {@link StreetObserverDB} corrispondente all'
	 * 			{@link IStreetObserver} passato.
	 * 
	 * @throws IllegalArgumentException
	 * 			Quando l'{@link IStreetObserver} passato non viene trovato nel database.
	 */
	private StreetObserverDB getStreetObserverDB(IStreetObserver streetObserver) 
			throws IllegalArgumentException {
		Dao<StreetObserverDB, String> streetObserverDao = this.getStreetObserverDao();
		StreetObserverDB row = null;
		try {
			row = streetObserverDao.queryForId(streetObserver.getID());
		} catch (SQLException e) {
			throw new IllegalArgumentException("Problems occured in the database");
		}
		return row;
	}
	
	/**
	 * Restituisce il Dao<> degli streetObserver della classe Connection
	 * @return
	 * 			il Dao<> richiesto.
	 */
	private Dao<StreetObserverDB, String> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

}
