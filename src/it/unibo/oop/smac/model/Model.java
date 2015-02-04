package it.unibo.oop.smac.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.unibo.oop.smac.database.SightingRow;
import it.unibo.oop.smac.database.StreetObserverRow;
import it.unibo.oop.smac.database.model.NotFoundException;
import it.unibo.oop.smac.database.model.StreetObserverModelDatabase;
import it.unibo.oop.smac.datatype.InfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Implementazione del Model dell'applicazione. Questa classe riceve le richieste di lettura
 * e scrittura di informazioni sugli osservatori.
 * Questa classe e' implementata secondo il pattern Singleton.
 * 
 * @author Federico Bellini
 */
public class Model extends StreetObserverModelDatabase implements IStreetObserverModel {
	
	private static Model instance = null;
	
	/**
	 * Costruttore privato della classe.
	 */
	private Model() {
		super();
	}
	
	/**
	 * Metodo getInstance(secondo il pattern Singleton).
	 * 
	 * @return
	 * 			Un istanza di questa classe.
	 */
	public static synchronized Model getInstance() {
		if(instance == null){
			instance = new Model();
		}
		return instance;
	}

	/**
	 * Questo metodo raccoglie i dati su di un {@link IStreetObserver}, e li
	 * organizza restituendo al chiamante un {@link IInfoStreetObserver} contenente
	 * le informazioni sull'osservstore richiesto.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} di cui si vogliono recuperare le informazioni.
	 * @return 
	 * 			Un oggetto del tipo {@link IInfoStreetObserver} contenente le informazioni 
	 * 			sull'{@link IStreetObserver} richiesto.
	 * 
	 * @throws NotFoundException
	 * 			Eccezione lanciata nel caso in cui l'{@link IStreetObserver} di cui si vogliono
	 * 			recuperare le informazioni non fosse presente nel Model dell'applicazione.
	 */
	@Override
	public IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver) 
			throws NotFoundException {
		StreetObserverRow streetObserverRow = super.getStreetObserverRow(streetObserver);
		List<SightingRow> sightingRowList = streetObserverRow.getSightingsList();
		
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
		
		// ricerca ed elaborazione dei dati
		for(SightingRow s : sightingRowList){
			Date date = s.getDate();
			if(date.after(lastMonth.getTime())){
				sightLastMonth ++;
				totalSpeedLastMonth += s.getSpeed();
				if(date.after(lastWeek.getTime())){
					sightLastWeek++;
					totalSpeedLastWeek += s.getSpeed();
					if(date.after(today.getTime())){
						sightToday++;
						totalSpeedToday += s.getSpeed();
						if(s.getSpeed() > maxSpeedToday){
							maxSpeedToday = s.getSpeed();
						}
						if(date.after(lastHour.getTime())){
							sightLastHour++;
						}
					}
				}
			}
		}
		
		// costruzione dell'oggetto InfoStreetObserver contenente tutte le informazioni ricavate
		return new InfoStreetObserver.Builder()
				.streetObserver(streetObserverRow)
				.totalNOfSight(sightingRowList.size())
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
	
}
