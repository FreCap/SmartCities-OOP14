package it.unibo.oop.smartercities.model;

import java.util.Random;

import it.unibo.oop.smartercities.database.data.StreetObservers;
import it.unibo.oop.smartercities.database.data.I.IStreetObservers;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class Model implements IModel {

	/**
	 * Classe di utility con cui ricevere le info su uno StreetObserver dal database
	 */
	private IStreetObservers streetObserverDB = StreetObservers.getInstance();
	
	public Model() {
		super();
	}
	
	// TODO questo metodo deve aggiungere un nuovo streetObserver al DATABASE
	@Override
	public void addNewStreetObserver(IStreetObserver streetObserver) {
		try {
			streetObserverDB.add(streetObserver.getCoordinates());
		} catch (Exception e) {
			// TODO fa qualcosa nel caso in cui non possa essere accettato
			e.printStackTrace();
		}
	}

	// TODO questo metodo deve aggiungere il pacchetto di informazioni "s" al database.
	// s è il pacchetto di info inviato da "streetObserver"
	@Override
	public void newPassage(IStreetObserver streetObserver, ISighting s) {
	}

	// TODO questo metodo deve far tornare un pacchetto IInfoStreetObserver dello streetObserver richiesto
	@Override
	public IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver) {
		
		//////// QUESTO LO FACCIO SOLO PER ESEMPIO! BISOGNERA' POI IMPLEMENTARLO IN MODO CHE 
		//////// I DATI PROVENGANO DAL DB!
		Random r = new Random();
		return new InfoStreetObserver.Builder().streetObserver(streetObserver)
											   .maxCarRateToday(r.nextInt(100))
											   .averageSpeedLastMonth(r.nextInt(100))
											   .averageSpeedLastWeek(r.nextInt(100))
											   .maxSpeedToday(r.nextInt(100))
											   .nOfSightLastWeek(r.nextInt(100))
											   .nOfSightToday(r.nextInt(100))
											   .build();
		
		
		
		
		
	}

	// TODO questo metodo deve far tornare un pacchetto IInfoStolenCarr della stolenCar richiesta
	@Override
	public IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar) {
		return null;
	}

}
