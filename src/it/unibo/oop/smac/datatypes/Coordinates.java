package it.unibo.oop.smac.datatypes;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Implementazione di una classe che gestisce le coordinate di un punto nello spazio.
 * 
 * @author Federico Bellini
 */
public class Coordinates implements ICoordinates, Serializable {

  private static final long serialVersionUID = 6127098657709069219L;

  /**
   * La precisione dei decimali che si vuole nelle coordinate. Es. con DECIMAL_PRECISION settata a
   * 6, le coordinate avranno come lunghezza decimale massima 6 cifre, per + esempio 42.123456
   */
  private static final int DECIMAL_PRECISION = 6;

  private final Float latitude;
  private final Float longitude;

  /**
   * Costruttore che prende in ingresso la latitudine e la longitudine di un punto per crearne le
   * sue coordinate.
   * 
   * @param latitude
   *          La latitudine del punto.
   * @param longitude
   *          La longitudine del punto.
   */
  public Coordinates(final Float latitude, final Float longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Costruttore che prende in ingresso un'altro oggetto di tipo {@link ICoordinates} per creare un
   * nuovo oggetto posizionato nello stesso punto dell'oggetto passato.
   * 
   * @param coordinates
   *          Un oggetto {@link ICoordinates} di cui se ne vuole riprodurre un altro oggetto
   *          Coordinates avente la stessa posizione spaziale.
   */
  public Coordinates(final ICoordinates coordinates) {
    this(coordinates.getLatitude(), coordinates.getLongitude());
  }

  /**
   * Metodo privato utilizzato per troncare i numeri Float fino ad una certa cifra decimale,
   * stabilita dal campo DECIMAL_PRECISION.
   * 
   * @param number
   *          Il numero da modificare.
   * @return Il numero modificato.
   */
  private static Float decimalRound(final Float number) {
    BigDecimal bigDecimal = new BigDecimal(Float.toString(number));
    bigDecimal = bigDecimal.setScale(DECIMAL_PRECISION, BigDecimal.ROUND_HALF_UP);
    return bigDecimal.floatValue();
  }

  /**
   * Restituisce la latitudine del punto approssimata alla DECIMAL_PRECISION.
   * 
   * @return La latitudine del punto.
   */
  @Override
  public Float getLongitude() {
    return decimalRound(this.longitude);
  }

  /**
   * Restituisce la longitudine del punto approssimata alla DECIMAL_PRECISION.
   * 
   * @return La longitudine del punto.
   */
  @Override
  public Float getLatitude() {
    return decimalRound(this.latitude);
  }

  @Override
  public int hashCode() {
    final int prime = (1 << 5) - 1;
    int result = 1;
    result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
    result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
    return result;
  }

  /*
   * Due oggetti di tipo coordinata sono ritenuti uguali se hanno stessa latitudine e
   * longitudine.(non-Javadoc)
   */
  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof ICoordinates) {
      return this.latitude.equals(((ICoordinates) obj).getLatitude())
          && this.longitude.equals(((ICoordinates) obj).getLongitude());
    }
    return false;
  }

  @Override
  public String toString() {
    return "[Latitude = " + latitude.toString() + ", Longitude = " + longitude.toString() + "]";
  }

}
