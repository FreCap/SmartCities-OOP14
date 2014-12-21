package it.unibo.oop.smartercities.control;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.NumberPlate;

public interface ControllerInterface {
	
	// richiesta della view di avere info su un osservatore(id)
	Object getStreetObserverInfo(Coordinates c);
	
	// richiesta della view di info su una targa
	Object getStolenCarsInfo(NumberPlate np);
	
	// funzione per la richiesta di plugin di un nuovo street observer
	// valore di ritorno: true se è stato accettato, false altrimenti
	void pluginRequest(Coordinates c);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, invia info
	void newPassage(int id, Object informations);
}