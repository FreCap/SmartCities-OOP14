package it.unibo.oop.smac.view.mainpanel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ControlPanel extends JPanel implements IControlPanel {

	private static final long serialVersionUID = -6541769613294971397L;
	private final GridBagConstraints gbc = new GridBagConstraints();;
	
	public ControlPanel(){
		super();
		this.setBorder(new TitledBorder("Controllers"));
		this.setLayout(new GridBagLayout());
		
		this.gbc.gridy = 0;
		this.gbc.insets = new Insets (5 ,5 ,5 ,5);
	}
	
	@Override
	public void addStreetObserver(Component comp){
		this.add(comp, this.gbc);
		this.gbc.gridy++;
		
	}
	
	@Override
	public JPanel getPanel() {
		return this;
	}

}
