package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe che implementa un pannello che mostra la tabella delle macchine rubate.
 * 
 */
public class TablePanel extends JPanel {
  /**
   * Logger della classe
   */
  private final static Logger LOGGER = LoggerFactory.getLogger(InsertionPanel.class);

  private static final long serialVersionUID = -7140640507027357573L;

  /**
   * E' il modello dei dati visualizzati nella tabella.
   */
  private final StolenCarTableModel stolenCarTableModel;

  /**
   * parent che contiene i metodi d'accesso (e gestione degli errori) al model.
   */
  private final IStolenCarsPanel stolenCarsPanel;

  /**
   * Costruttore pubblico della classe.
   * 
   * @param stolenCarsPanel
   */
  public TablePanel(final StolenCarsPanel stolenCarsPanel) {
    super();
    // imposto il layout
    this.setBorder(new TitledBorder("Datas"));
    this.setLayout(new FlowLayout());

    // salvo il model per un utilizzo successivo
    this.stolenCarsPanel = stolenCarsPanel;
    this.add(new JLabel("Infos on Stolen Cars"));

    // inizializzo la classe che andrà a gestire i dati nel model
    stolenCarTableModel = new StolenCarTableModel();
    // creo la tabella con i dati
    final JTable table = new JTable(stolenCarTableModel);
    table.setEnabled(false);
    this.add(new JScrollPane(table));

    // imposto un timer che ogni X mi aggiorna i dati nella tabella
    final Timer timer = new Timer(2000, new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent event) {
        try {
          IStolenCarsObserver sco = getStolenCarsPanel().getStolenCarsObserver();
          stolenCarTableModel.updateList(sco.getStolenCarsInfoList());
        } catch (IllegalStateException exception) {
          LOGGER
              .info("street observer model non ancora inizializzato, in pochi istanti verrà inizializzato");
        }
      }
    });
    timer.setRepeats(true);
    timer.setDelay(2000);
    timer.start();
  }

  public IStolenCarsPanel getStolenCarsPanel() {
    return stolenCarsPanel;
  }

}
