package it.unibo.oop.smartercities.view.mainpanel;

import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;

import java.awt.BorderLayout;

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
	public void showInformations(IInfoStreetObserver iso) {
		this.currentInfo.setText(iso.toString());
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

}
