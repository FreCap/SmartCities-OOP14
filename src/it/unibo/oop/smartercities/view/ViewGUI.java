package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.listeners.IInfoObserverListener;
import it.unibo.oop.smartercities.listeners.IStolenCarsListener;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class ViewGUI extends JFrame implements IViewGUI{

	private static final long serialVersionUID = 6107931182231615768L;
	private static final int DEFAULT_WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	private IInfoObserverListener ioL;
	private IStolenCarsListener scL;
	
	private final JTabbedPane tabbedPane = new JTabbedPane();
	private final IMainPanel mainPanel = new MainPanel();
	//TODO make interfaces!!!
	private final GoogleMapsWebBrowser locationPanel = new GoogleMapsWebBrowser();
	private final StolenCarsPanel stolenCarsPanel = new StolenCarsPanel();

	public ViewGUI(){
		
		/*
		//LOOK AND FEEL DEL SISTEMA OPERATIVO OSPITANTE
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
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
		this.tabbedPane.add(" Informations ", mainPanel.getPanel());
		this.tabbedPane.add(" Locations ", locationPanel);
		this.tabbedPane.addTab(" Stolen Cars ", stolenCarsPanel);
		
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		//this.add(tabbedPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	@Override
	public void newPassage(Coordinates<Double> c) {
		this.mainPanel.notifyPassage(c);
	}
	
	@Override
	public void addStreetObserver(Coordinates<Double> c) {
		this.mainPanel.addStreetObserver(c);
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
