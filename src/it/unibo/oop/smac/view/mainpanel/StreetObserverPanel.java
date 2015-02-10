package it.unibo.oop.smac.view.mainpanel;

import it.unibo.oop.smac.datatypes.IStreetObserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 * Questa classe implementa un JPanel contenente una static map che mostra la posizione
 * dell'osservatore, e un icona verde/rossa a seconda se sta avvenendo un passaggio al di sotto
 * dell'osservatore.
 * 
 * @author Federico Bellini
 */
public class StreetObserverPanel extends JPanel {

  private static final long serialVersionUID = 984911465198419L;

  // icone di passaggio
  private static final ImageIcon PASSAGE_ACTIVE_ICON = new ImageIcon(
      MainPanel.class.getResource("/images/activeButton.png"));
  private static final ImageIcon PASSAGE_INACTIVE_ICON = new ImageIcon(
      MainPanel.class.getResource("/images/inactiveButton.png"));

  // tempo in millisecondi in cui l'icona di passaggio "accesa"
  private static final int DELAY = 150;

  // colore di sfondo di default
  private final Color DEFAUTLT_COLOR_BACKGROUND;

  // label contenente l'icona che segnala il passaggio rilevato
  // dall'osservatore
  private final JLabel passageLabel;

  /**
   * Costruttore pubblico della classe. Costruisce un JPanel contenente una mappa relativa alla
   * posizione dello StreetObserver passato, al quale attacca il consumer(Observer) passato come
   * secondo argomento.
   * 
   * @param streetObserver
   *          Lo streetObserver soggetto della mappa.
   * @param consumer
   *          L'Observer da attaccargli.
   */
  public StreetObserverPanel(final IStreetObserver streetObserver,
      final Consumer<IStreetObserver> consumer) {
    super();
    this.setLayout(new BorderLayout());
    this.setBorder(new TitledBorder("Street Observer  " + streetObserver.getId()));
    this.DEFAUTLT_COLOR_BACKGROUND = this.getBackground();

    this.passageLabel = new JLabel();
    this.setButtonOff();
    this.add(passageLabel, BorderLayout.EAST);

    final JLabel mapLabel = new JLabel();
    mapLabel.setIcon(OSMStaticMapConstructor.getInstance().getStaticMap(
        streetObserver.getLatitude(), streetObserver.getLongitude()));
    this.add(mapLabel, BorderLayout.CENTER);

    this.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(final MouseEvent arg0) {
        consumer.accept(streetObserver);
      }

      @Override
      public void mouseEntered(final MouseEvent arg0) {
        setColor(Color.YELLOW);
      }

      @Override
      public void mouseExited(final MouseEvent arg0) {
        setColor(DEFAUTLT_COLOR_BACKGROUND);
      }

      @Override
      public void mousePressed(final MouseEvent arg0) {
        setColor(Color.GREEN);
      }

      @Override
      public void mouseReleased(final MouseEvent arg0) {
        setColor(Color.YELLOW);
      }
    });
  }

  /**
   * Setta lo sfondo di questo oggetto con il colore passato come argomento.
   * 
   * @param c
   *          Il Color da settare come sfondo.
   */
  private void setColor(final Color c) {
    try {
      SwingUtilities.invokeLater(() -> this.setBackground(c));
    } catch (Exception e) {
      // do nothing
    }
  }

  /**
   * Mostra un avvenuto passaggio rilevato dall'osservatore cambiando per un breve tempo l'icona a
   * fianco della static map.
   */
  public void displayPassage() {
    SwingUtilities.invokeLater(() -> {
      this.setButtonOn();
    });
    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
    }
    SwingUtilities.invokeLater(() -> {
      this.setButtonOff();
    });
  }

  /**
   * Setta l'icona verde.
   */
  private void setButtonOn() {
    this.passageLabel.setIcon(PASSAGE_ACTIVE_ICON);
  }

  /**
   * Setta l'icona rossa.
   */
  private void setButtonOff() {
    this.passageLabel.setIcon(PASSAGE_INACTIVE_ICON);
  }

}
