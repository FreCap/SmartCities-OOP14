package it.unibo.oop.smac.datatypes;

import java.util.Optional;

/**
 * Classe che fornisce metodi che restituiscono stringhe contenenti i dati su di uno specifico
 * osservatore. Per l'implementazione della classe e' stato utilizzato il pattern Builder.
 * 
 * @author Federico Bellini
 */
public class InfoStreetObserver implements IInfoStreetObserver {

  /**
   * Campi di tipo Optional<> contenenti le informazioni sull'osservatore.
   */
  private final Optional<IStreetObserver> streetObserver;
  private final Optional<Integer> nOfSightLastHour;
  private final Optional<Integer> nOfSightToday;
  private final Optional<Integer> nOfSightLastWeek;
  private final Optional<Integer> nOfSightLaatMonth;
  private final Optional<Integer> totalNOfSight;
  private final Optional<Float> averageSpeedToday;
  private final Optional<Float> averageSpeedLastWeek;
  private final Optional<Float> averageSpeedLastMonth;
  private final Optional<Float> maxSpeedToday;
  private final Optional<Float> maxCarRateToday;

  /**
   * Costruttore privato della classe che prende tutti i campi presenti in essa.
   */
  private InfoStreetObserver(final IStreetObserver streetObserver, final Integer nOfSightLastHour,
      final Integer nOfSightToday, final Integer nOfSightLastWeek, final Integer nOfSightLaatMonth,
      final Integer totalNOfSight, final Float averageSpeedToday, final Float averageSpeedLastWeek,
      final Float averageSpeedLastMonth, final Float maxSpeedToday, final Float maxCarRateToday) {

    super();
    this.streetObserver = Optional.ofNullable(streetObserver);
    this.nOfSightLastHour = Optional.ofNullable(nOfSightLastHour);
    this.nOfSightToday = Optional.ofNullable(nOfSightToday);
    this.nOfSightLastWeek = Optional.ofNullable(nOfSightLastWeek);
    this.nOfSightLaatMonth = Optional.ofNullable(nOfSightLaatMonth);
    this.totalNOfSight = Optional.ofNullable(totalNOfSight);
    this.averageSpeedToday = Optional.ofNullable(averageSpeedToday);
    this.averageSpeedLastWeek = Optional.ofNullable(averageSpeedLastWeek);
    this.averageSpeedLastMonth = Optional.ofNullable(averageSpeedLastMonth);
    this.maxSpeedToday = Optional.ofNullable(maxSpeedToday);
    this.maxCarRateToday = Optional.ofNullable(maxCarRateToday);
  }

  @Override
  public Optional<ICoordinates> getStreetObserverLocation() {
    if (this.streetObserver.isPresent()) {
      return Optional.ofNullable(this.streetObserver.get().getCoordinates());
    } else {
      return Optional.empty();
    }
  }

  @Override
  public Optional<String> getStreetObserverID() {
    if (this.streetObserver.isPresent()) {
      return Optional.ofNullable(this.streetObserver.get().getId());
    } else {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Integer> getnOfSightLastHour() {
    return this.nOfSightLastHour;
  }

  @Override
  public Optional<Integer> getnOfSightToday() {
    return this.nOfSightToday;
  }

  @Override
  public Optional<Integer> getnOfSightLastWeek() {
    return this.nOfSightLastWeek;
  }

  @Override
  public Optional<Integer> getnOfSightLastMonth() {
    return this.nOfSightLaatMonth;
  }

  @Override
  public Optional<Integer> getTotalNOfSight() {
    return this.totalNOfSight;
  }

  @Override
  public Optional<Float> getAverageSpeedToday() {
    return this.averageSpeedToday;
  }

  @Override
  public Optional<Float> getAverageSpeedLastWeek() {
    return this.averageSpeedLastWeek;
  }

  @Override
  public Optional<Float> getAverageSpeedLastMonth() {
    return this.averageSpeedLastMonth;
  }

  @Override
  public Optional<Float> getMaxSpeedToday() {
    return this.maxSpeedToday;
  }

  @Override
  public Optional<Float> getMaxCarRateToday() {
    return this.maxCarRateToday;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append(" streetObserverLocation=" + this.getStreetObserverLocation())
        .append(" streetObserverID=" + this.getStreetObserverID())
        .append(" nOfSightLastHour=" + this.getnOfSightLastHour())
        .append(" nOfSightToday=" + this.getnOfSightToday())
        .append(" nOfSightLastWeek=" + this.getnOfSightLastWeek())
        .append(" nOfSightLaatMonth=" + this.getnOfSightLastMonth())
        .append(" totalNOfSight=" + this.getTotalNOfSight())
        .append(" averageSpeedToday=" + this.getAverageSpeedToday())
        .append(" averageSpeedLastWeek=" + this.getAverageSpeedLastWeek())
        .append(" averageSpeedLastMonth=" + this.getAverageSpeedLastMonth())
        .append(" maxSpeedToday=" + this.getMaxSpeedToday())
        .append(" maxCarRateToday=" + this.getMaxCarRateToday()).toString();
  }

  @Override
  public int hashCode() {
    final int prime = (1 << 5) - 1;
    int result = 1;
    result = prime * result
        + ((averageSpeedLastMonth == null) ? 0 : averageSpeedLastMonth.hashCode());
    result = prime * result
        + ((averageSpeedLastWeek == null) ? 0 : averageSpeedLastWeek.hashCode());
    result = prime * result + ((averageSpeedToday == null) ? 0 : averageSpeedToday.hashCode());
    result = prime * result + ((maxCarRateToday == null) ? 0 : maxCarRateToday.hashCode());
    result = prime * result + ((maxSpeedToday == null) ? 0 : maxSpeedToday.hashCode());
    result = prime * result + ((nOfSightLaatMonth == null) ? 0 : nOfSightLaatMonth.hashCode());
    result = prime * result + ((nOfSightLastHour == null) ? 0 : nOfSightLastHour.hashCode());
    result = prime * result + ((nOfSightLastWeek == null) ? 0 : nOfSightLastWeek.hashCode());
    result = prime * result + ((nOfSightToday == null) ? 0 : nOfSightToday.hashCode());
    result = prime * result + ((streetObserver == null) ? 0 : streetObserver.hashCode());
    result = prime * result + ((totalNOfSight == null) ? 0 : totalNOfSight.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || obj instanceof InfoStreetObserver) {
      return false;
    }

    final InfoStreetObserver other = (InfoStreetObserver) obj;
    if (!getAverageSpeedLastMonth().equals(other.getAverageSpeedLastMonth())
        || !getAverageSpeedLastWeek().equals(other.getAverageSpeedLastWeek())
        || !getAverageSpeedToday().equals(other.getAverageSpeedToday())) {
      return false;
    }

    if (!getMaxCarRateToday().equals(other.getMaxCarRateToday())
        || !getMaxSpeedToday().equals(other.getMaxSpeedToday())) {
      return false;
    }

    if (!getnOfSightLastHour().equals(other.getnOfSightLastHour())
        || !getnOfSightLastMonth().equals(other.getnOfSightLastMonth())
        || !getnOfSightLastWeek().equals(other.getnOfSightLastWeek())
        || !getnOfSightToday().equals(other.getnOfSightToday())
        || !getTotalNOfSight().equals(other.getTotalNOfSight())) {
      return false;
    }

    if (streetObserver == null || other.streetObserver != null) {
      return false;
    } else if (!streetObserver.equals(other.streetObserver)) {
      return false;
    }

    return true;
  }

  /**
   * Classe statica innestata Builder della classe InfoStreetObserver. Questa classe svolge il
   * compito di creare un'oggetto della classe InfoStreetObserver.
   * 
   * @author Federico Bellini
   */
  public static class Builder {
    private IStreetObserver streetObserver;
    private Integer nOfSightLastHour;
    private Integer nOfSightToday;
    private Integer nOfSightLastWeek;
    private Integer nOfSightLaatMonth;
    private Integer totalNOfSight;
    private Float averageSpeedToday;
    private Float averageSpeedLastWeek;
    private Float averageSpeedLastMonth;
    private Float maxSpeedToday;
    private Float maxCarRateToday;

    /**
     * Imposta l'IStreetObserver che ha compiuto l'avvistamento.
     * 
     * @param streetObserver
     *          L'IStreetObserver che ha compiuto l'avvistamento.
     * @return Il builder stesso.
     */
    public Builder streetObserver(final IStreetObserver streetObserver) {
      this.streetObserver = streetObserver;
      return this;
    }

    /**
     * Imposta il numero di avvitamenti fatti nell'ultima ora.
     * 
     * @param nOfSightLastHour
     *          Il numero di avvitamenti fatti nell'ultima ora.
     * @return Il builder stesso.
     */
    public Builder nOfSightLastHour(final int nOfSightLastHour) {
      this.nOfSightLastHour = nOfSightLastHour;
      return this;
    }

    /**
     * Imposta il numero di avvitamenti fatti oggi.
     * 
     * @param nOfSightToday
     *          Imposta il numero di avvitamenti fatti oggi.
     * @return Il builder stesso.
     */
    public Builder nOfSightToday(final int nOfSightToday) {
      this.nOfSightToday = nOfSightToday;
      return this;
    }

    /**
     * Imposta il numero di avvitamenti fatti nell'ultima settimana.
     * 
     * @param nOfSightLastWeek
     *          Imposta il numero di avvitamenti fatti nell'ultima settimana.
     * @return Il builder stesso.
     */
    public Builder nOfSightLastWeek(final int nOfSightLastWeek) {
      this.nOfSightLastWeek = nOfSightLastWeek;
      return this;
    }

    /**
     * Imposta il numero di avvitamenti fatti nell'ultimo mese.
     * 
     * @param nOfSightLaatMonth
     *          Il numero di avvitamenti fatti nell'ultimo mese.
     * @return Il builder stesso.
     */
    public Builder nOfSightLastMonth(final int nOfSightLaatMonth) {
      this.nOfSightLaatMonth = nOfSightLaatMonth;
      return this;
    }

    /**
     * Imposta il numero totale di avvistamenti.
     * 
     * @param totalNOfSight
     *          Il numero totale di avvistamenti
     * @return Il builder stesso.
     */
    public Builder totalNOfSight(final int totalNOfSight) {
      this.totalNOfSight = totalNOfSight;
      return this;
    }

    /**
     * Imposta la velocita' media registrata oggi.
     * 
     * @param averageSpeedToday
     *          La velocita' media registrata oggi.
     * @return Il builder stesso.
     */
    public Builder averageSpeedToday(final float averageSpeedToday) {
      this.averageSpeedToday = averageSpeedToday;
      return this;
    }

    /**
     * Imposta la velocita' media registrata nell'ultima settimana.
     * 
     * @param averageSpeedLastWeek
     *          La velocita' media registrata nell'ultima settimana.
     * @return Il builder stesso.
     */
    public Builder averageSpeedLastWeek(final float averageSpeedLastWeek) {
      this.averageSpeedLastWeek = averageSpeedLastWeek;
      return this;
    }

    /**
     * Imposta la velocita' media registrata nell'ultimo mese.
     * 
     * @param averageSpeedLastMonth
     *          La velocita' media registrata nell'ultimo mese.
     * @return Il builder stesso.
     */
    public Builder averageSpeedLastMonth(final float averageSpeedLastMonth) {
      this.averageSpeedLastMonth = averageSpeedLastMonth;
      return this;
    }

    /**
     * Imposta la velocita' massima registrata oggi.
     * 
     * @param maxSpeedToday
     *          La velocita' massima registrata oggi.
     * @return Il builder stesso.
     */
    public Builder maxSpeedToday(final float maxSpeedToday) {
      this.maxSpeedToday = maxSpeedToday;
      return this;
    }

    /**
     * Imposta l'ora di maggior affluenza di mezzi.
     * 
     * @param maxCarRateToday
     *          L'ora in cui si è registrata la maggior affluenza di mezzi.
     * @return Il builder stesso.
     */
    public Builder maxCarRateToday(final float maxCarRateToday) {
      this.maxCarRateToday = maxCarRateToday;
      return this;
    }

    /**
     * Costruisce l'oggetto della classe InfoStreetObserver con i valori impostati.
     * 
     * @return L'oggetto della classe InfoStreetObserver appena costruito.
     */
    public InfoStreetObserver build() {
      return new InfoStreetObserver(this.streetObserver, this.nOfSightLastHour, this.nOfSightToday,
          this.nOfSightLastWeek, this.nOfSightLaatMonth, this.totalNOfSight,
          this.averageSpeedToday, this.averageSpeedLastWeek, this.averageSpeedLastMonth,
          this.maxSpeedToday, this.maxCarRateToday);
    }

  }

}
