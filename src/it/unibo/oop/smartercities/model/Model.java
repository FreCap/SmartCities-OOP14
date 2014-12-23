package it.unibo.oop.smartercities.model;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.InfoStolenCars;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

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
	public void newPassage(Coordinates c, Sighting s) {
		// TODO Auto-generated method stub
		
	}
	
	//TODO override di equals e hash
}
