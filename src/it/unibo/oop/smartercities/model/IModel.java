package it.unibo.oop.smartercities.model;

import it.unibo.oop.smartercities.datatype.StolenCar;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IModel {
	
	// aggiunta di un nuovo street observer
	void addNewStreetObserver(IStreetObserver streetObserver);
	
	// notifica di un passaggio
	void newPassage(IStreetObserver streetObserver, ISighting s);
	
	// restituisce le info di uno street observer
	InfoStreetObserver getInfoOf(IStreetObserver streetObserver);
	
	// verifica se un auto è rubata
	StolenCar verifyStolenCar(IStolenCar stolenCar);
}
