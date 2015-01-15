package it.unibo.oop.smartercities.datatype.I;

public interface IInfoStreetObserver {

	String getStreetObserver();
	
	String getnOfSightLastHour();

	String getnOfSightToday();

	String getnOfSightLastWeek();

	String getnOfSightLaatMonth();

	String getTotalNOfSight();

	String getSpeedLimit();

	String getAverageSpeedToday();

	String getAverageSpeedLastWeek();

	String getAverageSpeedLastMonth();

	String getMaxSpeedToday();

	String getMaxCarRateToday();

}
