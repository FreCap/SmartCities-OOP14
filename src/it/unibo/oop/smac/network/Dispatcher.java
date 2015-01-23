package it.unibo.oop.smac.network;

import java.util.Observable;


public class Dispatcher extends Observable{
	
	private static Dispatcher instance ;
	private Dispatcher(){
		
	};
	
	public static synchronized Dispatcher getInstance() {
		if (instance != null)
			return instance;
		instance = new Dispatcher();
		return instance;
	}

}
