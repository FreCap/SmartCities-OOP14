package it.unibo.oop.smac.datatypes;

import java.util.Date;

/**
 * Interfaccia per gestire le informazioni della macchina rubata utilizzata all'interno della view.
 */
public interface IStolenCar {

  /**
   * Restituisce la targa della macchina rubata.
   * 
   * @return targa della macchina rubata
   */
  LicensePlate getLicensePlate();

  /**
   * Restituisce la data del furto della macchina.
   * 
   * @return data del furto
   */
  Date getInsertionDate();
}
