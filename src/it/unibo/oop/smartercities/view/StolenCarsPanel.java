package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.datatype.I.IStolenCar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StolenCarsPanel extends JPanel implements IStolenCarsPanel{

	private static final long serialVersionUID = -3442595458503908271L;
	//TODO everything
	public StolenCarsPanel() {
		super();
		this.add(new JLabel("informaioni sulle macchine rubate"));
	}
	
	@Override
	public void showInfo(IStolenCar sc) {
		// TODO Auto-generated method stub
		
	}

}
