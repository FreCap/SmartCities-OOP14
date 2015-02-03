package it.unibo.oop.smac.datatype.I;

/**
 * Interfaccia che gestisce un oggetto contenente delle informazioni relative ad un 
 * singolo osservatore, che possono essere ricavate dai dati presenti nel Model 
 * dell'applicazione.
 * Tutte le informazioni vengono restituite sotto forma di stringa.
 * 
 * @author Federico Bellini
 */
public interface IInfoStreetObserver {

	/**
	 * Restituisce la posizione nello spazio dell'osservatore.
	 * 
	 * @return
	 * 			La posizione nello spazio dell'osservatore.
	 */
	String getStreetObserverLocation();
	
	/**
	 * Restituisce l'ID dell'osservatore.
	 * 
	 * @return
	 * 			L'ID dell'osservatore.
	 */
	String getStreetObserverID();
	
	/**
	 * Rewstituisce il numero di avvistamenti fatti dall'osservatore nell'ultima ora.
	 * 
	 * @return
	 * 			Il numero di avvistamenti fatti dall'osservatore nell'ultima ora.
	 */
	String getnOfSightLastHour();
	
	/**
	 * Rewstituisce il numero di avvistamenti fatti dall'osservatore oggi (dalle 00:00 AM
	 * all'ora corrente).
	 * 
	 * @return
	 * 			Il numero di avvistamenti fatti dall'osservatore oggi.
	 */
	String getnOfSightToday();

	/**
	 * Rewstituisce il numero di avvistamenti fatti dall'osservatore nell'ultima settimana.
	 * 
	 * @return
	 * 			Il numero di avvistamenti fatti dall'osservatore nell'ultima settimana.
	 */
	String getnOfSightLastWeek();

	/**
	 * Rewstituisce il numero di avvistamenti fatti dall'osservatore nell'ultimo mese.
	 * 
	 * @return
	 * 			Il numero di avvistamenti fatti dall'osservatore nell'ultimo mese.
	 */
	String getnOfSightLastMonth();

	/**
	 * Rewstituisce il numero totale di avvistamenti fatti dall'osservatore da quando e'
	 * stato avviato.
	 * 
	 * @return
	 * 			Il numero totale di avvistamenti fatti dall'osservatore da quando e'
	 * 			stato avviato.
	 */
	String getTotalNOfSight();

	/**
	 * Restituisce la velocita' media registrata nella giornata (dalle 00:00 AM all'ora
	 * corrente).
	 * 
	 * @return
	 * 			La velocita' media registrata nella giornata.
	 */
	String getAverageSpeedToday();

	/**
	 * Restituisce la velocita' media registrata nell'ultima settimana.
	 * 
	 * @return
	 * 			La velocita' media registrata nell'ultima settimana.
	 */
	String getAverageSpeedLastWeek();
	
	/**
	 * Restituisce la velocita' media registrata nell'ultimo mese.
	 * 
	 * @return
	 * 			La velocita' media registrata nell'ultimo mese.
	 */
	String getAverageSpeedLastMonth();

	/**
	 * Restituisce la velocita' massima registrata nella giornata (dalle 00:00 AM all'ora
	 * corrente).
	 * 
	 * @return
	 * 			La velocita' massima registrata nella giornata.
	 */
	String getMaxSpeedToday();
	
	/**
	 * Restituisce l'ora della giornata in cui si è registrato il numero massimo di
	 * passaggi di mezzi (dalle 00:00 AM all'ora corrente).
	 * 
	 * @return
	 * 			L'ora della giornata in cui si è registrato il numero massimo di
	 * 			passaggi di mezzi.
	 */
	String getMaxCarRateToday();

}
