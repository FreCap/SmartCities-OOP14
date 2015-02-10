package it.unibo.oop.smac.database.model;

/**
 * Eccezione lanciata quando non vengono trovati dati nel database.
 * 
 */
public class NotFoundException extends Exception {

  private static final long serialVersionUID = 5160048105729180736L;

  /**
   * Costruttore dell'eccezione.
   * 
   * @param text
   *          Stringa con messaggio da visualizzare.
   */
  public NotFoundException(final String text) {
    super(text);
  }

}
