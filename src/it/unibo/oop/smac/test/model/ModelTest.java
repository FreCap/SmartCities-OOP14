package it.unibo.oop.smac.test.model;

import static org.junit.Assert.assertTrue;
import it.unibo.oop.smac.database.model.StreetObserverNotValidException;
import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.Sighting;
import it.unibo.oop.smac.datatype.StreetObserver;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.model.IStreetObserverModel;
import it.unibo.oop.smac.model.Model;
import it.unibo.oop.smac.test.client.LicensePlateGenerator;

import java.util.Date;
import java.util.Random;

public class ModelTest {

	private Coordinates generateCoordinates() {
		Random rand = new Random();
		return new Coordinates(rand.nextFloat(), rand.nextFloat());
	}

	/**
	 * Controllo che il model riesca a creare uno streetObserver valido
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testAddNewStreetObserver() throws Exception {
		final IStreetObserverModel model = Model.getInstance();
		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		model.addNewStreetObserver(streetObserver);
		assertTrue(model.checkStreetObserverExists(streetObserver));
	}

	/**
	 * Controllo che il model NON riesca a creare uno streetObserver NON valido
	 * 
	 * @throws Exception
	 */
	@org.junit.Test(expected = StreetObserverNotValidException.class)
	public void testAddNewStreetObserverFail() throws Exception {
		final IStreetObserverModel model = Model.getInstance();
		StreetObserver streetObserver = new StreetObserver(
				(IStreetObserver) null);
		model.addNewStreetObserver(streetObserver);

	}

	/**
	 * Controllo che il model riesca ad inserire un sighting valido
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testAddSighting() throws Exception {
		final IStreetObserverModel model = Model.getInstance();

		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		float speed = 44f;

		LicensePlate licensePlate = LicensePlateGenerator.generate();

		Sighting sighting = new Sighting.Builder().date(new Date())
				.streetObserver(streetObserver).speed(speed)
				.licensePlate(licensePlate).build();
		model.addSighting(sighting);

		assertTrue(model.getStreetObserverInfo(streetObserver)
				.getTotalNOfSight().equals("1"));
	}

	/**
	 * Controllo che il model NON riesca ad inserire un sighting con
	 * streetObserver non valido
	 * 
	 * @throws Exception
	 */
	@org.junit.Test(expected = StreetObserverNotValidException.class)
	public void testAddSightingFail() throws Exception {
		final IStreetObserverModel model = Model.getInstance();
		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		model.addNewStreetObserver(streetObserver);

		model.addSighting(new Sighting.Builder().build());

	}

	/**
	 * Controllo che il model restituisca un InfoStreetObserver con dati
	 * coerenti a quelli nel database
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testInfoStreetObserver() throws Exception {
		final IStreetObserverModel model = Model.getInstance();

		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		Float speed = 44f;
		LicensePlate licensePlate = LicensePlateGenerator.generate();

		Sighting sighting = new Sighting.Builder().date(new Date())
				.streetObserver(streetObserver).speed(speed)
				.licensePlate(licensePlate).build();
		model.addSighting(sighting);

		IInfoStreetObserver infoStreetObserver = model
				.getStreetObserverInfo(streetObserver);
		assertTrue(infoStreetObserver.getTotalNOfSight().equals("1"));
		System.out.println(infoStreetObserver.getAverageSpeedToday());
		System.out.println(speed);
		assertTrue(infoStreetObserver.getAverageSpeedToday().equals(speed));

	}

}
