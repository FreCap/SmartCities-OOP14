package it.unibo.oop.smartercities.datatype;

import java.util.Optional;

import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

// UTILIZZATO IL PATTERN BUILDER!!!

// pacchetto di info che il database restituisce alla gui quando la gui richiede di avere
// delle info su di uno street observer dal database
public class InfoStreetObserver implements IInfoStreetObserver{
	
	// TODO trasforma i campi in Optional
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
			int nOfSightLastHour,
			int nOfSightToday,
			int nOfSightLastWeek,
			int nOfSightLaatMonth,
			int totalNOfSight,
			double speedLimit,
			double averageSpeedToday,
			double averageSpeedLastWeek,
			double averageSpeedLastMonth,
			double maxSpeedToday, 
			double maxCarRateToday) {
		
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
	

	@Override
	public Optional<IStreetObserver> getStreetObserver() {
		return this.streetObserver;
	}


	@Override
	public Optional<Integer> getnOfSightLastHour() {
		return this.nOfSightLastHour;
	}


	@Override
	public Optional<Integer> getnOfSightToday() {
		return this.nOfSightToday;
	}


	@Override
	public Optional<Integer> getnOfSightLastWeek() {
		return this.nOfSightLastWeek;
	}


	@Override
	public Optional<Integer> getnOfSightLaatMonth() {
		return this.nOfSightLaatMonth;
	}


	@Override
	public Optional<Integer> getTotalNOfSight() {
		return this.totalNOfSight;
	}


	@Override
	public Optional<Double> getSpeedLimit() {
		return this.speedLimit;
	}


	@Override
	public Optional<Double> getAverageSpeedToday() {
		return this.averageSpeedToday;
	}


	@Override
	public Optional<Double> getAverageSpeedLastWeek() {
		return this.averageSpeedLastWeek;
	}


	@Override
	public Optional<Double> getAverageSpeedLastMonth() {
		return this.averageSpeedLastMonth;
	}


	@Override
	public Optional<Double> getMaxSpeedToday() {
		return this.maxSpeedToday;
	}


	@Override
	public Optional<Double> getMaxCarRateToday() {
		return this.maxCarRateToday;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append(" streetObserver=" + streetObserver)
								  .append(" nOfSightLastHour=" + nOfSightLastHour)
								  .append(" nOfSightToday=" + nOfSightToday)
								  .append(" nOfSightLastWeek=" + nOfSightLastWeek)
								  .append(" nOfSightLaatMonth=" + nOfSightLaatMonth)
								  .append(" totalNOfSight=" + totalNOfSight)
								  .append(" speedLimit=" + speedLimit)
								  .append(" averageSpeedToday=" + averageSpeedToday)
								  .append(" averageSpeedLastWeek=" + averageSpeedLastWeek)
								  .append(" averageSpeedLastMonth=" + averageSpeedLastMonth)
								  .append(" maxSpeedToday=" + maxSpeedToday)
								  .append(" maxCarRateToday=" + maxCarRateToday)
								  .toString();
	}

	//TODO quando hai finito con i campi, aggiungi hash e equals


	// builder for this class
	public static class Builder{
		private IStreetObserver streetObserver;
		private int nOfSightLastHour;
		private int nOfSightToday;
		private int nOfSightLastWeek;
		private int nOfSightLaatMonth;
		private int totalNOfSight;
		private double speedLimit;
		private double averageSpeedToday;
		private double averageSpeedLastWeek;
		private double averageSpeedLastMonth;
		private double maxSpeedToday;
		private double maxCarRateToday;
		
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
