package it.unibo.oop.smartercities.view.mainpanel;

import java.awt.BorderLayout;

import it.unibo.oop.smartercities.datatype.InfoStreetObserver;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class InformationsPanel extends JPanel implements IInformationsPanel {

	private static final long serialVersionUID = -3058034776743041502L;
	private final JLabel currentInfo;
	
	public InformationsPanel(){
		super();
		this.setBorder(new TitledBorder("Info"));
		this.setLayout(new BorderLayout());
		this.currentInfo = new JLabel("Informazioniii");
		this.add(this.currentInfo);
	}

	@Override
	public void showInformations(InfoStreetObserver iso) {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel getPanel() {
		return this;
	}

}
