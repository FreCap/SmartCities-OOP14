package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.datatypes.ISighting;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Implementazione del JPanel contenente le informazioni principali riguardanti le stolen cars.
 *
 */
public class StolenCarsPanel extends JPanel implements IStolenCarsPanel {

  private static final long serialVersionUID = -3442595458503908271L;

  /**
   * Observer che contiene l'accesso ai dati.
   */
  private IStolenCarsObserver sco;

  /**
   * Primo pannello che gestisce l'inserimento.
   */
  private final InsertionPanel insertionPanel = new InsertionPanel(this);

  /**
   * Secondo pannello che gestisce la tabella.
   */
  private final TablePanel tablePanel = new TablePanel(this);

  /**
   * Terzo pannello che gestisce la tabella.
   */
  private final LastSeenPanel lastSeenPanel = new LastSeenPanel(this);

  /**
   * Costruttore della classe.
   */
  public StolenCarsPanel() {
    super();
    this.setLayout(new BorderLayout());

    // inserisco i 2 panels nel layout
    final JPanel innerPanel = new JPanel(new BorderLayout());
    innerPanel.add(insertionPanel, BorderLayout.NORTH);
    innerPanel.add(lastSeenPanel, BorderLayout.CENTER);

    this.add(tablePanel, BorderLayout.CENTER);
    this.add(innerPanel, BorderLayout.WEST);

  }

  /**
   * Attacca un Observer degli StolenCars.
   * 
   * @param sco
   *          L'{@link IStolenCarsObserver} da attaccare.
   */
  @Override
  public void attachStolenCarsObserver(final IStolenCarsObserver sco) {
    this.sco = sco;
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
   * Restituisce l'Observer.
   * 
   * @return restituisce il {@link IStolenCarsObserver} corrente.
   * @throws IllegalStateException
   *           nel caso in cui non ci sia ancora alcun observer
   */
  @Override
  public IStolenCarsObserver getStolenCarsObserver() throws IllegalStateException {
    if (sco == null) {
      throw new IllegalStateException();
    }
    return sco;
  }

  /**
   * Questo metodo deve segnalare che c'e' stato un passaggio sotto un'osservatore di una macchina
   * rubata.
   * 
   * @param sighting
   *          L'{@link ISighting} dell'avvistamento della macchina rubata.
   */
  @Override
  public void newPassageStolenCar(final ISighting sighting) {
    lastSeenPanel.newPassageStolenCar(sighting);
  }

}
