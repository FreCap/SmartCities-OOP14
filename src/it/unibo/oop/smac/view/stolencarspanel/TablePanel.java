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

/**
 * Classe che implementa un pannello che mostra le informazioni relative ad un
 * osservatore.
 * 
 * @author Federico Bellini
 */
public class TablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140640507027357573L;

	private final StolenCarTableModel stolenCarTableModel;

	private final StolenCarsPanel stolenCarsPanel;

	/**
	 * Costruttore pubblico della classe.
	 * 
	 * @param stolenCarsPanel
	 */
	public TablePanel(StolenCarsPanel stolenCarsPanel) {
		super();
		this.setBorder(new TitledBorder("Dati"));
		this.setLayout(new FlowLayout());

		this.stolenCarsPanel = stolenCarsPanel;
		this.add(new JLabel("informaioni sulle macchine rubate"));
		stolenCarTableModel = new StolenCarTableModel();
		// creo la tabella con i dati
		JTable table = new JTable(stolenCarTableModel);
		table.setEnabled(false);
		this.add(new JScrollPane(table));
	
		Timer timer = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out
					.println("LOOOOOOOL");
					IStolenCarsObserver sco = getStolenCarsPanel()
							.getStolenCarsObserver();
					stolenCarTableModel.updateList(sco.getStolenCarsInfoList());
					System.out
							.println("ASDASDASDA "
									+ sco.getStolenCarsInfoList().size()
									+ " ADSASDASD");
				} catch (IllegalStateException exception) {
					System.out
					.println("ERROREEEEEEEEEEEE");
					exception.printStackTrace();
					// it will be initialized soon
				}
			}
		});
		timer.setRepeats(true);
		timer.setDelay(2000);
		timer.start();
	}

	public StolenCarsPanel getStolenCarsPanel() {
		return stolenCarsPanel;
	}

}
