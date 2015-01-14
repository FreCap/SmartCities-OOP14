package it.unibo.oop.smartercities.view.mainpanel;

import it.unibo.oop.smartercities.controller.IStreetObserverObserver;
import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

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
	
	private IStreetObserverObserver soo;
	
	private final Map<IStreetObserver, StreetObserverPanel> observersMap = new HashMap<>();
	
	public MainPanel() {
		super();
		
		scrollControlPanel = new JScrollPane(controlPanel.getPanel());
		scrollControlPanel.getVerticalScrollBar().setUnitIncrement(CUSTOM_SCROLLING);
		
		this.setLayout(new BorderLayout());
		this.add(scrollControlPanel, BorderLayout.CENTER);
		this.add(informationsPanel.getPanel(), BorderLayout.EAST);
	}
	
	@Override
	public void notifyPassage(IStreetObserver streetObserver) {
		if(observersMap.containsKey(streetObserver)) {
			observersMap.get(streetObserver).displayPassage();
		} else {
			// TODO in this case throw an exception
			//throw new Exception();
		}
	}
	
	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		
		SwingUtilities.invokeLater(() -> {
					StreetObserverPanel p = new StreetObserverPanel(streetObserver,
																	this.observersMap.size(),
																	(t) -> {
																		IInfoStreetObserver info = this.soo.getStreetObserverInfo(t);
																		this.informationsPanel.showInformations(info);
																	});
					this.controlPanel.addStreetObserver(p);
					this.observersMap.put(streetObserver, p);
		});
		
		this.newPlugMsg(streetObserver);
	}
	
	private void newPlugMsg(IStreetObserver streetObserver) {
		String msg = new StringBuilder().append("New Street Observer is been plugged.\n The positions is: ")
										.append("\n   - Latitude:  " + streetObserver.getCoordinates().getLatitude())
										.append("\n   - Longitude: " + streetObserver.getCoordinates().getLongitude())
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
	public void attachStreetObserverObserver(IStreetObserverObserver soo) {
		this.soo = soo;
	}
	
	@Override
	public JPanel getPanel() {
		return this;
	}

}
