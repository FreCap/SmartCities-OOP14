package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.control.SCViewObserverInterface;
import it.unibo.oop.streetObservers.IStreetObserver;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class SCViewGUI implements SCViewInterface{

	private static final int DEFAULT_WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	private SCViewObserverInterface viewObserver;
	
	private final JFrame mainFrame;
	private final JTabbedPane tabbedPane;
	
	private final InfoPanelInterface infoPanel;
	private final GoogleMapsWebBrowser locationPanel;

	public SCViewGUI() {
		
		// creation of mainFrame
		mainFrame = new JFrame("Smarter Cities");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		
		// creation of tabbedPanel
		tabbedPane = new JTabbedPane();
		infoPanel = new InfoPanel();
		tabbedPane.add(" Informations ", infoPanel.getPanel());
		locationPanel = new GoogleMapsWebBrowser();
		tabbedPane.add(" Locations ", locationPanel);
		
		// join with mainframe
		mainFrame.add(tabbedPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
	
	@Override
	public void attachViewObserver(final SCViewObserverInterface viewObserver) {
		this.viewObserver = viewObserver;
	}

	@Override
	public boolean pluginRequest(Double latitude, Double longitude) {
		String msg = new StringBuilder().append("There is a new request to plug a new observer. \nIt's location is: ")
										.append("\n   - Latitude:  " + latitude)
										.append("\n   - Longitude: " + longitude)
										.append("\nDo you want to plug it?")
										.toString();
		
		Integer choice = JOptionPane.showOptionDialog(null, 
													  msg,
													  "New plugging request",
													  JOptionPane.YES_NO_OPTION, 
													  JOptionPane.QUESTION_MESSAGE, 
													  null, null, null);
		
		if(choice.equals(JOptionPane.YES_OPTION)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addStreetObserver(IStreetObserver iSo) {
		this.infoPanel.addStreetObserver(iSo);
	}
	
	@Override
	public void newPassage(int id) {
		// TODO
	}
}
