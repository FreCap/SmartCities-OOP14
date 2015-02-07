package it.unibo.oop.smac.network;

import it.unibo.oop.smac.controller.IController;

import java.util.Observable;

/**
 * Classe che estende la classe Observable che permette di notificare
 * determinati jobs dell'arrivo di messaggi da parte di clients
 */
public class Dispatcher extends Observable {

	/**
	 * controller che contiene i metodi per la notificazione dell'applicazione
	 * dei messaggi ricevuti e interpretati dai vari jobs
	 */
	private final IController controller;

	/**
	 * Costruttore della classe
	 * 
	 * @param controller
	 */
	Dispatcher(IController controller) {
		this.controller = controller;
	};

	/**
	 * Restituisce il controller dell'applicazione
	 * 
	 * @return controller
	 */
	public IController getController() {
		return controller;
	}

	/**
	 * Notifica gli observer
	 */
	@Override
	public void notifyObservers(Object arg) {
		// Notifica che lo stato dell'applicazione è cambiato
		setChanged();
		// e quindi al richiamo della funzione notifyObserves, devono essere
		// richiamati gli observers
		super.notifyObservers(arg);
	}

}
