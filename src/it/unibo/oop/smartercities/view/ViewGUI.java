package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.listeners.IInfoObserverListener;
import it.unibo.oop.smartercities.listeners.IStolenCarsListener;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class ViewGUI extends JFrame implements ViewInterface{

	private static final long serialVersionUID = 6107931182231615768L;
	private static final int DEFAULT_WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	private IInfoObserverListener ioL;
	private IStolenCarsListener scL;
	
	private final JTabbedPane tabbedPane;
	private final InfoPanelInterface infoPanel;
	private final GoogleMapsWebBrowser locationPanel;

	public ViewGUI(){
		
		/*
		//LOOK AND FEEL DEL SISTEMA OPERATIVO OSPITANTE
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		*/
		
		// creation of the frame
		super("SmarterCities");
		this.setLayout(new BorderLayout());
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// creation of tabbedPanel
		tabbedPane = new JTabbedPane();
		infoPanel = new InfoPanel();
		tabbedPane.add(" Informations ", infoPanel.getPanel());
		locationPanel = new GoogleMapsWebBrowser();
		tabbedPane.add(" Locations ", locationPanel);
		
		// join with mainframe
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		//this.add(tabbedPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	@Override
	public void newPassage(Coordinates<Double> c) {
		this.infoPanel.notifyPassage(c);
	}
	
	@Override
	public void addStreetObserver(Coordinates<Double> c) {
		this.infoPanel.addStreetObserver(c);
	}

	@Override
	public void attachInfoSOListener(IInfoObserverListener ioL) {
		this.ioL = ioL;
	}

	@Override
	public void attachStolenCarsListener(IStolenCarsListener scL) {
		this.scL = scL;		
	}

}
