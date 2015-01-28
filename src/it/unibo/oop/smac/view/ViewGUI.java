package it.unibo.oop.smac.view;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.controller.IStreetObserverObserver;
import it.unibo.oop.smac.datatype.I.IStreetObserver;
import it.unibo.oop.smac.view.locationpanel.ILocationPanel;
import it.unibo.oop.smac.view.locationpanel.OpenStreetMapPanel;
import it.unibo.oop.smac.view.mainpanel.IMainPanel;
import it.unibo.oop.smac.view.mainpanel.MainPanel;
import it.unibo.oop.smac.view.stolencarspanel.IStolenCarsPanel;
import it.unibo.oop.smac.view.stolencarspanel.StolenCarsPanel;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class ViewGUI extends JFrame implements IView{

	private static final long serialVersionUID = 6107931182231615768L;
	private static final int DEFAULT_WIDTH =
			(Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT =
			Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	private final JTabbedPane tabbedPane = new JTabbedPane();
	private final IMainPanel mainPanel = new MainPanel();
	private final ILocationPanel locationPanel = new OpenStreetMapPanel();
	private final IStolenCarsPanel stolenCarsPanel = new StolenCarsPanel();

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
		this.tabbedPane.addTab(" Informations ", mainPanel.getPanel());
		this.tabbedPane.addTab(" Locations ", locationPanel.getPanel());
		this.tabbedPane.addTab(" Stolen Cars ", stolenCarsPanel.getPanel());
		
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.mainPanel.addStreetObserver(streetObserver);
		this.locationPanel.addStreetObserver(streetObserver);
	}
	
	@Override
	public void newPassage(IStreetObserver streetObserver) {
		this.mainPanel.notifyPassage(streetObserver);
		this.locationPanel.notifyPassage(streetObserver);
	}

	@Override
	public void attachStreetObserverObserver(IStreetObserverObserver soo) {
		this.mainPanel.attachStreetObserverObserver(soo);
	}

	@Override
	public void attachStolenCarsObserver(IStolenCarsObserver sco) {
		this.stolenCarsPanel.attachStolenCarsObserver(sco);		
	}

}
