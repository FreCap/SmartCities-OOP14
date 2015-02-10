package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 * Classe che implementa un pannello che mostra una tabella contenente la lista di tutte le macchine
 * rubate conosciute. Questa classe e' implementata secondo il pattern Observer.
 * 
 * @author Francesco Capponi
 */
public class TablePanel extends JPanel {

  private static final long serialVersionUID = -7140640507027357573L;

  /**
   * Arco di tempo che intercorre tra ogni aggiornamento della tabella contenente le auto rubate.
   */
  private static final int DELAY = 1000;

  /**
   * Observer delle auto rubate.
   */
  private IStolenCarsObserver stolenCarsObserver;

  /**
   * Costruttore pubblico della classe.
   */
  public TablePanel() {
    super();
    this.setBorder(new TitledBorder("Stolen Cars Database"));
    this.setLayout(new FlowLayout());

    this.add(new JLabel("Informations on Stolen Cars"));

    // creo la tabella con i dati
    final StolenCarTable stolenCarTable = new StolenCarTable();
    final JTable table = new JTable(stolenCarTable);
    table.setEnabled(false);
    table.setMaximumSize(new Dimension(10, 10));
    JScrollPane sp = new JScrollPane(table);
    sp.setMaximumSize(new Dimension(10, 10));
    this.add(sp);

    // imposto un timer che aggiorna i dati nella tabella ad intervalli di tempo stabiliti
    final Timer timer = new Timer(DELAY, (e) -> stolenCarTable.updateList(stolenCarsObserver
        .getStolenCarsInfoList()));
    timer.setRepeats(true);
    timer.setDelay(DELAY);
    timer.start();
  }

  /**
   * Attacca l'Observer degli StolenCars.
   * 
   * @param sco
   *          L'{@link IStolenCarsObserver} da attaccare.
   */
  public void attachStolenCarsObserver(final IStolenCarsObserver sco) {
    this.stolenCarsObserver = sco;
  }

}
