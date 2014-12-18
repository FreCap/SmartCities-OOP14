package it.unibo.oop.smartercities.view;

import it.unibo.oop.streetObservers.IStreetObserver;
import it.unibo.oop.streetObservers.LocationMapsConstructor;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel implements InfoPanelInterface {
	
	private static final long serialVersionUID = 165416518416215L;
	private static final int CUSTOM_SCROLLING = 30;
	
	private JPanel infoPanel;
	private JPanel controlPanel;
	private JScrollPane scrollControlPanel;
	private GridBagConstraints cnst;
	
	public InfoPanel() {
		super();
		
		//creation of infoPanel
		infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder("Info"));
		infoPanel.add(new JTextArea("QUI CI METTIAMO TUTTE LE NOSTRE BELLISSIME INFORMAZIONI"));
		
		// creation of controlPanel
		controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder("Controllers"));
		controlPanel.setLayout(new GridBagLayout());
		scrollControlPanel = new JScrollPane(controlPanel);
		scrollControlPanel.getVerticalScrollBar().setUnitIncrement(CUSTOM_SCROLLING);
		// vertical disposition of the element of the controlPanel
		cnst = new GridBagConstraints() ;
		cnst.gridy = 0;
		cnst.insets = new Insets (5 ,5 ,5 ,5);
		
		// creation of the panel
		this.setLayout(new BorderLayout());
		this.add(scrollControlPanel, BorderLayout.CENTER);
		this.add(infoPanel, BorderLayout.EAST);
	}

	@Override
	public JPanel getPanel() {
		return this;
	}
	
	@Override
	public void addStreetObserver(IStreetObserver iSo) {
		JLabel controlLabel = new JLabel();
		controlLabel.setBorder(new TitledBorder("Street Observer" + " " + iSo.getID()));
		controlLabel.setIcon(LocationMapsConstructor.getLocationMapConstructor().getMapOf(iSo.getID(), iSo.getLat(), iSo.getLng()));
		controlPanel.add(controlLabel, cnst);
		cnst.gridy++;
	}

	@Override
	public void notifyPassage(int id) {
		// TODO Auto-generated method stubS
	}
}
