package it.unibo.oop.smartercities.view.locationpanel;

import javax.swing.JPanel;

import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

public class OpenStreetMapPanel extends JPanel implements ILocationPanel{

	private static final long serialVersionUID = -2763079963863167233L;

	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

}
