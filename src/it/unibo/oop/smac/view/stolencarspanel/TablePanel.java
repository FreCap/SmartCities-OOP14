package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;

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
    this.setBorder(new TitledBorder("Datas"));
    this.setLayout(new FlowLayout());

    this.add(new JLabel("Informations on Stolen Cars"));

    // inizializzo la classe che andrà a gestire i dati del model
    final StolenCarTable stolenCarTableModel = new StolenCarTable();
    // creo la tabella con i dati
    final JTable table = new JTable(stolenCarTableModel);
    table.setEnabled(false);
    this.add(new JScrollPane(table));
    // imposto un timer che aggiorna i dati nella tabella ad intervalli di tempo stabiliti
    final Timer timer = new Timer(DELAY, (e) -> stolenCarTableModel.updateList(stolenCarsObserver
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
