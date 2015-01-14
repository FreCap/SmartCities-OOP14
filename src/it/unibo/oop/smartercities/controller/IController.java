package it.unibo.oop.smartercities.controller;

import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public interface IController extends IStreetObserverObserver, IStolenCarsObserver{
	
	// TODO mettere questi ultimi due metodi in un'interfaccia che stabilisce il contratto tra
	// client e server
	
	// metodo che aggiunge un nuovo streetObserver(invocato dal client)
	void addStreetObserver(IStreetObserver streetObserver);
	
	// metodo richiamato quando si vedifica un passaggio sotto uno streetObserver. ISighting è il 
	// pacchetto di info che il client ci manda(metodo invocato dal client)
	void newPassage(IStreetObserver streetObserver, ISighting is);
}
