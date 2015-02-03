package it.unibo.oop.smac.view.mainpanel;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 * Questa classe implementa un JScrollPane che deve mostrare lista di {@link StreetObserverPanel}
 * 
 * @author Federico Bellini
 */
public class ControlPanel extends JScrollPane {

	private static final long serialVersionUID = -6541769613294971397L;
	private static final int CUSTOM_SCROLLING = 30;
	private final JPanel panel = new JPanel();
	
	/**
	 * Costruttore della classe.
	 */
	public ControlPanel(){
		super();
		this.setBorder(new TitledBorder("Controllers"));
		this.panel.setLayout(new BoxLayout(this.panel ,BoxLayout.Y_AXIS));
		this.getViewport().add(panel);
		this.getVerticalScrollBar().setUnitIncrement(CUSTOM_SCROLLING);
	}
	
	/**
	 * Aggiunge un nuovo {@link Component} al JPanel.
	 * 
	 * @param comp
	 * 			Il componente da aggiungere.
	 */
	public void addStreetObserver(JPanel streetObserverPanel){
		SwingUtilities.invokeLater(() -> this.panel.add(streetObserverPanel));
	}

}
