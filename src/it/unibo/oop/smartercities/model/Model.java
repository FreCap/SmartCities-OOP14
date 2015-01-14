package it.unibo.oop.smartercities.model;

import it.unibo.oop.smartercities.datatype.StolenCar;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.LinkedList;
import java.util.List;

public class Model implements IModel {
	
	private List<IStreetObserver> streetObserversList = new LinkedList<>();

	public Model() {
		super();
	}
	

	@Override
	public void addNewStreetObserver(IStreetObserver streetObserver) {
		this.streetObserversList.add(streetObserver);
	}

	@Override
	public void newPassage(IStreetObserver streetObserver, ISighting s) {
		// TODO Auto-generated method stub
	}

	@Override
	public InfoStreetObserver getInfoOf(IStreetObserver streetObserver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StolenCar verifyStolenCar(IStolenCar stolenCar) {
		// TODO Auto-generated method stub
		return null;
	}

}
