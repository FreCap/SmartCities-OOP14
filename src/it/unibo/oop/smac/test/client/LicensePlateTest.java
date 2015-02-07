package it.unibo.oop.smac.test.client;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.utils.RandomStringGenerator;

/**
 * Classe che genera una nuova targa, utilizzata a fini di test
 *
 */
public class LicensePlateTest {

	/**
	 * funzione statica che implementa la generazione della targa
	 * 
	 * @return targa generata
	 */
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
