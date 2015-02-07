package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

import java.awt.BorderLayout;
import java.nio.channels.IllegalSelectorException;

import javax.swing.JPanel;

//TODO documentazione per fra
public class StolenCarsPanel extends JPanel implements IStolenCarsPanel {

	private static final long serialVersionUID = -3442595458503908271L;

	private IStolenCarsObserver sco;
	
	private final InsertionPanel insertionPanel = new InsertionPanel(this);
	private final TablePanel tablePanel = new TablePanel(this);

	// Observer degli streetObserver
	private IStreetObserverObserver soo;

	// TODO everything
	public StolenCarsPanel() {
		super();
		this.setLayout(new BorderLayout());
		this.add(insertionPanel, BorderLayout.WEST);
		this.add(tablePanel, BorderLayout.CENTER);

	}

	@Override
	public void showInfo(IInfoStolenCar sc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void attachStolenCarsObserver(IStolenCarsObserver sco) {
		this.sco = sco;
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public IStolenCarsObserver getStolenCarsObserver()
			throws IllegalStateException {
		if (sco == null)
			throw new IllegalSelectorException();
		return sco;
	}

}
