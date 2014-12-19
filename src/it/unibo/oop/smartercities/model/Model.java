package it.unibo.oop.smartercities.model;

import java.util.AbstractList;
import java.util.LinkedList;

import it.unibo.oop.smartercities.datatype.IStreetObserver;
import it.unibo.oop.smartercities.datatype.NumberPlate;
import it.unibo.oop.smartercities.datatype.StreetObserver;

public class Model implements ModelInterface{
	
	private AbstractList<IStreetObserver> soList = new LinkedList<>();

	public Model() {
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
