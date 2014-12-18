package it.unibo.oop.smartercities.model;

import java.util.AbstractList;
import java.util.LinkedList;

import it.unibo.oop.stolenCars.NumberPlate;
import it.unibo.oop.streetObservers.IStreetObserver;
import it.unibo.oop.streetObservers.StreetObserver;

public class SCModel implements SCModelInterface{
	
	private AbstractList<IStreetObserver> soList = new LinkedList<>();

	public SCModel() {
		super();
	}
	
	@Override
	public IStreetObserver addNewStreetObserver(Double latitude, Double longitude) {
		IStreetObserver iSo = new StreetObserver(MakeID.getMaker().getID(), latitude, longitude);
		soList.add(iSo);
		return iSo;
	}

	@Override
	public Object takeInfoOf(int id) {
		// TODO
		return null;
	}

	@Override
	public boolean verifyStolenCar(NumberPlate np) {
		// TODO
		return false;
	}
	
	//TODO override di equals e hash
}
