package it.unibo.oop.smac.view.gui.mainpanel;

import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatypes.IInfoStreetObserver;
import it.unibo.oop.smac.datatypes.IStreetObserver;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Implementazione del JPanel contenente le informazioni principali riguardanti gli osservatori.
 * Questa classe e' implementata secondo il pattern Observer.
 * 
 * @author Federico Bellini
 */
public class MainPanel extends JPanel implements IMainPanel {

  private static final long serialVersionUID = -5219662861548416920L;

  // Panel contenente tutte le informazioni riguardati lo streetObserver
  // selezionato
  private final InformationsPanel informationsPanel = new InformationsPanel();
  // Panel contenente una successione degli streetObserver
  private final ControlPanel controlPanel = new ControlPanel();

  // Observer degli streetObserver
  private IStreetObserverObserver soo;

  /**
   * Costruttore pubblico della classe.
   */
  public MainPanel() {
    super();
    this.setLayout(new BorderLayout());
    this.add(controlPanel, BorderLayout.CENTER);
    this.add(informationsPanel.getPanel(), BorderLayout.EAST);
  }

  /**
   * Aggiunge un'{@link IStreetObserver} alla successione di osservatori presenti nel relativo
   * panel.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} da aggiungere.
   */
  @Override
  public void addStreetObserver(final IStreetObserver streetObserver) {
    this.controlPanel.addStreetObserver(streetObserver, (t) -> {
      final IInfoStreetObserver info = this.soo.getStreetObserverInfo(t);
      this.informationsPanel.showInformations(info);
    });
    this.plugMsg(streetObserver);
  }

  /**
   * Mostra che un'{@link IStreetObserver} ha rilevato dei dati.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} che ha rilevato dei dati.
   */
  @Override
  public void notifySighting(final IStreetObserver streetObserver) {
    this.controlPanel.notifySighting(streetObserver);
  }

  /**
   * Attacca un Observer degli StreetObserver.
   * 
   * @param streetObserverObserver
   *          L'{@link IStreetObserverObserver} da attaccare.
   */
  @Override
  public void attachStreetObserverObserver(final IStreetObserverObserver streetObserverObserver) {
    this.soo = streetObserverObserver;
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
   * Mostra a video un messaggio con scritto che un nuovo street observer e' stato connesso.
   * 
   * @param streetObserver
   *          L'osservatore appena connesso.
   */
  private void plugMsg(final IStreetObserver streetObserver) {
    final String msg = new StringBuilder()
        .append("New Street Observer is been plugged.\n The positions is: ")
        .append("\n   - Latitude:  " + streetObserver.getLatitude())
        .append("\n   - Longitude: " + streetObserver.getLongitude()).toString();

    JOptionPane.showOptionDialog(null, msg, "Plug info", JOptionPane.CLOSED_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, null, null);
  }

}
