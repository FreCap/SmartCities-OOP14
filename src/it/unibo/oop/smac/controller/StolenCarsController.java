package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.IStolenCarModel;
import it.unibo.oop.smac.model.ModelStolenCars;
import it.unibo.oop.smac.test.client.TrackSimulator;
import it.unibo.oop.smac.view.IView;

/** TODO
 * utilizzato pattern Decorator.
 * 
 * @author Fra
 */
public class StolenCarsController extends Controller implements IStolenCarsObserver {
	public final TrackSimulator trackSimulator = new TrackSimulator(LicensePlate.generate());
	
	protected final IStolenCarModel modelStolenCars;
	
	public StolenCarsController(IView view){
		super(view);
		modelStolenCars = ModelStolenCars.getInstance();
		this.view.attachStolenCarsObserver(this);
	}
	
	@Override
	public IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar) {
		return this.modelStolenCars.getStolenCarInfo(stolenCar);
	}
	
	@Override
	public void newPassage(IStreetObserver streetObserver, ISighting sighting) {
		super.newPassage(streetObserver, sighting);
		
		// controllo che non si tratti di una rubata
		if (modelStolenCars.checkStolenPlate(sighting.getLicensePlate())) {
			// TODO crea alarm!! macchina fottuta
		}	
	}
	
}
