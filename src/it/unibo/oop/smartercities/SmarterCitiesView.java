package it.unibo.oop.smartercities;

public interface SmarterCitiesView {
	boolean pluginRequest(Double latitude, Double longitude);
	
	void sendInformationsTo(int ID);
}
