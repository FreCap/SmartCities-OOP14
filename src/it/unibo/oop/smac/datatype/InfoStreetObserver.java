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
	private static final String EMPTY_STRING = "  -  ";
	
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

	//TODO quando hai finito con i campi, aggiungi hash e equals


	// builder for this class
	public static class Builder{
		private IStreetObserver streetObserver;
		private Integer nOfSightLastHour;
		private Integer nOfSightToday;
		private Integer nOfSightLastWeek;
		private Integer nOfSightLaatMonth;
		private Integer totalNOfSight;
		private Float averageSpeedToday;
		private Float averageSpeedLastWeek;
		private Float averageSpeedLastMonth;
		private Float maxSpeedToday;
		private Float maxCarRateToday;
		
		public Builder streetObserver(IStreetObserver streetObserver){
			this.streetObserver = streetObserver;
			return this;
		}
		
		public Builder nOfSightLastHour(int nOfSightLastHour){
			this.nOfSightLastHour = nOfSightLastHour;
			return this;
		}
		
		public Builder nOfSightToday(int nOfSightToday){
			this.nOfSightToday = nOfSightToday;
			return this;
		}
		
		public Builder nOfSightLastWeek(int nOfSightLastWeek){
			this.nOfSightLastWeek = nOfSightLastWeek;
			return this;
		}
		
		public Builder nOfSightLastMonth(int nOfSightLaatMonth){
			this.nOfSightLaatMonth = nOfSightLaatMonth;
			return this;
		}
		
		public Builder totalNOfSight(int totalNOfSight){
			this.totalNOfSight = totalNOfSight;
			return this;
		}
		
		public Builder averageSpeedToday(float averageSpeedToday){
			this.averageSpeedToday = averageSpeedToday;
			return this;
		}
		
		public Builder averageSpeedLastWeek(float averageSpeedLastWeek){
			this.averageSpeedLastWeek = averageSpeedLastWeek;
			return this;
		}
		
		public Builder averageSpeedLastMonth(float averageSpeedLastMonth){
			this.averageSpeedLastMonth = averageSpeedLastMonth;
			return this;
		}
		
		public Builder maxSpeedToday(float maxSpeedToday){
			this.maxSpeedToday = maxSpeedToday;
			return this;
		}
		
		public Builder maxCarRateToday(float maxCarRateToday){
			this.maxCarRateToday = maxCarRateToday;
			return this;
		}
		
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
