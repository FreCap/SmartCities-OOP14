package it.unibo.oop.smartercities.controller;

import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;
import it.unibo.oop.smartercities.model.Model;
import it.unibo.oop.smartercities.model.IModel;
import it.unibo.oop.smartercities.view.IViewGUI;

public class Controller implements IController {

	private final IViewGUI scView;
	private final IModel scModel;
	
	public Controller(final IViewGUI scView) {
		this.scModel = new Model();
		this.scView = scView;
		//TODO attaccare alla view i due listener di azioni
	}

	@Override
	public IStreetObserverObserver getStreetObserverInfo(IStreetObserver streetObserver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.scView.addStreetObserver(streetObserver);
		this.scModel.addNewStreetObserver(streetObserver);
	}

	@Override
	public void newPassage(IStreetObserver streetObserver, ISighting is) {
		this.scView.newPassage(streetObserver);
		this.scModel.newPassage(streetObserver, is);
	}

}
