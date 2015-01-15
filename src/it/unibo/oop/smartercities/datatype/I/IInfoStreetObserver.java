package it.unibo.oop.smartercities.datatype.I;

public interface IInfoStreetObserver {

	String getStreetObserverLocation();
	
	String getStreetObserverID();
	
	String getnOfSightLastHour();

	String getnOfSightToday();

	String getnOfSightLastWeek();

	String getnOfSightLastMonth();

	String getTotalNOfSight();

	String getSpeedLimit();

	String getAverageSpeedToday();

	String getAverageSpeedLastWeek();

	String getAverageSpeedLastMonth();

	String getMaxSpeedToday();

	String getMaxCarRateToday();

}
