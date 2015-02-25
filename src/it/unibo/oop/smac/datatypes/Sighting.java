package it.unibo.oop.smac.datatypes;

import it.unibo.oop.smac.database.model.StreetObserverNotValidException;

import java.util.Date;

/**
 * Questa classe implementa l'interfaccia {@link ISighting}, ed ha il compito di raccogliere tutte
 * le informazioni generate dall'osservatore, quali la data dell'avvistamento, la targa dell'auto
 * avvistata e la sua velocita'. Questa classe è costruita utilizzando il pattern Builder.
 * 
 * @author Federico Bellini
 *
 */
public final class Sighting implements ISighting {

  /**
   * Campi privati della classe.
   */
  private final IStreetObserver streetObserver;
  private final Date date;
  private final LicensePlate licensePlate;
  private final Float speed;

  /**
   * Costruttore privato della classe.
   * 
   * @param stObserver
   *          L'osservatore che ha compiuto l'avvistamento.
   * @param d
   *          La data dell'avvistamento.
   * @param plate
   *          La targa dell'auto avvistata.
   * @param s
   *          La velocita' rilevata.
   */
  private Sighting(final IStreetObserver stObserver, final Date d, final LicensePlate plate,
      final Float s) {
    this.streetObserver = stObserver;
    this.date = d;
    this.licensePlate = plate;
    this.speed = s;
  }

  /**
   * Restituisce l'{@link IStreetObserver} che ha generato le informazioni di questo avvistamento.
   * 
   * @return L'{@link IStreetObserver} autore dell'avvistamento.
   */
  @Override
  public IStreetObserver getStreetObserver() throws StreetObserverNotValidException {
    return new StreetObserver(this.streetObserver); // defensive copy
  }

  /**
   * Restituisce la {@link Date} relativa al momento dell'avvistamento.
   * 
   * @return La {@link Date} relativa al momento dell'avvistamento.
   */
  @Override
  public Date getDate() {
    // WARNING: la defensive copy di questo oggetto genera un errore interno alle librerie di
    // database!
    return this.date;
  }

  /**
   * Restituisce la {@link LicensePlate} dell'auto avvistata.
   * 
   * @return La {@link LicensePlate} dell'auto avvistata.
   */
  @Override
  public LicensePlate getLicensePlate() {
    return this.licensePlate;
  }

  /**
   * Restituisce la velocita' dell'auto avvistata.
   * 
   * @return La velocita' dell'auto avvistata.
   */
  @Override
  public Float getSpeed() {
    return this.speed;
  }

  /**
   * Classe statica Builder per la classe Sighting. Questa classe permette di creare un oggetto
   * della classe Sighting, utilizzando il pattern Builder.
   * 
   * @author Federico Bellini
   */
  public static class Builder {
    private IStreetObserver stObserver;
    private Date d;
    private LicensePlate plate;
    private Float s;

    /**
     * Costruisce l'oggetto Sighting con l'IStreetObserver passato come paramentro.
     * 
     * @param streetObserver
     *          L'IStreetObserver da settare.
     * @return Il Builder stesso.
     */
    public Builder streetObserver(final IStreetObserver streetObserver) {
      this.stObserver = streetObserver;
      return this;
    }

    /**
     * Costruisce l'oggetto Sighting con la data' passata come paramentro.
     * 
     * @param date
     *          La data da settare.
     * @return Il Builder stesso.
     */
    public Builder date(final Date date) {
      this.d = new Date(date.getTime());
      return this;
    }

    /**
     * Costruisce l'oggetto Sighting con la LicensePlate passata come paramentro.
     * 
     * @param licensePlate
     *          La LicensePlate' da settare.
     * @return Il Builder stesso.
     */
    public Builder licensePlate(final LicensePlate licensePlate) {
      this.plate = licensePlate;
      return this;
    }

    /**
     * Costruisce l'oggetto Sighting con la velocita' passata come paramentro.
     * 
     * @param speed
     *          La velocita' da settare.
     * @return Il Builder stesso.
     */
    public Builder speed(final Float speed) {
      this.s = speed;
      return this;
    }

    /**
     * Metodo utilizzato per creare un oggetto della classe Sighting con gli attributi appena
     * settati.
     * 
     * @return L'oggetto della classe Sighting appena creato.
     */
    public Sighting build() {
      return new Sighting(this.stObserver, this.d, this.plate, this.s);
    }
  }

}
