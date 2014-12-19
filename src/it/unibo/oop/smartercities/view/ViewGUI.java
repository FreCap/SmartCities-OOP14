package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.control.ControllerInterface;
import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.IStreetObserver;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class ViewGUI implements ViewInterface{

	private static final int DEFAULT_WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	private ControllerInterface viewObserver;
	
	private final JFrame mainFrame;
	private final JTabbedPane tabbedPane;
	
	private final InfoPanelInterface infoPanel;
	private final GoogleMapsWebBrowser locationPanel;

	public ViewGUI() {
		
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
	public void attachViewObserver(final ControllerInterface viewObserver) {
		this.viewObserver = viewObserver;
	}

	@Override
	public void newPlug(Coordinates c) {
		String msg = new StringBuilder().append("A new Street Observer is been plugged.\n It's positions is: ")
										.append("\n   - Latitude:  " + c.getLatitude())
										.append("\n   - Longitude: " + c.getLongitude())
										.toString();
		
		// TODO su differente thread
		JOptionPane.showOptionDialog(null, 
									 msg,
									 "Plug info",
									 JOptionPane.CLOSED_OPTION, 
									 JOptionPane.INFORMATION_MESSAGE, 
									 null, null, null);
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
