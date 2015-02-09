package it.unibo.oop.smac.test.model;

import static org.junit.Assert.*;
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
	 */
	@org.junit.Test
	public void testAddNewStreetObserver(){
		final IStreetObserverModel model = Model.getInstance();
		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		model.addNewStreetObserver(streetObserver);
		assertTrue(model.checkStreetObserverExists(streetObserver));
	}

	/**
	 * Controllo che il model NON riesca a creare uno streetObserver NON valido
	 * 
	 */
	@org.junit.Test(expected = StreetObserverNotValidException.class)
	public void testAddNewStreetObserverFail() {
		final IStreetObserverModel model = Model.getInstance();
		StreetObserver streetObserver = null;
		try {
			streetObserver = new StreetObserver((IStreetObserver) null);
			fail();
		} catch (StreetObserverNotValidException e) {
		}
		
		// questo test fallisce!
		model.addNewStreetObserver(streetObserver);
	}

	/**
	 * Controllo che il model riesca ad inserire un sighting valido
	 * 
	 */
	@org.junit.Test
	public void testAddSighting() {
		final IStreetObserverModel model = Model.getInstance();

		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		float speed = 44f;

		LicensePlate licensePlate = LicensePlateGenerator.generate();

		Sighting sighting = new Sighting.Builder().date(new Date())
				.streetObserver(streetObserver).speed(speed)
				.licensePlate(licensePlate).build();
		try {
			model.addSighting(sighting);
		} catch (Exception e) {
			fail();
		}

		try {
			assertTrue(model.getStreetObserverInfo(streetObserver)
					.getTotalNOfSight().get().equals(1));
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Controllo che il model NON riesca ad inserire un sighting con
	 * streetObserver non valido
	 * 
	 */
	@org.junit.Test
	public void testAddSightingFail() {
		final IStreetObserverModel model = Model.getInstance();
		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		model.addNewStreetObserver(streetObserver);

		try {
			model.addSighting(new Sighting.Builder().build());
			fail();
		} catch (Exception e) {
		}
	}

	/**
	 * Controllo che il model restituisca un InfoStreetObserver con dati
	 * coerenti a quelli nel database
	 */
	@org.junit.Test
	public void testInfoStreetObserver() {
		final IStreetObserverModel model = Model.getInstance();

		StreetObserver streetObserver = new StreetObserver(
				this.generateCoordinates());
		Float speed = 44f;
		LicensePlate licensePlate = LicensePlateGenerator.generate();

		Sighting sighting = new Sighting.Builder().date(new Date())
				.streetObserver(streetObserver).speed(speed)
				.licensePlate(licensePlate).build();
		try {
			model.addSighting(sighting);
		} catch (Exception e) {
			fail();
		}

		IInfoStreetObserver infoStreetObserver = null;
		try {
			infoStreetObserver = model
					.getStreetObserverInfo(streetObserver);
		} catch (Exception e) {
			fail();
		}
		assertTrue(infoStreetObserver.getTotalNOfSight().get().equals(1));
		System.out.println(infoStreetObserver.getAverageSpeedToday());
		System.out.println(speed);
		assertTrue(infoStreetObserver.getAverageSpeedToday().get().equals(speed));

	}

}
