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

/**
 * Classe che controlla l'interfaccia esposta da {@link StreetObserverModelDatabase}.
 * 
 * @author Francesco Capponi
 * @author Federico Bellini
 */
public class ModelStreetObserverTest {

  private Coordinates generateCoordinates() {
    final Random rand = new Random();
    return new Coordinates(rand.nextFloat(), rand.nextFloat());
  }

  /**
   * Controllo che il model riesca a creare uno streetObserver valido.
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
   * @throws Exception
   *           l'esecuzione dovrebbe restituire un eccezione
   */
  @Test(expected = StreetObserverNotValidException.class)
  public void testAddNewStreetObserverFail() throws Exception {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();
    StreetObserver streetObserver = null;
    streetObserver = new StreetObserver((IStreetObserver) null);

    model.addNewStreetObserver(streetObserver);
  }

  /**
   * Controllo che il model riesca ad inserire un sighting valido.
   * 
   * @throws Exception
   *           l'esecuzione non dovrebbe restituire un eccezioni, se le restituisce qualcosa è
   *           andato storto e il test fallisce
   */
  @Test
  public void testAddSighting() throws Exception {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();

    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());

    final LicensePlate licensePlate = LicensePlateGenerator.generate();

    final Sighting sighting = new Sighting.Builder().date(new Date())
        .streetObserver(streetObserver).speed(64f).licensePlate(licensePlate).build();

    model.addSighting(sighting);
    assertTrue(model.getStreetObserverInfo(streetObserver).getTotalNOfSight().get().equals(1));

  }

  /**
   * Controllo che il model NON riesca ad inserire un sighting con streetObserver non valido.
   * 
   * @throws Exception
   *           l'esecuzione dovrebbe restituire un eccezione poiché il {@link Sighting.Builder} non
   *           è stato creato correttamente
   */
  @Test(expected = Exception.class)
  public void testAddSightingFail() throws Exception {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();
    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());
    model.addNewStreetObserver(streetObserver);

    model.addSighting(new Sighting.Builder().build());
    fail();
  }

  /**
   * Controllo che il model restituisca un InfoStreetObserver con dati coerenti a quelli nel
   * database.
   * 
   * @throws Exception
   *           l'esecuzione non dovrebbe restituire un eccezioni, se le restituisce qualcosa è
   *           andato storto e il test fallisce
   */
  @Test
  public void testInfoStreetObserver() throws Exception {
    final IStreetObserverModel model = StreetObserverModelDatabase.getInstance();

    final StreetObserver streetObserver = new StreetObserver(this.generateCoordinates());
    final LicensePlate licensePlate = LicensePlateGenerator.generate();

    final Sighting sighting = new Sighting.Builder().date(new Date())
        .streetObserver(streetObserver).speed(64f).licensePlate(licensePlate).build();
    model.addSighting(sighting);

    final IInfoStreetObserver infoStreetObserver = model.getStreetObserverInfo(streetObserver);
    assertTrue(infoStreetObserver.getTotalNOfSight().get().equals(1));
    assertTrue(infoStreetObserver.getAverageSpeedToday().get().equals(64f));

  }

}
