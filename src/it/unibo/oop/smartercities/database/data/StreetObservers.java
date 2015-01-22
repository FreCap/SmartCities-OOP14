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
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.dao.Dao;

// classe di utilità, che richiede i dati al DB, li elabora e attraverso il metodo getDataGathered()
// torna una InfoStreetObserver
public class StreetObservers implements IStreetObservers {

	private static StreetObservers instance;

	/**
	 * Costruttore privato della classe. Utilizzato pattern Singleton
	 */
	private StreetObservers() {
	}

	public static synchronized IStreetObservers getInstance() {
		if(instance == null){
			instance = new StreetObservers();
		}
		return instance;
	}

	public StreetObserverRow getStreetObserver(Coordinates<Double> coordinate) 
			throws IllegalArgumentException {
		Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
		StreetObserverRow row = null;
		try {
			row = streetObserverDao.queryForId(coordinate.toString());
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
	public void add(IStreetObserver streetObserver) throws SQLException {
		this.add(streetObserver.getCoordinates());
	}
	
	/**
	 * Inserisce nel database un nuovo {@link IStreetObserver} attraverso le sue coordinate.
	 * 
	 * @param coordinates
	 * 			Le {@link Coordinates} dell'{@link IStreetObserver} da inserire.
	 * @throws SQLException
	 * 			Nel caso in cui l'inserimento non abbia successo.
	 */
	@Override
	public void add(Coordinates<Double> coordinates) throws SQLException {
		StreetObserverRow streetObserverRow = new StreetObserverRow(coordinates);
		Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
		streetObserverDao.createIfNotExists(streetObserverRow);
		
		///////////
		System.out.println("Esiste: " + streetObserverDao.idExists(coordinates.toString().substring(0, 5)));
		System.out.println("Il suo valore è: " + streetObserverDao.queryForId(coordinates.toString().substring(0, 5)));
	}

	@Override
	public StreetObserver sighting(PlainSighting sighting) throws Exception {
		StreetObserverRow streetObserver = getStreetObserver(sighting.getCoordinates());
		if (streetObserver == null) {
			// TODO better throw
			throw new Exception();
		}
		SightingRow row = new SightingRow(sighting, streetObserver);
		Dao<SightingRow, Integer> sightingDao = this.getSightingDao();
		sightingDao.create(row);
		return null;
	}

	// raccoglie dati di uno streetObserver, e restituisce un pacchetto
	// InfoStreetObserver
	public IInfoStreetObserver getDataGathered(IStreetObserver streetObserver) throws Exception {

		StreetObserverRow streetObserverRow = this.getStreetObserver(streetObserver.getCoordinates());

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
