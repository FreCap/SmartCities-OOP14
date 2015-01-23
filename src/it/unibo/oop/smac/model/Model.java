package it.unibo.oop.smac.model;

import it.unibo.oop.smac.database.data.DBStreetObserver;
import it.unibo.oop.smac.database.data.I.IDBStreetObservers;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Questa classe implementa il Model dell'applicazione.
 * 
 * @author Federico Bellini
 *
 */
public class Model implements IModel {

	/**
	 * Classe di utility con cui leggere/scrivere delle informazioni dal/sul database
	 */
	private IDBStreetObservers streetObserverDB = DBStreetObserver.getInstance();
	
	public Model() {
		super();
	}
	
	/**
	 * Questo metodo aggiunge un nuovo campo al database contenente tutte le informazioni
	 * relative ad un nuovo {@link IStreetObserver}.
	 * 
	 * @param streetObserver
	 * 			Il nuovo {@link IStreetObserver} da aggiungere al database.
	 */
	@Override
	public void addNewStreetObserver(IStreetObserver streetObserver) {
		try {
			this.streetObserverDB.addStreetObserver(streetObserver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Questo metodo aggiunge le informazioni appena ricevute da un {@link IStreetObserver}
	 * al database.
	 * 
	 * @param sighting
	 * 			Le {@link ISighting} appena ricevute.
	 */
	@Override
	public void newPassage(ISighting sighting) {
		try {
			this.streetObserverDB.addSighting(sighting);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO questo metodo deve far tornare un pacchetto IInfoStreetObserver dello streetObserver richiesto
	@Override
	public IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver) {
		IInfoStreetObserver info;
		try {
			info = streetObserverDB.getDataGathered(streetObserver);
		} catch(Exception e) {
			e.printStackTrace();
			info = new InfoStreetObserver.Builder().build();
		}
		return info;
	}

	// TODO questo metodo deve far tornare un pacchetto IInfoStolenCarr della stolenCar richiesta
	@Override
	public IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar) {
		return null;
	}

}
