package it.unibo.oop.smac.network.jobs;

import it.unibo.oop.smac.datatype.LicensePlate;

import java.util.Observable;
import java.util.Observer;

public class StolenCarsChecker implements Observer {

	@Override
	public void update(Observable o, Object arg) {/*
		if (arg instanceof PlainSighting) {
			PlainSighting sighting = (PlainSighting) arg;

			LicensePlate licensePlate = new LicensePlate(
					sighting.getLicensePlate());
			if (StolenCars.getInstance().checkStolenPlate(licensePlate)) {
				// TODO crea alarm!! macchina fottuta
			}

		}*/

	}

}
