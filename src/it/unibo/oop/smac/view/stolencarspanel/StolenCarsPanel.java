package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;

import java.awt.BorderLayout;
import java.nio.channels.IllegalSelectorException;

import javax.swing.JPanel;

/**
 * Implementazione del JPanel contenente le informazioni principali riguardanti
 * le stolen cars
 *
 */
public class StolenCarsPanel extends JPanel implements IStolenCarsPanel {

	private static final long serialVersionUID = -3442595458503908271L;

	/**
	 * Observer che contiene l'accesso ai dati
	 */
	private IStolenCarsObserver sco;

	/**
	 * Primo pannello che gestisce l'inserimento
	 */
	private final InsertionPanel insertionPanel = new InsertionPanel(this);

	/**
	 * Secondo pannello che gestisce la tabella
	 */
	private final TablePanel tablePanel = new TablePanel(this);

	/**
	 * Costruttore della classe
	 */
	public StolenCarsPanel() {
		super();
		this.setLayout(new BorderLayout());

		// inserisco i 2 panels nel layout
		this.add(insertionPanel, BorderLayout.WEST);
		this.add(tablePanel, BorderLayout.CENTER);

	}

	/**
	 * Attacca un Observer degli StolenCars.
	 * 
	 * @param sco
	 *            L'{@link IStolenCarsObserver} da attaccare.
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
	 * Restituisce l'Observer
	 * 
	 * @return restituisce il {@link IStolenCarsObserver} corrente.
	 * @throws IllegalStateException
	 *             nel caso in cui non ci sia ancora alcun observer
	 */
	@Override
	public IStolenCarsObserver getStolenCarsObserver() throws IllegalStateException {
		if (sco == null) {
			throw new IllegalSelectorException();
		}
		return sco;
	}

}
