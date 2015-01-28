package it.unibo.oop.smac.view.mainpanel;

import javax.swing.JPanel;

import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Interfaccia del JPanel contenente le informazioni raccolte dagli
 * {@link IStreetObserver}.
 * 
 * @author Federico Bellini
 */
public interface IMainPanel {

	/**
	 * Aggiunge un'{@link IStreetObserver} nella GUI.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} da aggiungere.
	 */
	void addStreetObserver(IStreetObserver streetObserver);
	
	/**
	 * Mostra che un'{@link IStreetObserver} ha rilevato dei dati.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} che ha rilevato dei dati.
	 */
	void notifyPassage(IStreetObserver streetObserver);
	
	/**
	 * Attacca un Observer degli StreetObserver.
	 * 
	 * @param soo
	 * 			L'{@link IStreetObserverObserver} da attaccare.
	 */
	void attachStreetObserverObserver(IStreetObserverObserver soo);
	
	/**
	 * Restituisce il JPanel.
	 * 
	 * @return
	 * 		Il JPanel.
	 */
	JPanel getPanel();
}
