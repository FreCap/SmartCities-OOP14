package it.unibo.oop.smac.datatypes;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.management.InvalidAttributeValueException;

/**
 * Classe che implementa la struttura della targa di un mezzo.
 * 
 * @author Federico Bellini
 */
public class LicensePlate implements Serializable {

  private static final long serialVersionUID = -194344929770325193L;

  /**
   * contenitore della valore della targa
   */
  private final String licensePlate;

  /**
   * Costruttore che crea una nuova LicensePlate, con la targa di test "AA000AA".
   */
  public LicensePlate() {
    this.licensePlate = "AA000AA";
  }

  /**
   * Costruttore che crea una nuova LicensePlate, copia di quella passata come parametro.
   * 
   * @param licensePlate
   *          La LicensePlate di cui creare una copia.
   * @throws InvalidAttributeValueException
   *           scatenato quando la targa non è valida
   */
  public LicensePlate(final LicensePlate licensePlate) throws InvalidAttributeValueException {
    this(licensePlate.getPlate());
  }

  /**
   * Coostruttore che crea una nuova LicensePlate impostando la stringa passata come parametro come
   * targa del mezzo.
   * 
   * @param licensePlate
   *          La targa che si vuole impostare.
   * @throws InvalidAttributeValueException
   *           scatenato quando la targa non è valida
   */
  public LicensePlate(final String licensePlate) throws InvalidAttributeValueException {
    if (!Pattern.matches("[a-zA-Z]{2}[0-9]{3,4}[a-zA-Z]{2}", licensePlate)) {
      throw new InvalidAttributeValueException();
    }
    this.licensePlate = licensePlate;
  }

  /**
   * Restituisce una stringa contenente la targa del mezzo.
   * 
   * @return La targa del mezzo.
   */
  public String getPlate() {
    return this.licensePlate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof LicensePlate) {
      return this.getPlate().equals(((LicensePlate) obj).getPlate());
    }
    return false;
  }

  @Override
  public String toString() {
    return this.getPlate();
  }

}
