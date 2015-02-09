package it.unibo.oop.smac.test.model;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.test.client.LicensePlateGenerator;

import javax.management.InvalidAttributeValueException;

public class LicensePlateTest {

	/**
	 * Controlla che la creazione di un oggetto {@link LicensePlate} con una
	 * targa conforme non restituisca eccezioni
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testNewLicensePlate() throws Exception {
		new LicensePlate("TE355TT");

	}

	/**
	 * Controlla che la creazione di un oggetto {@link LicensePlate} con una
	 * targa NON conforme restituisca eccezioni
	 * 
	 * @throws Exception
	 */
	@org.junit.Test(expected = InvalidAttributeValueException.class)
	public void testNewLicensePlateFail() throws Exception {
		new LicensePlate("NONCONFORME");
	}

	/**
	 * Controlla che il generatore di targhe {@link LicensePlateTest}
	 * restituisca una targa conforme
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testNewLicensePlateGenerator() throws Exception {
		new LicensePlate(LicensePlateGenerator.generate());
	}

}
