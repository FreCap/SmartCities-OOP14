package it.unibo.oop.smartercities.control;

import it.unibo.oop.smartercities.datatype.IStreetObserver;
import it.unibo.oop.smartercities.datatype.NumberPlate;
import it.unibo.oop.smartercities.model.Model;
import it.unibo.oop.smartercities.model.ModelInterface;
import it.unibo.oop.smartercities.view.ViewInterface;

public class Controller implements ControllerInterface {

	private final ViewInterface scView;
	private final ModelInterface scModel;
	
	public Controller(final ViewInterface scView) {
		this.scModel = new Model();
		this.scView = scView;
		this.scView.attachViewObserver(this);
	}
	
	@Override
	public Object getStreetObserverInfo(int id) {
		// TODO
		return scModel.takeInfoOf(id);
	}

	@Override
	public Object getStolenCarsInfo(NumberPlate np) {
		// TODO
		return null;
	}

	@Override
	public void pluginRequest(Double latitude, Double longitude) {		
		IStreetObserver so;
		so = this.scModel.addNewStreetObserver(latitude, longitude);
		this.scView.newPlug(so.getPosition());
		this.scView.addStreetObserver(so);
	}

	@Override
	public void newPassage(int id, Object informations) {
		// TODO	
	}
}
