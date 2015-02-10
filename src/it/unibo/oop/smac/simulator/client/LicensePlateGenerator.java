package it.unibo.oop.smac.simulator.client;

import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.utils.RandomStringGenerator;

import javax.management.InvalidAttributeValueException;

/**
 * Classe che genera una nuova targa, utilizzata a fini di test.
 *
 */
public final class LicensePlateGenerator {
  private LicensePlateGenerator() {

  }

  /**
   * funzione statica che implementa la generazione della targa.
   * 
   * @return targa generata
   */
  public static LicensePlate generate() {
    LicensePlate licensePlate = null;
    try {
      licensePlate = new LicensePlate(RandomStringGenerator.generateRandomString(2,
          RandomStringGenerator.Mode.ALPHA)
          + RandomStringGenerator.generateRandomString(3, RandomStringGenerator.Mode.NUMERIC)
          + RandomStringGenerator.generateRandomString(2, RandomStringGenerator.Mode.ALPHA));
    } catch (InvalidAttributeValueException e) {
      // NON può succedere poiché la targa è generata secondo lo standard
      // richiesto
      e.printStackTrace();
    }
    return licensePlate;

  }

}