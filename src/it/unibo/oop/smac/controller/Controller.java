package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.IStolenCars;
import it.unibo.oop.smac.model.IStreetObservers;
import it.unibo.oop.smac.model.Model;
import it.unibo.oop.smac.model.ModelStolenCars;
import it.unibo.oop.smac.model.exception.DuplicateFound;
import it.unibo.oop.smac.model.exception.NotFound;
import it.unibo.oop.smac.test.client.TrackSimulator;
import it.unibo.oop.smac.view.IView;

public class Controller implements IController {

	private final IView view;
	private final IStreetObservers model;
	private final IStolenCars modelStolenCars;
	public final TrackSimulator trackSimulator = new TrackSimulator(
			LicensePlate.generate());

	public Controller(IView view) {
		model = Model.getInstance();
		modelStolenCars = ModelStolenCars.getInstance();
		this.view = view;
		this.view.attachStreetObserverObserver(this);
		this.view.attachStolenCarsObserver(this);
	}

	@Override
	public IInfoStreetObserver getStreetObserverInfo(
			IStreetObserver streetObserver) throws IllegalArgumentException,
			NotFound {
		return model.getStreetObserverInfo(streetObserver);
	}

	@Override
	public IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar) {
		return model.getStolenCarInfo(stolenCar);
	}

	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		// check se da aggiungere

		try {
			model.addNewStreetObserver(streetObserver);
			view.addStreetObserver(streetObserver);

		} catch (DuplicateFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void newPassage(IStreetObserver streetObserver, ISighting is) {
		// controllo di avere già lo streetObserver nel DB, se non l'ho
		// l'aggiungo e notifico il controller
		try {
			model.getStreetObserverInfo(streetObserver);
		} catch (NotFound e) {
			addStreetObserver(streetObserver);
		}
		// aggiungo il sighting al model
		model.addSighting(is);

		// controllo che non si tratti di una rubata
		;
		if (modelStolenCars.checkStolenPlate(is.getLicensePlate())) {
			// TODO crea alarm!! macchina fottuta
		}

		// notifico la view
		view.newPassage(streetObserver);
	}

}
