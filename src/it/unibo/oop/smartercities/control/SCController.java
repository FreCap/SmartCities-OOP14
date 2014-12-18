package it.unibo.oop.smartercities.control;

import it.unibo.oop.smartercities.model.SCModel;
import it.unibo.oop.smartercities.model.SCModelInterface;
import it.unibo.oop.smartercities.view.SCViewInterface;
import it.unibo.oop.stolenCars.NumberPlate;
import it.unibo.oop.streetObservers.IStreetObserver;

public class SCController implements SCViewObserverInterface {

	private final SCViewInterface scView;
	private final SCModelInterface scModel;
	
	public SCController(final SCViewInterface scView) {
		this.scModel = new SCModel();
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
	public boolean pluginRequest(Double latitude, Double longitude) {
		
		boolean req = this.scView.pluginRequest(latitude, longitude);
		
		if(req){
			IStreetObserver iSo;
			iSo = this.scModel.addNewStreetObserver(latitude, longitude);
			scView.addStreetObserver(iSo);
		}
		return req;
	}

	@Override
	public void newPassage(int id, Object informations) {
		// TODO	
	}
}
