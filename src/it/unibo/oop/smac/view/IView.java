package it.unibo.oop.smac.view;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Interfaccia realizzata per la gestione della parte di View del programma.
 * Essa puo' essere implementata sia da un'interfaccia di tipo grafico sia non.
 * In questo modo viene garantita la massima genericità ed indipendenza della parte di
 * View dell'applicazione dalle parti di Model e Controller.
 * 
 * @author Federico Bellini
 */
public interface IView {
	
	/**
	 * Questo metodo deve mostrare che un nuovo {@link IStreetObserver} e' appena 
	 * stato connesso.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} appena connesso.
	 */
	void addStreetObserver(IStreetObserver streetObserver);
	
	/**
	 * Questo metodo deve segnalare che c'e' stato un passaggio sotto un'osservatore.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} che ha compiuto l'avvistamento.
	 */
	void newPassage(IStreetObserver streetObserver);
	
	/**
	 * Questo metodo deve attaccare l'Observer passato come parametro agli StreetObserver
	 * presenti nella View. In questo modo e' l'Observer preso come paramentro che
	 * gestisce il comportamento dell'applicazione quando vengono fatte delle richieste
	 * su degli StreetObserver da parte della View.
	 * 
	 * @param soo
	 * 			L'{@link IStreetObserverObserver} da attaccare agli StreetObserver presenti
	 * 			nella View.
	 */
	void attachStreetObserverController(IStreetObserverObserver soo);
		
	/**
	 * Questo metodo deve attaccare l'Observer passato come parametro alle StolenCars
	 * presenti nella View. In questo modo e' l'Observer preso come paramentro che
	 * gestisce il comportamento dell'applicazione quando vengono fatte delle richieste
	 * su delle StolenCars da parte della View.
	 * 
	 * @param sco
	 * 			L'{@link IStolenCarsObserver} da attaccare alle StolenCars presenti
	 * 			nella View.
	 */
	void attachStolenCarsController(IStolenCarsObserver sco);
}
