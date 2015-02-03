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

/**
 * Implementazione dell'interfaccia IView con utilizzo di GUI.
 * Questa classe e' implementata secondo il pattern Observer(metodi attachObservers)
 * ed anche secondo il pattern Facade, facendo da "facciata" per i vari pannelli di cui
 * si compone la GUI.
 * 
 * @author Federico Bellini
 */
public class ViewGUI extends JFrame implements IView{

	private static final long serialVersionUID = 6107931182231615768L;
	
	// dimensioni iniziali della finestra
	private static final int DEFAULT_WIDTH =
			(Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT =
			Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	// Pannello principale dell'applicazione contenente le informazioni sugli osservatori.
	private final IMainPanel mainPanel = new MainPanel();
	// Pannello contenente una mappa che descrive la posizione degli StreetObserver 
	private final ILocationPanel locationPanel = new OpenStreetMapPanel();
	// Pannello contenente le informazioni sulle auto rubate.
	private final IStolenCarsPanel stolenCarsPanel = new StolenCarsPanel();

	/**
	 * Costruttore pubblico della GUI.
	 */
	public ViewGUI(){
		
		// creation of the frame
		super("SmarterCities");
		this.setLayout(new BorderLayout());
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// creation of tabbedPanel
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab(" Informations ", mainPanel.getPanel());
		tabbedPane.addTab(" Locations ", locationPanel.getPanel());
		tabbedPane.addTab(" Stolen Cars ", stolenCarsPanel.getPanel());
		
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	/**
	 * Questo metodo mostra all'utente che un nuovo {@link IStreetObserver}
	 * e' appena stato connesso.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} appena connesso.
	 */
	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.mainPanel.addStreetObserver(streetObserver);
		this.locationPanel.addStreetObserver(streetObserver);
	}
	
	/**
	 * Questo metodo segnala all'utente che c'e' stato un passaggio sotto un'osservatore.
	 * 
	 * @param streetObserver
	 * 			L'{@link IStreetObserver} che ha compiuto l'avvistamento.
	 */
	@Override
	public void newPassage(IStreetObserver streetObserver) {
		this.mainPanel.notifyPassage(streetObserver);
		this.locationPanel.notifyPassage(streetObserver);
	}

	/**
	 * Questo metodo deve attaccare l'Observer passato come parametro agli StreetObserver
	 * presenti. In questo modo e' l'Observer preso come paramentro che gestisce il 
	 * comportamento dell'applicazione quando vengono fatte delle richieste
	 * su degli StreetObserver da parte della View.
	 * 
	 * @param soo
	 * 			L'{@link IStreetObserverObserver} da attaccare agli StreetObserver presenti
	 * 			nella View.
	 */
	@Override
	public void attachStreetObserverObserver(IStreetObserverObserver soo) {
		this.mainPanel.attachStreetObserverObserver(soo);
	}

	/**
	 * Questo metodo attacca l'Observer passato come parametro alle StolenCars
	 * presenti. In questo modo e' l'Observer preso come paramentro che gestisce il
	 * comportamento dell'applicazione quando vengono fatte delle richieste su delle
	 * StolenCars da parte della View.
	 * 
	 * @param sco
	 * 			L'{@link IStolenCarsObserver} da attaccare alle StolenCars presenti
	 * 			nella View.
	 */
	@Override
	public void attachStolenCarsObserver(IStolenCarsObserver sco) {
		this.stolenCarsPanel.attachStolenCarsObserver(sco);		
	}

}
