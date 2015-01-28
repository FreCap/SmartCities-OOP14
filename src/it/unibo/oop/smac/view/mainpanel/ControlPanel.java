package it.unibo.oop.smac.view.mainpanel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Questa classe implementa un JPanel contenente una lista di {@link StreetObserverPanel}
 * per poter essere visualizzati.
 * 
 * @author Federico Bellini
 */
public class ControlPanel extends JPanel {

	private static final long serialVersionUID = -6541769613294971397L;
	private final GridBagConstraints gbc = new GridBagConstraints();;
	
	/**
	 * Costruttore della classe.
	 */
	public ControlPanel(){
		super();
		this.setBorder(new TitledBorder("Controllers"));
		this.setLayout(new GridBagLayout());
		
		this.gbc.gridy = 0;
		this.gbc.insets = new Insets (5 ,5 ,5 ,5);
	}
	
	/**
	 * Aggiunge un nuovo {@link Component} al JPanel.
	 * 
	 * @param comp
	 * 			Il componente da aggiungere.
	 */
	public void addStreetObserver(Component comp){
		this.add(comp, this.gbc);
		this.gbc.gridy++;
	}
	
	/**
	 * Restituisce il JPanel.
	 * 
	 * @return
	 * 		Restituisce il JPanel.
	 */
	public JPanel getPanel() {
		return this;
	}

}
