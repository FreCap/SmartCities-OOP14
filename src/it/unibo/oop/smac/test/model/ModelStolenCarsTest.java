package it.unibo.oop.smac.test.model;

import static org.junit.Assert.assertTrue;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.StolenCar;
import it.unibo.oop.smac.model.IStolenCarModel;
import it.unibo.oop.smac.model.ModelStolenCars;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;

public class ModelStolenCarsTest {

	private static final String VALID_LICENSEPLATE = "TE355TT";
	private static final String INVALID_LICENSEPLATE = "NONCONFORME";

	/**
	 * Controlla che la creazione di un oggetto {@link LicensePlate} con una
	 * targa conforme non restituisca eccezioni
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNewStolenCarWithValidLicensePlate() throws Exception {
		new StolenCar.Builder().licensePlate(VALID_LICENSEPLATE);

	}

	/**
	 * Controlla che la creazione di un oggetto {@link StolenCar} con una targa
	 * NON conforme restituisca eccezioni
	 * 
	 * @throws Exception
	 */
	@Test(expected = InvalidAttributeValueException.class)
	public void testNewStolenCarWithInvalidLicensePlate() throws Exception {
		new StolenCar.Builder().licensePlate(INVALID_LICENSEPLATE);
	}

	/**
	 * Controlla che la creazione di un oggetto {@link StolenCar} con una targa
	 * senza tutti i parametri settati dia errore
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testStolenCarBuilderInvalidParameter() throws Exception {
		new StolenCar.Builder().licensePlate(VALID_LICENSEPLATE).build();
		new StolenCar.Builder().insertionDateNow().build();
	}

	/**
	 * Controlla che la creazione di un oggetto {@link StolenCar} con una targa
	 * con tutti i parametri settati NON dia errore
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStolenCarBuildervalidParameter() throws Exception {
		new StolenCar.Builder().licensePlate(VALID_LICENSEPLATE).insertionDateNow()
				.build();
	}

	/**
	 * Controlla che una valida {@link StolenCar} venga aggiunta con successo
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNewStolenCar() throws Exception {
		final IStolenCarModel modelStolenCars = ModelStolenCars.getInstance();

		final StolenCar stolenCar = new StolenCar.Builder()
				.licensePlate(VALID_LICENSEPLATE).insertionDateNow().build();

		modelStolenCars.addNewStolenCar(stolenCar);
		assertTrue(modelStolenCars.checkStolenPlate(new LicensePlate(VALID_LICENSEPLATE)));

	}

	/**
	 * Controlla che venga restituita la lista delle car aggiunte
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetStolenCarsInfoList() throws Exception {
		final IStolenCarModel modelStolenCars = ModelStolenCars.getInstance();

		final StolenCar stolenCar = new StolenCar.Builder()
				.licensePlate(VALID_LICENSEPLATE).insertionDateNow().build();

		modelStolenCars.addNewStolenCar(stolenCar);
		assertTrue(modelStolenCars.getStolenCarsInfoList().size() > 0);

	}
}
