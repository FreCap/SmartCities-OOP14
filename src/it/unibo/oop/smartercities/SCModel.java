package it.unibo.oop.smartercities;

import java.util.HashSet;

import it.unibo.oop.stolenCars.NumberPlate;
import it.unibo.oop.streetObservers.IStreetObserver;
import it.unibo.oop.streetObservers.StreetObserver;

public class SCModel extends HashSet<IStreetObserver> implements SCModelInterface{

	private static final long serialVersionUID = 126469849652984989L;

	public SCModel() {
		super();
	}
	
	@Override
	public IStreetObserver addNewStreetObserver(Double latitude, Double longitude) {
		IStreetObserver aso = new StreetObserver(MakeID.getMaker().getID(), latitude, longitude);
		this.add(aso);
		return aso;
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
