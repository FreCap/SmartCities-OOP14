package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StolenCarsPanel extends JPanel implements IStolenCarsPanel{

	private static final long serialVersionUID = -3442595458503908271L;
	
	private IStolenCarsObserver sco;
	
	//TODO everything
	public StolenCarsPanel() {
		super();
		this.add(new JLabel("informaioni sulle macchine rubate"));
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

}
