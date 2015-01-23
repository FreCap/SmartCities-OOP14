package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.IModel;
import it.unibo.oop.smac.model.Model;
import it.unibo.oop.smac.view.IView;

public class Controller implements IController {

	private final IView view;
	private final IModel model;
	
	public Controller(IView view) {
		this.model = new Model();
		this.view = view;
		this.view.attachStreetObserverObserver(this);
		this.view.attachStolenCarsObserver(this);
	}

	@Override
	public IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver) {
		return this.model.getStreetObserverInfo(streetObserver);
	}

	@Override
	public IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar) {
		return this.model.getStolenCarInfo(stolenCar);
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
