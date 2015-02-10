package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.SightingRow;
import it.unibo.oop.smac.database.StreetObserverRow;
import it.unibo.oop.smac.datatypes.IInfoStreetObserver;
import it.unibo.oop.smac.datatypes.ISighting;
import it.unibo.oop.smac.datatypes.IStreetObserver;
import it.unibo.oop.smac.model.IStreetObserverModel;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;

/**
 * Implementazione dell'interfaccia del Model dell'applicazione. Questa classe astratta si occupa di
 * aggiungere {@link IStreetObserver} e {@link ISighting} nel database, lasciando il compito di
 * ricercare, prelevare ed organizzare i dati quando richiesti alle classi che la estendono.
 * 
 * @author Federico Bellini
 */
public abstract class StreetObserverModelDatabase implements IStreetObserverModel {

  /**
   * Inserisce nel database un nuovo {@link IStreetObserver}. Nel caso in cui ci fossero dei
   * problemi nell'inserimento nel database di questo osservatore, l'applicazione termina.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} da inserire.
   */
  @Override
  public synchronized void addNewStreetObserver(final IStreetObserver streetObserver) {
    if (!this.checkStreetObserverExists(streetObserver)) {
      final StreetObserverRow streetObserverRow = new StreetObserverRow(streetObserver);
      final Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
      try {
        streetObserverDao.createIfNotExists(streetObserverRow);
      } catch (SQLException e) {
        System.err.println("The creation on database of the new SteetObserver " + streetObserver
            + " is failed!");
        System.exit(1);
      }
      try {
        System.out.println("Reading datas just added: "
            + streetObserverDao.queryForId(streetObserver.getId()));
      } catch (SQLException e) {
        // do nothing
      }
    }
  }

  /**
   * Inserisce nel database un nuovo {@link ISighting}.
   * 
   * @param sighting
   *          L'{@link ISighting} da inserire.
   * @throws StreetObserverNotValidException
   *           se viene passato un sighting con streetObserver errato
   */
  @Override
  public void addSighting(final ISighting sighting) throws StreetObserverNotValidException {
    // controllo se l'osservatore è presente, altrimenti lo aggiungo
    if (sighting.getStreetObserver() == null) {
      throw new StreetObserverNotValidException();
    }
    if (!this.checkStreetObserverExists(sighting.getStreetObserver())) {
      this.addNewStreetObserver(sighting.getStreetObserver());
    }
    try {
      final StreetObserverRow streetObserverRow = this.getStreetObserverRow(sighting
          .getStreetObserver());
      final SightingRow sightingRow = new SightingRow(sighting, streetObserverRow);
      streetObserverRow.addSightings(sightingRow);
    } catch (NotFoundException e) {
      // questo non può accadere!
      e.printStackTrace();
    }
  }

  /**
   * Questo metodo controlla se l'{@link IStreetObserver} passato come argomento sia gia' presente
   * nel Model dell'appicazione.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} di cui verificare la presenza.
   * @return True se esiste, false altrimenti.
   */
  @Override
  public boolean checkStreetObserverExists(IStreetObserver streetObserver) {
    final Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
    try {
      return streetObserverDao.queryForId(streetObserver.getId()) == null;
    } catch (SQLException e) {
      return false;
    }
  }

  /**
   * Questo metodo restituisce lo {@link StreetObserverRow} corrispondente all'
   * {@link IStreetObserver} passato come argomento. Se si verificano dei problemi di lettura nel
   * database, l'applicazione termina.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} da cercare.
   * @return Un oggetto {@link StreetObserverRow} corrispondente all' {@link IStreetObserver}
   *         passato.
   * 
   * @throws NotFoundException
   *           Eccezione lanciata nel caso in cui l'{@link IStreetObserver} di cui si vogliono
   *           recuperare le informazioni non fosse presente nel Model dell'applicazione.
   */
  protected StreetObserverRow getStreetObserverRow(final IStreetObserver streetObserver)
      throws NotFoundException {
    if (this.checkStreetObserverExists(streetObserver)) {
      final Dao<StreetObserverRow, String> streetObserverDao = this.getStreetObserverDao();
      try {
        return streetObserverDao.queryForId(streetObserver.getId());
      } catch (SQLException e) {
        System.err.println("Problems occured in database");
        System.exit(1);
        return null;
      }
    } else {
      throw new NotFoundException("The observer is not present");
    }
  }

  /**
   * Questo metodo deve raccogliere i dati su di un {@link IStreetObserver}, e li deve organizzare
   * restituendo al chiamante un {@link IInfoStreetObserver} contenente le informazioni
   * sull'osservstore richiesto.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} di cui si vogliono recuperare le informazioni.
   * @return Un oggetto del tipo {@link IInfoStreetObserver} contenente le informazioni sull'
   *         {@link IStreetObserver} richiesto.
   * 
   * @throws NotFoundException
   *           Eccezione lanciata nel caso in cui l'{@link IStreetObserver} di cui si vogliono
   *           recuperare le informazioni non fosse presente nel Model dell'applicazione.
   */
  @Override
  public abstract IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver)
      throws IllegalArgumentException, NotFoundException;

  /**
   * Restituisce il Dao<> degli streetObserver della classe Connection. Nel caso in cui la classe
   * Connection lanciasse un eccezione di tipo SQLException, l'intera applicazione viene fatta
   * terminare, poiche' significa che qualche operazione nella creazione o nella gestione del
   * database non ha avuto successo, e quindi il programma deve terminare.
   * 
   * @return Il Dao<> richiesto.
   */
  private Dao<StreetObserverRow, String> getStreetObserverDao() {
    try {
      return Connection.getInstance().getStreetObserverDao();
    } catch (SQLException e) {
      System.err.println(e);
      System.exit(1);
      return null;
    }
  }

}
