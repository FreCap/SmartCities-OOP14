package it.unibo.oop.smartercities.datatype.I;

import java.util.Optional;

public interface IInfoStreetObserver {

	public Optional<IStreetObserver> getStreetObserver();
	
	public Optional<Integer> getnOfSightLastHour();

	public Optional<Integer> getnOfSightToday();

	public Optional<Integer> getnOfSightLastWeek();

	public Optional<Integer> getnOfSightLaatMonth();

	public Optional<Integer> getTotalNOfSight();

	public Optional<Double> getSpeedLimit();

	public Optional<Double> getAverageSpeedToday();

	public Optional<Double> getAverageSpeedLastWeek();

	public Optional<Double> getAverageSpeedLastMonth();

	public Optional<Double> getMaxSpeedToday();

	public Optional<Double> getMaxCarRateToday();
}
