package it.unibo.oop.smartercities.model;

import java.util.AbstractList;
import java.util.LinkedList;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.IStreetObserver;
import it.unibo.oop.smartercities.datatype.NumberPlate;
import it.unibo.oop.smartercities.datatype.StreetObserver;

public class Model implements ModelInterface{
	
	private AbstractList<IStreetObserver> soList = new LinkedList<>();

	public Model() {
		super();
	}
	
	@Override
	public IStreetObserver addNewStreetObserver(Coordinates c) {
		IStreetObserver iSo = new StreetObserver(c);
		soList.add(iSo);
		return iSo;
	}

	@Override
	public Object takeInfoOf(Coordinates c) {
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
