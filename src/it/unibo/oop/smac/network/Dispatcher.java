package it.unibo.oop.smac.network;

import it.unibo.oop.smac.controller.IController;

import java.util.Observable;

public class Dispatcher extends Observable {

	private static Dispatcher instance;
	private final IController controller;

	Dispatcher(IController controller) {
		instance = this;
		this.controller = controller;

	};

	public static synchronized Dispatcher getInstance() throws Exception {
		if (instance != null)
			return instance;
		throw new Exception("Devi prima inizializzare la classe");

	}

	public IController getController() {
		return controller;
	}

}
