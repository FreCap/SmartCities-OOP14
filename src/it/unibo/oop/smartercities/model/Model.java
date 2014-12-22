package it.unibo.oop.smartercities.model;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.IStreetObserver;
import it.unibo.oop.smartercities.datatype.InfoSighting;
import it.unibo.oop.smartercities.datatype.InfoStolenCars;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.StreetObserver;

public class Model implements ModelInterface {
	
	private AbstractList<IStreetObserver> soList = new LinkedList<>();

	public Model() {
		super();
	}
	
	@Override
	public void addNewStreetObserver(Coordinates c) {
		IStreetObserver iSo = new StreetObserver(c);
		soList.add(iSo);
	}

	@Override
	public InfoStreetObserver getInfoOf(Coordinates c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoStolenCars verifyStolenCar(LicensePlate np) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getStolenCarsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void newPassage(Coordinates c, InfoSighting s) {
		// TODO Auto-generated method stub
		
	}
	
	//TODO override di equals e hash
}
