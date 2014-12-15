package it.unibo.oop.smartercities;

import it.unibo.oop.googleMapsWeb.GoogleMapsWebBrowser;
import it.unibo.oop.streetObservers.IStreetObserver;
import it.unibo.oop.streetObservers.LocationMapsConstructor;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SCViewGUI implements SCViewInterface{

	private static final int DEFAULT_WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width/3)*2;
	private static final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().width/2;
	
	private SCViewObserverInterface viewObserver;
	
	private JFrame mainFrame;
	private JTabbedPane tabbedPane;
	private JPanel panelFirstPage;
	private JScrollPane scrollControlPanel;
	private JPanel controlPanel;
	private JPanel infoPanel;
	
	private GridBagConstraints cnst;

	public SCViewGUI() {
		
		// creation of mainFrame
		mainFrame = new JFrame("Smarter Cities");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		
		// creation of infoPanel
		infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder("Info"));
		infoPanel.add(new JButton("tanti bei bottoncini qui"));
		infoPanel.add(new JTextArea("qualche info quà e la :)"));
		
		// creation of controlPanel
		controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder("Controllers"));
		controlPanel.setLayout(new GridBagLayout());
		scrollControlPanel = new JScrollPane(controlPanel);
		// vertical disposition of the element of the controlPanel
		cnst = new GridBagConstraints () ;
		cnst.gridy = 0;
		cnst.insets = new Insets (5 ,5 ,5 ,5);
		
		// creation of the panel of the first page
		panelFirstPage = new JPanel(new BorderLayout());
		panelFirstPage.add(scrollControlPanel, BorderLayout.CENTER);
		panelFirstPage.add(infoPanel, BorderLayout.EAST);
		
		// creation of tabbedPanel
		tabbedPane = new JTabbedPane();
		tabbedPane.add("first panel", panelFirstPage);
		tabbedPane.add("second panel", new GoogleMapsWebBrowser());
		
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
		String msg = new StringBuilder().append("There is a new request for plugging a new street observer. \nIt's location is: ")
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
	public void newPassage(int id) {
		// TODO
	}

	@Override
	public void addStreetObserver(IStreetObserver aso) {
		JLabel controlLabel = new JLabel();
		controlLabel.setBorder(new TitledBorder("Street Observer" + " " + aso.getID()));
		controlLabel.setIcon(LocationMapsConstructor.getLocationMapConstructor().getMapOf(aso.getID(), aso.getLat(), aso.getLng()));
		controlPanel.add(controlLabel, cnst);
		cnst.gridy++;
		mainFrame.validate();
		mainFrame.repaint();
		
	}
}
