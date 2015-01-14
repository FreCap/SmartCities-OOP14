package it.unibo.oop.smartercities.view.mainpanel;

import it.unibo.oop.smartercities.datatype.Coordinates;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class MainPanel extends JPanel implements IMainPanel {
	
	private static final long serialVersionUID = -5219662861548416920L;
	private static final int CUSTOM_SCROLLING = 30;
	
	private final IInformationsPanel informationsPanel = new InformationsPanel();
	private final IControlPanel controlPanel = new ControlPanel();
	private final JScrollPane scrollControlPanel;
	
	private final Map<Coordinates<Double>, StreetObserverPanel> observersMap = new HashMap<>();
	
	public MainPanel() {
		super();
		
		scrollControlPanel = new JScrollPane(controlPanel.getPanel());
		scrollControlPanel.getVerticalScrollBar().setUnitIncrement(CUSTOM_SCROLLING);
		
		this.setLayout(new BorderLayout());
		this.add(scrollControlPanel, BorderLayout.CENTER);
		this.add(informationsPanel.getPanel(), BorderLayout.EAST);
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
					StreetObserverPanel p = new StreetObserverPanel(c, this.observersMap.size());
					this.controlPanel.addStreetObserver(p);
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
