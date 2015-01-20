package it.unibo.oop.smartercities.network.jobs;

import it.unibo.oop.smartercities.database.data.StolenCars;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.PlainSighting;

import java.util.Observable;
import java.util.Observer;

public class StolenCarsChecker implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof PlainSighting) {
			PlainSighting sighting = (PlainSighting) arg;

			LicensePlate licensePlate = new LicensePlate(
					sighting.getLicensePlate());
			if (StolenCars.getInstance().checkStolenPlate(licensePlate)) {
				// TODO crea alarm!! macchina fottuta
			}

		}

	}

}
