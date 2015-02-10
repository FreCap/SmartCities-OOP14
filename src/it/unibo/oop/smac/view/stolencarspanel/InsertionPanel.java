package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatypes.StolenCar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.InvalidAttributeValueException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Classe che implementa un pannello che permette di inserire le le targhe di nuove macchine rubate.
 * 
 */
public class InsertionPanel extends JPanel {
  /**
   * Serial Version UID della classe
   */
  private static final long serialVersionUID = -3093237633576185609L;

  /**
   * parent che contiene i metodi d'accesso (e gestione degli errori) al model.
   */
  private final StolenCarsPanel stolenCarsPanel;

  // campi da visualizzare nella form
  private final JLabel labelTarga = new JLabel("Targa:");
  private final JTextField fieldTarga = new JTextField("AB918AD");
  private final JButton buttonAggiungi = new JButton("Aggiungi");

  /**
   * Costruttore pubblico della classe.
   */
  public InsertionPanel(final StolenCarsPanel stolenCarsPanel) {
    super();

    // salvo il pannello parent
    this.stolenCarsPanel = stolenCarsPanel;

    // imposto il layout
    final GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    this.setPreferredSize(new Dimension(300, 200));
    this.setBorder(new TitledBorder("Inserisci"));

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    fieldTarga.setSize(new Dimension(200, 50));

    // imposto il posizionamento degli elementi nel layout
    labelTarga.setLabelFor(fieldTarga);
    layout.setHorizontalGroup(layout
        .createSequentialGroup()
        .addComponent(labelTarga)
        .addGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(fieldTarga)
                .addComponent(buttonAggiungi)));
    layout.setVerticalGroup(layout
        .createSequentialGroup()
        .addGroup(
            layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelTarga)
                .addComponent(fieldTarga)).addComponent(buttonAggiungi));

    // listener che permmette l'inserzione di una nuova macchina rubata al
    // press del tasto aggiungi
    buttonAggiungi.addActionListener(new ActionListener() {

      private void invalidLicensePlateMsg(final String licensePlate) {
        final String msg = new StringBuilder()
            .append("Error inserting a new stolen car license plate: ")
            .append("\n " + licensePlate + " is not valid.").append("\n AA000AA is a valid one.")
            .toString();

        JOptionPane.showOptionDialog(null, msg, "Insertion Erro", JOptionPane.CLOSED_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, null, null);
      }

      @Override
      public void actionPerformed(ActionEvent event) {
        final String licensePlate = fieldTarga.getText();
        try {
          final StolenCar stolenCar = new StolenCar.Builder().licensePlate(fieldTarga.getText())
              .insertionDateNow().build();

          getStolenCarsPanel().getStolenCarsObserver().addNewStolenCar(stolenCar);
        } catch (InvalidAttributeValueException e1) {
          invalidLicensePlateMsg(licensePlate);
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
  }

  public StolenCarsPanel getStolenCarsPanel() {
    return stolenCarsPanel;
  }
}
