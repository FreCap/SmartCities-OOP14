package it.unibo.oop.smartercities.controller;

import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;
import it.unibo.oop.smartercities.model.Model;
import it.unibo.oop.smartercities.model.IModel;
import it.unibo.oop.smartercities.view.IViewGUI;

public class Controller implements IController {

	private final IViewGUI view;
	private final IModel model;
	
	public Controller(IViewGUI view) {
		this.model = new Model();
		this.view = view;
		this.view.attachStreetObserverObserver(this);
		this.view.attachStolenCarsObserver(this);
	}

	@Override
	public IStreetObserverObserver getStreetObserverInfo(IStreetObserver streetObserver) {
		//TODO
		return null;
	}

	@Override
	public IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.view.addStreetObserver(streetObserver);
		this.model.addNewStreetObserver(streetObserver);
	}

	@Override
	public void newPassage(IStreetObserver streetObserver, ISighting is) {
		this.view.newPassage(streetObserver);
		this.model.newPassage(streetObserver, is);
	}

}
