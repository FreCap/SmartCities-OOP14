package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.datatype.LicensePlate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private final StolenCarsPanel stolenCarsPanel;

	private final JButton buttonAggiungi = new JButton("Aggiungi");
	private final JTextField fieldTarga = new JTextField("AB918AD");

	/**
	 * Costruttore pubblico della classe.
	 */
	public InsertionPanel(StolenCarsPanel stolenCarsPanel) {
		super(new FlowLayout());
		this.stolenCarsPanel = stolenCarsPanel;

		this.setBorder(new TitledBorder("Inserisci"));
		this.setPreferredSize(new Dimension(300, 200));

		fieldTarga.setSize(new Dimension(200, 50));
		JLabel label = new JLabel("Targa:");
		label.setLabelFor(fieldTarga);
		this.add(label);
		this.add(fieldTarga);

		this.add(new JLabel());
		this.add(buttonAggiungi);
		buttonAggiungi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stolenCarsPanel.getStolenCarsObserver().addNewStolenCar(
						new LicensePlate(fieldTarga.getText()));
			}
		});
	}

}
