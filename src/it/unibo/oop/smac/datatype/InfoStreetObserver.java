package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.util.Optional;

/**
 * Classe che fornisce metodi che restituiscono stringhe contenenti i dati su di uno
 * specifico osservatore. I dati presenti vengono ricavati dalle informazioni contenute
 * del Model dell'applicazione.
 * Se per qualche motivo i dati non potessero essere ricavati dal Model, e quindi questo
 * oggetto non ne fosse a conoscenza, esso restituisce una stringa di tipo EMPTY_STRING.
 * Per l'implementazione della classe e' stato utilizzato il pattern Builder.
 * 
 * @author Federico Bellini
 */
public class InfoStreetObserver implements IInfoStreetObserver{
	
	/**
	 * Stringa che viene restituita quando viene richiesto un campo di cui non si conosce
	 * il valore (il campo è null).
	 */
	protected static String EMPTY_STRING = "  -  ";
	
	/**
	 * Precisione decimale con cui i numeri di tipo Float vengono restituiti.
	 */
	private static final int DECIMAL_PRECISION = 2;
	
	/**
	 * Campi di tipo Optional<> contenenti le informazioni sull'osservatore.
	 */
	private final Optional<IStreetObserver> streetObserver;
	private final Optional<Integer> nOfSightLastHour;
	private final Optional<Integer> nOfSightToday;
	private final Optional<Integer> nOfSightLastWeek;
	private final Optional<Integer> nOfSightLaatMonth;
	private final Optional<Integer> totalNOfSight;
	private final Optional<Float> averageSpeedToday;
	private final Optional<Float> averageSpeedLastWeek;
	private final Optional<Float> averageSpeedLastMonth;
	private final Optional<Float> maxSpeedToday;
	private final Optional<Float> maxCarRateToday;
	
	/**
	 * Costruttore privato della classe che prende tutti i campi presenti in essa.
	 */
	private InfoStreetObserver(IStreetObserver streetObserver,
			Integer nOfSightLastHour,
			Integer nOfSightToday,
			Integer nOfSightLastWeek,
			Integer nOfSightLaatMonth,
			Integer totalNOfSight,
			Float averageSpeedToday,
			Float averageSpeedLastWeek,
			Float averageSpeedLastMonth,
			Float maxSpeedToday, 
			Float maxCarRateToday) {
		
		super();
		this.streetObserver = Optional.ofNullable(streetObserver);
		this.nOfSightLastHour = Optional.ofNullable(nOfSightLastHour);
		this.nOfSightToday = Optional.ofNullable(nOfSightToday);
		this.nOfSightLastWeek = Optional.ofNullable(nOfSightLastWeek);
		this.nOfSightLaatMonth = Optional.ofNullable(nOfSightLaatMonth);
		this.totalNOfSight = Optional.ofNullable(totalNOfSight);
		this.averageSpeedToday = Optional.ofNullable(averageSpeedToday);
		this.averageSpeedLastWeek = Optional.ofNullable(averageSpeedLastWeek);
		this.averageSpeedLastMonth = Optional.ofNullable(averageSpeedLastMonth);
		this.maxSpeedToday = Optional.ofNullable(maxSpeedToday);
		this.maxCarRateToday = Optional.ofNullable(maxCarRateToday);
	}
	
	/**
	 * Metodo di utilita' che restituisce il valore dell'Optional preso come parametro se
	 * e' presente, altrimenti restituisce la stringa EMPTY_STRING.
	 * Nel caso in cui l'Optional fosse presente e la classe dell'oggetto in esso contenuto
	 * fosse Float, restituisce il Numero Float in esso contenuto, ma con un numero
	 * DECIMAL_PRECISION di cifre significative.
	 */
	private String stringOutputUtility(Optional<?> o){
		if(o.isPresent()){
			String out = o.get().toString();
			if(o.get().getClass().equals(Float.class)){
				return out.substring(0, out.indexOf(".") + DECIMAL_PRECISION);
			}
			return out;
		} else{
			return EMPTY_STRING;
		}
	}

	@Override
	public String getnOfSightLastHour() {
		return this.stringOutputUtility(this.nOfSightLastHour);
	}

	@Override
	public String getnOfSightToday() {
		return this.stringOutputUtility(this.nOfSightToday);
	}

	@Override
	public String getnOfSightLastWeek() {
		return this.stringOutputUtility(this.nOfSightLastWeek);
	}

	@Override
	public String getnOfSightLastMonth() {
		return this.stringOutputUtility(this.nOfSightLaatMonth);
	}

	@Override
	public String getTotalNOfSight() {
		return this.stringOutputUtility(this.totalNOfSight);
	}

	@Override
	public String getAverageSpeedToday() {
		return this.stringOutputUtility(this.averageSpeedToday);
	}

	@Override
	public String getAverageSpeedLastWeek() {
		return this.stringOutputUtility(this.averageSpeedLastWeek);
	}

	@Override
	public String getAverageSpeedLastMonth() {
		return this.stringOutputUtility(this.averageSpeedLastMonth);
	}

	@Override
	public String getMaxSpeedToday() {
		return this.stringOutputUtility(this.maxSpeedToday);
	}

	@Override
	public String getMaxCarRateToday() {
		return this.stringOutputUtility(this.maxCarRateToday);
	}
	
	@Override
	public String getStreetObserverLocation() {
		if(this.streetObserver.isPresent()){
			return this.streetObserver.get().getCoordinates().toString();
		}
		else{
			return EMPTY_STRING;
		}
	}
	
	@Override
	public String getStreetObserverID() {
		if(this.streetObserver.isPresent()){
			return String.valueOf(this.streetObserver.get().getID());
		}
		else{
			return EMPTY_STRING;
		}
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append(" streetObserverLocation=" + this.getStreetObserverLocation())
								  .append(" streetObserverID=" + this.getStreetObserverID())
								  .append(" nOfSightLastHour=" + this.getnOfSightLastHour())
								  .append(" nOfSightToday=" + this.getnOfSightToday())
								  .append(" nOfSightLastWeek=" + this.getnOfSightLastWeek())
								  .append(" nOfSightLaatMonth=" + this.getnOfSightLastMonth())
								  .append(" totalNOfSight=" + this.getTotalNOfSight())
								  .append(" averageSpeedToday=" + this.getAverageSpeedToday())
								  .append(" averageSpeedLastWeek=" + this.getAverageSpeedLastWeek())
								  .append(" averageSpeedLastMonth=" + this.getAverageSpeedLastMonth())
								  .append(" maxSpeedToday=" + this.getMaxSpeedToday())
								  .append(" maxCarRateToday=" + this.getMaxCarRateToday())
								  .toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((averageSpeedLastMonth == null) ? 0 : averageSpeedLastMonth
						.hashCode());
		result = prime
				* result
				+ ((averageSpeedLastWeek == null) ? 0 : averageSpeedLastWeek
						.hashCode());
		result = prime
				* result
				+ ((averageSpeedToday == null) ? 0 : averageSpeedToday
						.hashCode());
		result = prime * result
				+ ((maxCarRateToday == null) ? 0 : maxCarRateToday.hashCode());
		result = prime * result
				+ ((maxSpeedToday == null) ? 0 : maxSpeedToday.hashCode());
		result = prime
				* result
				+ ((nOfSightLaatMonth == null) ? 0 : nOfSightLaatMonth
						.hashCode());
		result = prime
				* result
				+ ((nOfSightLastHour == null) ? 0 : nOfSightLastHour.hashCode());
		result = prime
				* result
				+ ((nOfSightLastWeek == null) ? 0 : nOfSightLastWeek.hashCode());
		result = prime * result
				+ ((nOfSightToday == null) ? 0 : nOfSightToday.hashCode());
		result = prime * result
				+ ((streetObserver == null) ? 0 : streetObserver.hashCode());
		result = prime * result
				+ ((totalNOfSight == null) ? 0 : totalNOfSight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoStreetObserver other = (InfoStreetObserver) obj;
		if (averageSpeedLastMonth == null) {
			if (other.averageSpeedLastMonth != null)
				return false;
		} else if (!averageSpeedLastMonth.equals(other.averageSpeedLastMonth))
			return false;
		if (averageSpeedLastWeek == null) {
			if (other.averageSpeedLastWeek != null)
				return false;
		} else if (!averageSpeedLastWeek.equals(other.averageSpeedLastWeek))
			return false;
		if (averageSpeedToday == null) {
			if (other.averageSpeedToday != null)
				return false;
		} else if (!averageSpeedToday.equals(other.averageSpeedToday))
			return false;
		if (maxCarRateToday == null) {
			if (other.maxCarRateToday != null)
				return false;
		} else if (!maxCarRateToday.equals(other.maxCarRateToday))
			return false;
		if (maxSpeedToday == null) {
			if (other.maxSpeedToday != null)
				return false;
		} else if (!maxSpeedToday.equals(other.maxSpeedToday))
			return false;
		if (nOfSightLaatMonth == null) {
			if (other.nOfSightLaatMonth != null)
				return false;
		} else if (!nOfSightLaatMonth.equals(other.nOfSightLaatMonth))
			return false;
		if (nOfSightLastHour == null) {
			if (other.nOfSightLastHour != null)
				return false;
		} else if (!nOfSightLastHour.equals(other.nOfSightLastHour))
			return false;
		if (nOfSightLastWeek == null) {
			if (other.nOfSightLastWeek != null)
				return false;
		} else if (!nOfSightLastWeek.equals(other.nOfSightLastWeek))
			return false;
		if (nOfSightToday == null) {
			if (other.nOfSightToday != null)
				return false;
		} else if (!nOfSightToday.equals(other.nOfSightToday))
			return false;
		if (streetObserver == null) {
			if (other.streetObserver != null)
				return false;
		} else if (!streetObserver.equals(other.streetObserver))
			return false;
		if (totalNOfSight == null) {
			if (other.totalNOfSight != null)
				return false;
		} else if (!totalNOfSight.equals(other.totalNOfSight))
			return false;
		return true;
	}

	/**
	 * Classe statica innestata Builder della classe InfoStreetObserver.
	 * Questa classe svolge il compito di creare un'oggetto della classe InfoStreetObserver.
	 * 
	 * @author Federico Bellini
	 */
	public static class Builder{
		private IStreetObserver streetObserver = null;
		private Integer nOfSightLastHour = null;
		private Integer nOfSightToday = null;
		private Integer nOfSightLastWeek = null;
		private Integer nOfSightLaatMonth = null;
		private Integer totalNOfSight = null;
		private Float averageSpeedToday = null;
		private Float averageSpeedLastWeek = null;
		private Float averageSpeedLastMonth = null;
		private Float maxSpeedToday = null;
		private Float maxCarRateToday = null;
		
		/**
		 * Imposta l'IStreetObserver che ha compiuto l'avvistamento.
		 * 
		 * @param streetObserver
		 * 			L'IStreetObserver che ha compiuto l'avvistamento.
		 */
		public Builder streetObserver(IStreetObserver streetObserver){
			this.streetObserver = streetObserver;
			return this;
		}
		
		/**
		 * Imposta il numero di avvitamenti fatti nell'ultima ora.
		 * 
		 * @param nOfSightLastHour
		 * 			Il numero di avvitamenti fatti nell'ultima ora.
		 */
		public Builder nOfSightLastHour(int nOfSightLastHour){
			this.nOfSightLastHour = nOfSightLastHour;
			return this;
		}
		
		/**
		 * Imposta il numero di avvitamenti fatti oggi.
		 * 
		 * @param nOfSightToday
		 * 			Imposta il numero di avvitamenti fatti oggi.
		 */
		public Builder nOfSightToday(int nOfSightToday){
			this.nOfSightToday = nOfSightToday;
			return this;
		}
		
		/**
		 * Imposta il numero di avvitamenti fatti nell'ultima settimana.
		 * @param nOfSightLastWeek
		 * 			Imposta il numero di avvitamenti fatti nell'ultima settimana.
		 */
		public Builder nOfSightLastWeek(int nOfSightLastWeek){
			this.nOfSightLastWeek = nOfSightLastWeek;
			return this;
		}
		
		/**
		 * Imposta il numero di avvitamenti fatti nell'ultimo mese.
		 * 
		 * @param nOfSightLaatMonth
		 * 			Il numero di avvitamenti fatti nell'ultimo mese.
		 */
		public Builder nOfSightLastMonth(int nOfSightLaatMonth){
			this.nOfSightLaatMonth = nOfSightLaatMonth;
			return this;
		}
		
		/**
		 * Imposta il numero totale di avvistamenti.
		 * 
		 * @param totalNOfSight
		 * 			Il numero totale di avvistamenti
		 */
		public Builder totalNOfSight(int totalNOfSight){
			this.totalNOfSight = totalNOfSight;
			return this;
		}
		
		/**
		 * Imposta la velocita' media registrata oggi.
		 * 
		 * @param averageSpeedToday
		 * 			La velocita' media registrata oggi.
		 */
		public Builder averageSpeedToday(float averageSpeedToday){
			this.averageSpeedToday = averageSpeedToday;
			return this;
		}
		
		/**
		 * Imposta la velocita' media registrata nell'ultima settimana.
		 * 
		 * @param averageSpeedLastWeek
		 * 			La velocita' media registrata nell'ultima settimana.
		 */
		public Builder averageSpeedLastWeek(float averageSpeedLastWeek){
			this.averageSpeedLastWeek = averageSpeedLastWeek;
			return this;
		}
		
		/**
		 * Imposta la velocita' media registrata nell'ultimo mese.
		 * 
		 * @param averageSpeedLastMonth
		 * 			La velocita' media registrata nell'ultimo mese.
		 */
		public Builder averageSpeedLastMonth(float averageSpeedLastMonth){
			this.averageSpeedLastMonth = averageSpeedLastMonth;
			return this;
		}
		
		/**
		 * Imposta la velocita' massima registrata oggi.
		 * 
		 * @param maxSpeedToday
		 * 			La velocita' massima registrata oggi.
		 */
		public Builder maxSpeedToday(float maxSpeedToday){
			this.maxSpeedToday = maxSpeedToday;
			return this;
		}
		
		/**
		 * Imposta la 
		 * @param maxCarRateToday
		 * @return
		 */
		public Builder maxCarRateToday(float maxCarRateToday){
			this.maxCarRateToday = maxCarRateToday;
			return this;
		}
		
		/**
		 * Costruisce l'oggetto della classe InfoStreetObserver con i valori impostati.
		 * 
		 * @return
		 * 			L'oggetto della classe InfoStreetObserver appena costruito.
		 */
		public InfoStreetObserver build(){
			return new InfoStreetObserver(this.streetObserver,
					this.nOfSightLastHour,
					this.nOfSightToday,
					this.nOfSightLastWeek,
					this.nOfSightLaatMonth,
					this.totalNOfSight,
					this.averageSpeedToday,
					this.averageSpeedLastWeek,
					this.averageSpeedLastMonth,
					this.maxSpeedToday,
					this.maxCarRateToday);
		}
		
	}

}
