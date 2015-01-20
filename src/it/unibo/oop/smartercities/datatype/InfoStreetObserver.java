package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Optional;

// UTILIZZATO IL PATTERN BUILDER!!!

// pacchetto di info che il data restituisce alla gui quando la gui richiede di avere
// delle info su di uno street observer dal database
public class InfoStreetObserver implements IInfoStreetObserver{
	
	private static final String EMPTY_STRING = "  -  ";
	
	private final Optional<IStreetObserver> streetObserver;
	private final Optional<Integer> nOfSightLastHour;
	private final Optional<Integer> nOfSightToday;
	private final Optional<Integer> nOfSightLastWeek;
	private final Optional<Integer>  nOfSightLaatMonth;
	private final Optional<Integer>  totalNOfSight;
	private final Optional<Double>  speedLimit;
	private final Optional<Double> averageSpeedToday;
	private final Optional<Double> averageSpeedLastWeek;
	private final Optional<Double> averageSpeedLastMonth;
	private final Optional<Double> maxSpeedToday;
	private final Optional<Double> maxCarRateToday;
	
	private InfoStreetObserver(IStreetObserver streetObserver,
			Integer nOfSightLastHour,
			Integer nOfSightToday,
			Integer nOfSightLastWeek,
			Integer nOfSightLaatMonth,
			Integer totalNOfSight,
			Double speedLimit,
			Double averageSpeedToday,
			Double averageSpeedLastWeek,
			Double averageSpeedLastMonth,
			Double maxSpeedToday, 
			Double maxCarRateToday) {
		
		super();
		this.streetObserver = Optional.ofNullable(streetObserver);
		this.nOfSightLastHour = Optional.ofNullable(nOfSightLastHour);
		this.nOfSightToday = Optional.ofNullable(nOfSightToday);
		this.nOfSightLastWeek = Optional.ofNullable(nOfSightLastWeek);
		this.nOfSightLaatMonth = Optional.ofNullable(nOfSightLaatMonth);
		this.totalNOfSight = Optional.ofNullable(totalNOfSight);
		this.speedLimit = Optional.ofNullable(speedLimit);
		this.averageSpeedToday = Optional.ofNullable(averageSpeedToday);
		this.averageSpeedLastWeek = Optional.ofNullable(averageSpeedLastWeek);
		this.averageSpeedLastMonth = Optional.ofNullable(averageSpeedLastMonth);
		this.maxSpeedToday = Optional.ofNullable(maxSpeedToday);
		this.maxCarRateToday = Optional.ofNullable(maxCarRateToday);
	}
	
	private String stringOutputUtility(Optional<?> o){
		return o.orElseGet(() -> {return EMPTY_STRING;}).toString();
	}

	@Override
	public String getStreetObserverLocation() {
		if(this.streetObserver.isPresent()){
			return this.streetObserver.get().getCoordinates().toString();
		}
		else{
			// TODO better throwing new exception?
			return EMPTY_STRING;
		}
	}
	
	@Override
	public String getStreetObserverID() {
		if(this.streetObserver.isPresent()){
			return String.valueOf(this.streetObserver.get().hashCode());
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
	public String getSpeedLimit() {
		return this.stringOutputUtility(this.speedLimit);
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
								  .append(" speedLimit=" + this.getSpeedLimit())
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
		private Double speedLimit;
		private Double averageSpeedToday;
		private Double averageSpeedLastWeek;
		private Double averageSpeedLastMonth;
		private Double maxSpeedToday;
		private Double maxCarRateToday;
		
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
		
		public Builder nOfSightLaatMonth(int nOfSightLaatMonth){
			this.nOfSightLaatMonth = nOfSightLaatMonth;
			return this;
		}
		
		public Builder totalNOfSight(int totalNOfSight){
			this.totalNOfSight = totalNOfSight;
			return this;
		}
		
		public Builder speedLimit(double speedLimit){
			this.speedLimit = speedLimit;
			return this;
		}
		
		public Builder averageSpeedToday(double averageSpeedToday){
			this.averageSpeedToday = averageSpeedToday;
			return this;
		}
		
		public Builder averageSpeedLastWeek(double averageSpeedLastWeek){
			this.averageSpeedLastWeek = averageSpeedLastWeek;
			return this;
		}
		
		public Builder averageSpeedLastMonth(double averageSpeedLastMonth){
			this.averageSpeedLastMonth = averageSpeedLastMonth;
			return this;
		}
		
		public Builder maxSpeedToday(double maxSpeedToday){
			this.maxSpeedToday = maxSpeedToday;
			return this;
		}
		
		public Builder maxCarRateToday(double maxCarRateToday){
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
					this.speedLimit,
					this.averageSpeedToday,
					this.averageSpeedLastWeek,
					this.averageSpeedLastMonth,
					this.maxSpeedToday,
					this.maxCarRateToday);
		}
		
	}

}
