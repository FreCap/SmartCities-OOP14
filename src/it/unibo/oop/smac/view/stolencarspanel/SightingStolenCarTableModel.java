package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatypes.ISighting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

/**
 * Modello che gestisce la visualizzazione dei dati contenuti nel DB delle stolen cars.
 */
public class SightingStolenCarTableModel extends AbstractTableModel {

  private static final long serialVersionUID = 6581624902840366368L;

  /**
   * List delle righe che devono essere visualizzate.
   */
  private final List<ISighting> sightings;

  /**
   * Colonne della tabella.
   */
  private static final String[] COLUMN_NAMES = { "Id", "Lic. Plate", "Seen at" };

  /**
   * Costruttore che inizializza una tabella vuota.
   */
  public SightingStolenCarTableModel() {
    sightings = new ArrayList<ISighting>();
  }

  /**
   * Funzione che permette l'aggiunta di un nuovo oggetto alla lista.
   * 
   * @param sightings
   *          nuova lista di {@link ISighting}
   */
  public void insertSighting(final ISighting sighting) {
    this.sightings.add(sighting);
    this.fireTableDataChanged();
  }

  /**
   * Metodo che permette la restituzione del numero di righe da visualizzare basandosi sul model di
   * dati custom su cui si basa la tabella.
   * 
   * @return int Numero di righe
   */
  @Override
  public int getRowCount() {
    return sightings.size();
  }

  /**
   * Metodo che restituisce il numero di colonne della tabella.
   * 
   * @return int Numero di colonne
   */
  @Override
  public int getColumnCount() {
    return COLUMN_NAMES.length;
  }

  /**
   * Restituisce il nome della colonna.
   * 
   * @param colonna
   *          di cui si richiede il nome
   * @return una stringa che contiene il nome di default della <code>colonna</code>
   */
  @Override
  public String getColumnName(final int col) {
    return COLUMN_NAMES[col];
  }

  /**
   * Metodo che impedisce la modifica di qualsiasi riga nella tabella.
   */
  @Override
  public boolean isCellEditable(final int row, final int col) {
    return false;
  }

  /**
   * Restituisc il valore della casella all'index <code>col</code> e <code>row</code>.
   *
   * @param row
   *          riga del valore richiesto
   * @param column
   *          colonna del valore richiesto
   * @return l'oggetto corrispondente ad una determinata riga-colonna
   */
  @Override
  public Object getValueAt(final int row, final int col) {
    switch (col) {
      case 0:
        return row + 1;
      case 1:
        final SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd HH:mm",
            Locale.getDefault(Locale.Category.FORMAT));
        final Date current = this.getStolenCars().get(row).getDate();
        return dt.format(current);
      case 2:
        return this.getStolenCars().get(row).getLicensePlate();
      default:
        return null;
    }
  }

  /**
   * Getter per la lista delle righe da visualizzare.
   */
  private List<ISighting> getStolenCars() {
    return sightings;
  }

}
