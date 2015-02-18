package it.unibo.oop.smac.view.GUI.stolencars.panel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.datatypes.ISighting;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Implementazione del JPanel contenente le informazioni principali riguardanti le stolen cars.
 * Questa classe e' implementata utilizzando il pattern Observer.
 * 
 * @author Francesco Capponi
 */
public class StolenCarsPanel extends JPanel implements IStolenCarsPanel {

  private static final long serialVersionUID = -3442595458503908271L;

  /**
   * Primo pannello che gestisce l'inserimento delle auto rubate nel database.
   */
  private final InsertionPanel insertionPanel = new InsertionPanel();

  /**
   * Pannello che gestisce una tabella che mostra la lista di auto rubate.
   */
  private final TablePanel tablePanel = new TablePanel();

  /**
   * Pannello che mostra i dati sulle auto rubate quando esse vengono avvistate.
   */
  private final StolenCarSightPanel lastSeenPanel = new StolenCarSightPanel();

  /**
   * Costruttore pubblico della classe.
   */
  public StolenCarsPanel() {
    super();
    this.setLayout(new BorderLayout());

    final JPanel innerPanel = new JPanel(new BorderLayout());
    innerPanel.add(this.insertionPanel, BorderLayout.NORTH);
    innerPanel.add(this.lastSeenPanel, BorderLayout.CENTER);

    this.add(this.tablePanel, BorderLayout.CENTER);
    this.add(innerPanel, BorderLayout.WEST);
  }

  /**
   * Attacca l'Observer degli StolenCars.
   * 
   * @param stolenCarsObserver
   *          L'{@link IStolenCarsObserver} da attaccare.
   */
  @Override
  public void attachStolenCarsObserver(final IStolenCarsObserver stolenCarsObserver) {
    this.tablePanel.attachStolenCarsObserver(stolenCarsObserver);
    this.insertionPanel.attachStolenCarsObserver(stolenCarsObserver);
  }

  /**
   * Restituisce il JPanel.
   * 
   * @return Il JPanel.
   */
  @Override
  public JPanel getPanel() {
    return this;
  }

  /**
   * Questo metodo deve segnalare che c'e' stato un passaggio sotto un'osservatore di una macchina
   * rubata.
   * 
   * @param sighting
   *          L'{@link ISighting} dell'avvistamento della macchina rubata.
   */
  @Override
  public void newSightingStolenCar(final ISighting sighting) {
    lastSeenPanel.newSightingStolenCar(sighting);
  }

}
