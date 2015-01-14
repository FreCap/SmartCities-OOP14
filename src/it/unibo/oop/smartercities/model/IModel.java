package it.unibo.oop.smartercities.model;

import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IModel {
	
	// questo metodo deve aggiungere un nuovo streetObserver al DATABASE
	void addNewStreetObserver(IStreetObserver streetObserver);
	
	// questo metodo deve aggiungere il pacchetto di informazioni "s" al database.
	// s è il pacchetto di info inviato da "streetObserver"
	void newPassage(IStreetObserver streetObserver, ISighting s);
	
	// questo metodo deve far tornare un pacchetto IInfoStreetObserver dello streetObserver richiesto
	IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver);
	
	// questo metodo deve far tornare un pacchetto IInfoStolenCarr della stolenCar richiesta
	IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar);
}
