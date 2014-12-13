package it.unibo.oop.smartercities;

public interface SCViewInterface {
	
	// funzione per la richiesta di plugin di un nuovo street observer
	// valore di ritorno: true se è stato accettato, false altrimenti
	boolean pluginRequest(int id, Double latitude, Double longitude);
	
	// quando si verifica un nuovo passaggio sotto uno street observer, viene segnalato
	// all'osservetore con corrispettivo id
	void newPassage(int id);
	
	// aggiunge un osservatore(controller)
	void attachViewObserver(final SCViewObserverInterface viewObserver);
}
