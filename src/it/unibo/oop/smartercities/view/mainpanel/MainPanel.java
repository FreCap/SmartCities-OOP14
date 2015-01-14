package it.unibo.oop.smartercities.view.mainpanel;

import it.unibo.oop.smartercities.datatype.Coordinates;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class MainPanel extends JPanel implements IMainPanel {
	
	private static final long serialVersionUID = -5219662861548416920L;
	private static final int CUSTOM_SCROLLING = 30;
	
	// TODO mettici interfacce!
	private final JPanel informationsPanel;
	private final JPanel controlPanel;
	private final JScrollPane scrollControlPanel;
	private final GridBagConstraints gbc;
	
	private final Map<Coordinates<Double>, StreetObserverPanel> observersMap = new HashMap<>();
	
	private int nOfPluggedObservers;
	
	public MainPanel() {
		super();
		
		//creation of infoPanel
		informationsPanel = new JPanel();
		informationsPanel.setBorder(new TitledBorder("Info"));
		informationsPanel.setLayout(new BorderLayout());
		informationsPanel.add(new JLabel("QUI CI METTIAMO TUTTE LE NOSTRE BELLISSIME INFORMAZIONI"));
		
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
		this.add(informationsPanel, BorderLayout.EAST);
		
		nOfPluggedObservers = 0;
	}
	
	@Override
	public void notifyPassage(Coordinates<Double> c) {
		if(observersMap.containsKey(c)) {
			observersMap.get(c).displayPassage();
		} else {
			// TODO in this case throw an exception
			//throw new Exception();
		}
	}
	
	@Override
	public void addStreetObserver(Coordinates<Double> c) {
		
		SwingUtilities.invokeLater(() -> {
					StreetObserverPanel p = new StreetObserverPanel(c, ++nOfPluggedObservers);
					this.controlPanel.add(p, gbc);
					this.gbc.gridy++;
					this.observersMap.put(c, p);
		});
		
		this.newPlug(c);
	}
	
	private void newPlug(Coordinates<Double> c) {
		String msg = new StringBuilder().append("New Street Observer is been plugged.\n The positions is: ")
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
