package it.unibo.oop.smartercities.view;

import it.unibo.oop.googleImages.LocationMapsConstructor;
import it.unibo.oop.smartercities.datatype.Coordinates;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
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
	private GridBagConstraints gbc;
	
	private Map<Coordinates<Double>, StreetObserverPanel> observersMap = new HashMap<>();
	
	private int nOfPluggedObservers;
	
	public InfoPanel() {
		super();
		
		//creation of infoPanel
		infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder("Info"));
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(new JTextArea("QUI CI METTIAMO TUTTE LE NOSTRE BELLISSIME INFORMAZIONI"));
		
		// creation of controlPanel
		controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder("Controllers"));
		controlPanel.setLayout(new GridBagLayout());
		scrollControlPanel = new JScrollPane(controlPanel);
		scrollControlPanel.getVerticalScrollBar().setUnitIncrement(CUSTOM_SCROLLING);
		// vertical disposition of the element of the controlPanel
		gbc = new GridBagConstraints() ;
		gbc.gridy = 0;
		gbc.insets = new Insets (5 ,5 ,5 ,5);
		
		// creation of the panel
		this.setLayout(new BorderLayout());
		this.add(scrollControlPanel, BorderLayout.CENTER);
		this.add(infoPanel, BorderLayout.EAST);
		
		nOfPluggedObservers = 0;
	}
	
	@Override
	public void notifyPassage(Coordinates<Double> c) {
		if(observersMap.containsKey(c)) {
			observersMap.get(c).displayPassage();
			
		}
		else {
			//TODO
		}
	}
	
	@Override
	public void addStreetObserver(Coordinates<Double> c) {
		
		SwingUtilities.invokeLater(() -> {
					ImageIcon ii = LocationMapsConstructor.getLMC().getMapOf(nOfPluggedObservers, c.getLatitude(), c.getLongitude());
					StreetObserverPanel p = new StreetObserverPanel(ii, nOfPluggedObservers);
					controlPanel.add(p, gbc);
					gbc.gridy++;
					nOfPluggedObservers++;
					this.observersMap.put(c, p);
		});
		
		newPlug(c);
	}
	
	private void newPlug(Coordinates<Double> c) {
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

	@Override
	public JPanel getPanel() {
		return this;
	}
}
