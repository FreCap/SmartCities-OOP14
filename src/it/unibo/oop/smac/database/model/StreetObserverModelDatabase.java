package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.SightingRow;
import it.unibo.oop.smac.database.StreetObserverRow;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.IStreetObserverModel;
import it.unibo.oop.smac.model.Model;
import it.unibo.oop.smac.model.exception.DuplicateFoundException;
import it.unibo.oop.smac.model.exception.NotFoundException;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.j256.ormlite.dao.Dao;

/**
 * TODO
 * Questa classe è realizzata utilizzando il pattern Singleton.
 *
 */

public class StreetObserverModelDatabase implements IStreetObserverModel {

	private static StreetObserverModelDatabase instance;

	/**
	 * Costruttore della classe.
	 */
	protected StreetObserverModelDatabase() {
	}

	/**
	 * Metodo getInstance per realizzare pattern Singleton
	 * 
	 * @return Un istanza della classe {@link Model}
	 */
	public static synchronized StreetObserverModelDatabase getInstance() {
		if (instance == null) {
			instance = new StreetObserverModelDatabase();
		}
		return instance;
	}

	/**
	 * Inserisce nel database un nuovo {@link IStreetObserver}.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} da inserire.
	 * @throws DuplicateFoundException
	 * 			//TODO
	 */
	@Override
	public synchronized void  addNewStreetObserver(IStreetObserver streetObserver) throws DuplicateFoundException {
		// TODO sarebbe meglio aggiungere anche alla classe streetObserverDB la
		// genericità
		StreetObserverRow streetObserverDB = new StreetObserverRow(
				(IStreetObserver) streetObserver);
		Dao<StreetObserverRow, String> streetObserverDao = this
				.getStreetObserverDao();
		try {
			try {
				if(getStreetObserverDB(streetObserverDB)!= null){
					throw new DuplicateFoundException();
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotFoundException e) {
				streetObserverDao.createIfNotExists(streetObserverDB);
				System.out.println("Reading datas just added: "
						+ streetObserverDao.queryForId(streetObserver.getID()));
			}
			
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
	 * @throws IllegalArgumentException
	 * 			//TODO
	 */
	@Override
	public void addSighting(ISighting sighting) throws IllegalArgumentException {
		try {
			addNewStreetObserver(sighting.getStreetObserver());
		} catch (DuplicateFoundException e1) {
			//del tutto normale
		}
		StreetObserverRow streetObserverDB = null;
		try {
			streetObserverDB = getStreetObserverDB(sighting.getStreetObserver());
		} catch (NotFoundException e) {
			new Exception("Non può succedere");
		}
		SightingRow sightingDB = new SightingRow(sighting, streetObserverDB);
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
	 * @throws NotFoundException
	 * 			//TODO
	 * @throws IllegalArgumentException
	 * 			//TODO
	 */
	@Override
	public IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver)
			throws IllegalArgumentException, NotFoundException {
		
		StreetObserverRow streetObserverDB = getStreetObserverDB(streetObserver);
		List<SightingRow> sightingList = streetObserverDB.getSightingsList();
		
		Calendar lastHour = Calendar.getInstance();
		lastHour.add(Calendar.HOUR, -1);
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.AM_PM, Calendar.AM);
		Calendar lastWeek = Calendar.getInstance();
		lastWeek.add(Calendar.DATE, -7);
		Calendar lastMonth = Calendar.getInstance();
		lastMonth.add(Calendar.MONTH, -1);
		
		int sightLastHour = 0;
		int sightToday = 0;
		int sightLastWeek = 0;
		int sightLastMonth = 0;
		float totalSpeedToday = 0;
		float totalSpeedLastWeek = 0;
		float totalSpeedLastMonth = 0;
		float maxSpeedToday = 0;
		
		for(SightingRow s : sightingList){
			if(s.getDate().after(lastMonth.getTime())){
				sightLastMonth ++;
				totalSpeedLastMonth += s.getSpeed();
				if(s.getDate().after(lastWeek.getTime())){
					sightLastWeek++;
					totalSpeedLastWeek += s.getSpeed();
					if(s.getDate().after(today.getTime())){
						sightToday++;
						totalSpeedToday += s.getSpeed();
						if(s.getSpeed() > maxSpeedToday){
							maxSpeedToday = s.getSpeed();
						}
						if(s.getDate().after(lastHour.getTime())){
							sightLastHour++;
						}
					}
				}
			}
		}

		return new InfoStreetObserver.Builder()
				.streetObserver(streetObserverDB)
				.totalNOfSight(sightingList.size())
				.nOfSightLastHour(sightLastHour)
				.nOfSightToday(sightToday)
				.nOfSightLastWeek(sightLastWeek)
				.nOfSightLastMonth(sightLastMonth)
				.averageSpeedToday(totalSpeedToday/sightToday)
				.averageSpeedLastWeek(totalSpeedLastWeek/sightLastWeek)
				.averageSpeedLastMonth(totalSpeedLastMonth/sightLastMonth)
				.maxSpeedToday(maxSpeedToday)
				.build();
	}

	

	/**
	 * Restituisce lo {@link StreetObserverRow} corrispondente all'
	 * {@link IStreetObserver} passato come argomento.
	 * 
	 * @param streetObserver
	 *            L'{@link IStreetObserver} da cercare.
	 * @return Un oggetto {@link StreetObserverRow} corrispondente all'
	 *         {@link IStreetObserver} passato.
	 * 
	 * @throws IllegalArgumentException
	 *             Quando l'{@link IStreetObserver} passato non viene trovato
	 *             nel database.
	 * @throws NotFoundException
	 * 			//TODO
	 */
	protected StreetObserverRow getStreetObserverDB(IStreetObserver streetObserver)
			throws IllegalArgumentException, NotFoundException {
		Dao<StreetObserverRow, String> streetObserverDao = this
				.getStreetObserverDao();
		StreetObserverRow streetObserverDB = null;
		try {
			streetObserverDB = streetObserverDao.queryForId(streetObserver
					.getID());
			if (streetObserverDB == null)
				throw new NotFoundException();
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
	private Dao<StreetObserverRow, String> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

}
