package it.unibo.oop.smartercities.database.data;

import it.unibo.oop.smartercities.database.Connection;
import it.unibo.oop.smartercities.database.StreetObserverRow;
import it.unibo.oop.smartercities.database.data.I.IStreetObservers;
import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.PlainSighting;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Date;
import java.util.List;

import com.j256.ormlite.dao.Dao;

// classe di utilità, che richiede i dati al DB, li elabora e attraverso il metodo getDataGathered()
// torna una InfoStreetObserver
public class StreetObservers implements IStreetObservers {

	private Dao<StreetObserverRow, Integer> getStreetObserverDao() {
		return Connection.getInstance().getStreetObserverDao();
	}

	private StreetObserver getStreetObserver(Coordinates<Double> coordinate) {
		Dao<StreetObserverRow, Integer> streetObserverDao = getStreetObserverDao();
//		StreetObserverRow delivery2 = streetObserverDao.queryForId(arg0);

		return null;

	}
	
	// raccoglie dati di uno streetObserver, e restituisce un pacchetto InfoStreetObserver
	public IInfoStreetObserver getDataGathered(StreetObserver streetObserver){
		//TODO
		IInfoStreetObserver iso = new InfoStreetObserver.Builder().build();
		
		return iso;
		
	}

	@Override
	public StreetObserver add(IStreetObserver iso) throws Exception {
		StreetObserverRow streetObserver = new StreetObserverRow(iso);
		Dao<StreetObserverRow, Integer> streetObserverDao = getStreetObserverDao();
		streetObserverDao.create(streetObserver);
		return streetObserver;
	}

	@Override
	public StreetObserver sighting(PlainSighting sighting) {

		return null;
	}

	@Override
	public List<Sighting> getSighting(IStreetObserver streetObserver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sighting> getSighting(IStreetObserver streetObserver, Date from,
			Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sighting> getMediaVelocita(IStreetObserver streetObserver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sighting> getMediaVelocita(IStreetObserver streetObserver,
			Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

}
