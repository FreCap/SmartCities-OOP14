package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.streetObservers.LocationMapsConstructor;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel implements InfoPanelInterface {
	
	private static final long serialVersionUID = 165416518416215L;
	private static final int CUSTOM_SCROLLING = 30;
	
	private JPanel infoPanel;
	private JPanel controlPanel;
	private JScrollPane scrollControlPanel;
	private GridBagConstraints cnst;
	
	private int nOfPluggedObservers;
	
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
		
		nOfPluggedObservers = 0;
	}

	@Override
	public JPanel getPanel() {
		return this;
	}
	
	@Override
	public void notifyPassage(int id) {
		// TODO Auto-generated method stubS
	}
	
	@Override
	public void addStreetObserver(Coordinates c) {
		JLabel controlLabel = new JLabel();
		controlLabel.setBorder(new TitledBorder("Street Observer" + " " + nOfPluggedObservers));
		
		SwingUtilities.invokeLater(() -> {ImageIcon ii = LocationMapsConstructor.getLMC().getMapOf(nOfPluggedObservers, c.getLatitude(), c.getLongitude());
										  controlLabel.setIcon(ii);
										  controlPanel.add(controlLabel, cnst);
										  cnst.gridy++;
										  nOfPluggedObservers++;
		});
		
		newPlug(c);
	}
	
	private void newPlug(Coordinates c) {
		String msg = new StringBuilder().append("A new Street Observer is been plugged.\n It's positions is: ")
										.append("\n   - Latitude:  " + c.getLatitude())
										.append("\n   - Longitude: " + c.getLongitude())
										.toString();
		
		SwingUtilities.invokeLater(() -> {JOptionPane.showOptionDialog(null, 
				 													   msg,
				 													   "Plug info",
				 													   JOptionPane.CLOSED_OPTION, 
				 													   JOptionPane.INFORMATION_MESSAGE, 
				 													   null, null, null);
		});
	}
}
