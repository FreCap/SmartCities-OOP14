package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.control.ControllerInterface;
import it.unibo.oop.smartercities.datatype.Coordinates;

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
		
		//LOOK AND FEEL DEL SISTEMA OPERATIVO OSPITANTE
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
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
	public void addStreetObserver(Coordinates c) {
		this.infoPanel.addStreetObserver(c);
	}
	
	@Override
	public void newPassage(Coordinates c) {
		this.infoPanel.notifyPassage(c);
	}
}
