package it.unibo.oop.smac.simulator.client;

import java.util.List;

/**
 * POJO del modello dati contenuto nel JSON che descrive un Track, ossia un percorso.
 */
public class Track {

  /**
   * Lista dei punti che compongono il percorso.
   */
  private List<TrackCommand> trackCommands;

  /**
   * Restituisce la lista dei punti da cui è composto il percorso.
   * 
   * @return lista dei TrackCommand
   */
  public List<TrackCommand> getTrackCommands() {
    return trackCommands;
  }

  /**
   * Imposta la lista dei punti da cui è composto il percorso.
   */
  public void setTrackCommands(final List<TrackCommand> trackCommands) {
    this.trackCommands = trackCommands;
  }
}