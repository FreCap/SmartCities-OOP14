package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

public interface IController extends IStreetObserverObserver, IStolenCarsObserver{
	
	// TODO mettere questi ultimi due metodi in un'interfaccia che stabilisce il contratto tra
	// client e server
	// una volta fatto ciò, implementare il Controller che inizialmente implementa solo IStreetObsObs e
	// l'altra interfaccia per la rete, e poi farne una Decorazione(pattern) che implementa anche la
	// interfaccia IStolenCarsObserver
	
	
	// metodo che aggiunge un nuovo streetObserver(invocato dal client)
	void addStreetObserver(IStreetObserver streetObserver);
	
	// metodo richiamato quando si vedifica un passaggio sotto uno streetObserver. ISighting è il 
	// pacchetto di info che il client ci manda(metodo invocato dal client)
	void newPassage(IStreetObserver streetObserver, ISighting is);
}
