package it.unibo.oop.smartercities.control;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.model.Model;
import it.unibo.oop.smartercities.model.ModelInterface;
import it.unibo.oop.smartercities.view.IViewGUI;

public class Controller implements ControllerInterface {

	private final IViewGUI scView;
	private final ModelInterface scModel;
	
	public Controller(final IViewGUI scView) {
		this.scModel = new Model();
		this.scView = scView;
		//TODO attaccare alla view i due listener di azioni
	}
	
	@Override
	public Object getStreetObserverInfo(Coordinates<Double> c) {
		// TODO
		return scModel.getInfoOf(c);
	}

	@Override
	public Object getStolenCarsInfo(LicensePlate np) {
		// TODO
		return null;
	}

	@Override
	public void pluginRequest(Coordinates<Double> c) {		
		this.scModel.addNewStreetObserver(c);
		this.scView.addStreetObserver(c);
	}

	@Override
	public void newPassage(Coordinates<Double> c, Sighting is) {
		this.scView.newPassage(c);
		this.scModel.newPassage(c, is);
	}
}
