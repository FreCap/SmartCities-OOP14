package it.unibo.oop.smac.view.mainpanel;

import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/// PATTERN OBSERVER!
public class MainPanel extends JPanel implements IMainPanel {
	
	private static final long serialVersionUID = -5219662861548416920L;
	private final InformationsPanel informationsPanel = new InformationsPanel();
	private final ControlPanel controlPanel = new ControlPanel();
	
	private IStreetObserverObserver soo;
	
	// TODO qual'è l utilità di questa mappa nella GUI? boh..
	private final Map<IStreetObserver, StreetObserverPanel> observersMap = new HashMap<>();
	
	public MainPanel() {
		super();
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.CENTER);
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
		StreetObserverPanel p = new StreetObserverPanel(
				streetObserver,
				(t) -> {
						IInfoStreetObserver info = this.soo.getStreetObserverInfo(t);
						this.informationsPanel.showInformations(info);
		});
		
		this.plugMsg(streetObserver);
		
		SwingUtilities.invokeLater(() -> {	
			this.controlPanel.addStreetObserver(p);
			this.observersMap.put(streetObserver, p);
		});
	}
	
	private void plugMsg(IStreetObserver streetObserver) {
		String msg = new StringBuilder()
				.append("New Street Observer is been plugged.\n The positions is: ")
				.append("\n   - Latitude:  " + streetObserver.getLatitude())
				.append("\n   - Longitude: " + streetObserver.getLongitude())
				.toString();
		
		SwingUtilities.invokeLater(() -> {
				JOptionPane.showOptionDialog(
							null, 
				 			msg,
				 			"Plug info",
				 			JOptionPane.CLOSED_OPTION,
				 			JOptionPane.INFORMATION_MESSAGE,
				 			null,
				 			null,
				 			null
				);
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
