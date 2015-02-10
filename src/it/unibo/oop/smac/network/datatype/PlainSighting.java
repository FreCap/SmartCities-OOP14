package it.unibo.oop.smac.network.datatype;

import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.Sighting;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe di scambio rete client-server, prima di essere tradotto in Sighting. Utilizzata poiché non
 * è possibile spedire attraverso la rete un messaggio contentente referenze ad database, quale
 * sarebbe un semplice {@link Sighting}. Implementa la classe Serializable per poter essere
 * serializzata e spedita via rete
 */
public class PlainSighting implements Serializable {

  private static final long serialVersionUID = -6098237635297318104L;

  /**
   * Coordinate dell'Observer che spedisce il Sighting.
   */
  private Coordinates coordinates;

  /**
   * Data-ora dell'avvistamento.
   */
  private Date date;

  /**
   * Targa della macchina avvistata.
   */
  private String licensePlate;

  /**
   * Velocità della macchina avvistata.
   */
  private Float speed;

  /**
   * Restituisce la data dell'avvistamento.
   * 
   * @return data d'avvistamento
   */
  public Date getDate() {
    return date;
  }

  /**
   * Imposta la data dell'avvistamento.
   */
  public void setDate(final Date date) {
    this.date = date;
  }

  /**
   * Restituisce la targa della macchina avvistata.
   * 
   * @return targa avvistata
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  /**
   * Imposta la targa della macchina avvistata.
   */
  public void setLicensePlate(final String licensePlate) {
    this.licensePlate = licensePlate;
  }

  /**
   * Restituisce la velocità della macchina avvistata
   * 
   * @return velocità della macchina
   */
  public Float getSpeed() {
    return speed;
  }

  /**
   * Imposta la velocità della macchina avvistata.
   */
  public void setSpeed(final Float speed) {
    this.speed = speed;
  }

  /**
   * Restituisce le coordinate dello street observer che effettua l'avvistamento.
   * 
   * @return coordinate dello street observer
   */
  public Coordinates getCoordinates() {
    return coordinates;
  }

  /**
   * Imposta le coordinate dello street observer che effettua l'avvistamento.
   */
  public void setCoordinates(final Coordinates coordinates) {
    this.coordinates = coordinates;
  }

}