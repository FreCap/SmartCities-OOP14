package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.unibo.oop.smac.database.model.StreetObserverModelDatabase;
import it.unibo.oop.smac.database.model.StreetObserverNotValidException;
import it.unibo.oop.smac.datatypes.Coordinates;
import it.unibo.oop.smac.datatypes.IInfoStreetObserver;
import it.unibo.oop.smac.datatypes.IStreetObserver;
import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.datatypes.Sighting;
import it.unibo.oop.smac.datatypes.StreetObserver;
import it.unibo.oop.smac.model.IStreetObserverModel;
import it.unibo.oop.smac.simulator.client.LicensePlateGenerator;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class ModelTest {

  private Coordinates generateCoordinates() {
    final Random rand = new Random();
    return new Coordinates(rand.nextFloat(), rand.nextFloat());
  }

  /**
   * Controllo che il model riesca a creare uno streetObserver valido.
   * 
   */
  @Test
  public void testAddNewStreetObserver() {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();
    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());
    model.addNewStreetObserver(streetObserver);
    assertTrue(model.checkStreetObserverExists(streetObserver));
  }

  /**
   * Controllo che il model NON riesca a creare uno streetObserver NON valido.
   * 
   * @exception StreetObserverNotValidException
   *              necessaria l'exception per il successo del test
   */
  @Test(expected = StreetObserverNotValidException.class)
  public void testAddNewStreetObserverFail() throws Exception {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();
    StreetObserver streetObserver = null;
    streetObserver = new StreetObserver((IStreetObserver) null);

    // questo test fallisce!
    model.addNewStreetObserver(streetObserver);
  }

  /**
   * Controllo che il model riesca ad inserire un sighting valido.
   * 
   */
  @Test
  public void testAddSighting() {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();

    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());
    final float speed = 44f;

    final LicensePlate licensePlate = LicensePlateGenerator.generate();

    final Sighting sighting = new Sighting.Builder().date(new Date())
        .streetObserver(streetObserver).speed(speed).licensePlate(licensePlate).build();
    try {
      model.addSighting(sighting);
    } catch (Exception e) {
      fail();
    }

    try {
      assertTrue(model.getStreetObserverInfo(streetObserver).getTotalNOfSight().get().equals(1));
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Controllo che il model NON riesca ad inserire un sighting con streetObserver non valido.
   * 
   */
  @Test
  public void testAddSightingFail() {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();
    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());
    model.addNewStreetObserver(streetObserver);

    try {
      model.addSighting(new Sighting.Builder().build());
      fail();
    } catch (Exception e) {
    }
  }

  /**
   * Controllo che il model restituisca un InfoStreetObserver con dati coerenti a quelli nel
   * database.
   */
  @Test
  public void testInfoStreetObserver() {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();

    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());
    final Float speed = 44f;
    final LicensePlate licensePlate = LicensePlateGenerator.generate();

    final Sighting sighting = new Sighting.Builder().date(new Date())
        .streetObserver(streetObserver).speed(speed).licensePlate(licensePlate).build();
    try {
      model.addSighting(sighting);
    } catch (Exception e) {
      fail();
    }

    IInfoStreetObserver infoStreetObserver = null;
    try {
      infoStreetObserver = model.getStreetObserverInfo(streetObserver);
    } catch (Exception e) {
      fail();
    }
    assertTrue(infoStreetObserver.getTotalNOfSight().get().equals(1));
    System.out.println(infoStreetObserver.getAverageSpeedToday());
    System.out.println(speed);
    assertTrue(infoStreetObserver.getAverageSpeedToday().get().equals(speed));

  }

}
