package it.unibo.oop.smartercities;

import it.unibo.oop.streetObservers.NumberPlate;

public class SCController implements SCViewObserverInterface {

	SCViewInterface scView;
	SCModelInterface scModel;
	
	public SCController(final SCViewInterface scView) {
		this.scModel = new SCModel();
		this.scView = scView;
		this.scView.attachViewObserver(this);
	}
	
	@Override
	public Object getInfoOf(int id) {
		// TODO
		return null;
	}

	@Override
	public Object getStolenCarsInfo(NumberPlate np) {
		// TODO
		return null;
	}

	@Override
	public boolean pluginRequest(int id, Double latitude, Double longitude) {
		boolean req;
		req = this.scView.pluginRequest(id, latitude, longitude);
		if(req){
			this.scModel.addNewStreetObserver(id, latitude, longitude);
		}
		return req;
	}

	@Override
	public void newPassage(int id, Object informations) {
		// TODO
		
	}

}
