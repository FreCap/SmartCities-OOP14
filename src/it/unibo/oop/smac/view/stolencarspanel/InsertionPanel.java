package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatype.LicensePlate;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Classe che implementa un pannello che permette di inserire le le targhe di
 * nuove macchine rubate
 * 
 */
public class InsertionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3093237633576185609L;

	/**
	 * parent che contiene i metodi d'accesso (e gestione degli errori) al model
	 */
	private final StolenCarsPanel stolenCarsPanel;

	// campi da visualizzare nella form
	private final JLabel labelTarga = new JLabel("Targa:");
	private final JTextField fieldTarga = new JTextField("AB918AD");
	private final JButton buttonAggiungi = new JButton("Aggiungi");

	/**
	 * Costruttore pubblico della classe.
	 */
	public InsertionPanel(StolenCarsPanel stolenCarsPanel) {
		super();

		// salvo il pannello parent
		this.stolenCarsPanel = stolenCarsPanel;

		// imposto il layout
		GroupLayout layout = new GroupLayout(this);
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
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(fieldTarga)
								.addComponent(buttonAggiungi)));
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(labelTarga)
								.addComponent(fieldTarga))
				.addComponent(buttonAggiungi));

		// listener che permmette l'inserzione di una nuova macchina rubata al
		// press del tasto aggiungi
		buttonAggiungi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getStolenCarsPanel().getStolenCarsObserver().addNewStolenCar(
						new LicensePlate(fieldTarga.getText()));
			}
		});
	}

	public StolenCarsPanel getStolenCarsPanel() {
		return stolenCarsPanel;
	}
}
