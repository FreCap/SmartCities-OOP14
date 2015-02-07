package it.unibo.oop.smac.test.client;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.utils.RandomStringGenerator;

public class LicensePlateTest {

	// TODO questo metodo ha senso al di fuori della progettazione del server..
	// dovrebbe essere un metodo che esiste solo nella parte di generazione
	// casuale di eventi..
	public static LicensePlate generate() {
		LicensePlate licensePlate = new LicensePlate(
				RandomStringGenerator.generateRandomString(2,
						RandomStringGenerator.Mode.ALPHA)
						+ RandomStringGenerator.generateRandomString(3,
								RandomStringGenerator.Mode.NUMERIC)
						+ RandomStringGenerator.generateRandomString(2,
								RandomStringGenerator.Mode.ALPHA));
		return licensePlate;

	}

}
