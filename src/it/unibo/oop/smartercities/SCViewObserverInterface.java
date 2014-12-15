package it.unibo.oop.smartercities;

import it.unibo.oop.stolenCars.NumberPlate;

public interface SCViewObserverInterface {
	
	// richiesta della view di avere info su un osservatore(id)
	Object getStreetObserverInfo(int id);
	
	// richiesta della view di info su una targa
	Object getStolenCarsInfo(NumberPlate np);
	
	// funzione per la richiesta di plugin di un nuovo street observer
	// valore di ritorno: true se è stato accettato, false altrimenti
	boolean pluginRequest(Double latitude, Double longitude);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, invia info
	void newPassage(int id, Object informations);
}
