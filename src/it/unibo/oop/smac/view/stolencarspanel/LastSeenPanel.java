package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatypes.ISighting;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 * Classe che implementa un pannello che mostra la tabella delle macchine rubate.
 * 
 */
public class LastSeenPanel extends JPanel {

  private static final long serialVersionUID = -7140640507027357573L;

  /**
   * E' il modello dei dati visualizzati nella tabella.
   */
  private final SightingStolenCarTableModel sightingStolenCarTableModel;

  /**
   * parent che contiene i metodi d'accesso (e gestione degli errori) al model.
   */
  private final IStolenCarsPanel stolenCarsPanel;

  /**
   * Costruttore pubblico della classe.
   * 
   * @param stolenCarsPanel
   *          Pannello padre
   */
  public LastSeenPanel(final StolenCarsPanel stolenCarsPanel) {
    super();
    // imposto il layout
    this.setBorder(new TitledBorder("Sightings"));
    this.setLayout(new FlowLayout());

    // salvo il model per un utilizzo successivo
    this.stolenCarsPanel = stolenCarsPanel;
    // this.add(new JLabel("informaioni sulle macchine rubate"));

    // inizializzo la classe che andrà a gestire i dati nel model
    sightingStolenCarTableModel = new SightingStolenCarTableModel();
    // creo la tabella con i dati
    final JTable table = new JTable(sightingStolenCarTableModel);
    table.setEnabled(false);
    table.setPreferredSize(new Dimension(350, 400));
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    final JScrollPane jScrollPane = new JScrollPane(table);
    jScrollPane.setViewportView(table);

    this.add(jScrollPane);

  }

  /**
   * Restituisce il pannello padre.
   * 
   * @return pannello padre
   */
  public IStolenCarsPanel getStolenCarsPanel() {
    return stolenCarsPanel;
  }

  /**
   * Questo metodo deve segnalare che c'e' stato un passaggio sotto un'osservatore di una macchina
   * rubata.
   * 
   * @param sighting
   *          L'{@link ISighting} dell'avvistamento della macchina rubata.
   */
  public void newPassageStolenCar(final ISighting sighting) {
    sightingStolenCarTableModel.insertSighting(sighting);
  }

}
