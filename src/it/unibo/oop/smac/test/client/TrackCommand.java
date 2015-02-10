package it.unibo.oop.smac.test.client;

import it.unibo.oop.smac.datatype.Coordinates;

/**
 * POJO del modello dati contenuto nel JSON che descrive un azione del track.
 */
public class TrackCommand {

  /**
   * Tempo per cui la macchina deve dormire prima di generare il prossimo sighting.
   */
  private Integer sleep;

  /**
   * Coordinate del punto in cui la macchina genererà il passaggio.
   */
  private Coordinates coordinate;

  /**
   * Restituisce il time di sleep della macchina.
   * 
   * @return tempo di sleep
   */
  public Integer getSleep() {
    return sleep;
  }

  /**
   * Imposta il time di sleep della macchina.
   */
  public void setSleep(final Integer sleep) {
    this.sleep = sleep;
  }

  /**
   * Restituisce le coordinate del sighting.
   * 
   * @return tempo di sleep
   */
  public Coordinates getCoordinate() {
    return coordinate;
  }

  /**
   * Imposta le coordinate del sighting.
   */
  public void setCoordinate(final Coordinates coordinate) {
    this.coordinate = coordinate;
  }

}