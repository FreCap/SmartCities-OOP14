package it.unibo.oop.smartercities.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class StreetObserverPanel extends JPanel{
	
	private static final long serialVersionUID = 984911465198419L;
	private static final String DEFAULT_PATH = "/images/";
	private static final ImageIcon PASSAGE_ACTIVE_ICON = new ImageIcon(InfoPanel.class.getResource(DEFAULT_PATH + "activeButton.png"));
	private static final ImageIcon PASSAGE_INACTIVE_ICON = new ImageIcon(InfoPanel.class.getResource(DEFAULT_PATH + "inactiveButton.png"));
	private static final int DELAY = 150;
	
	private final JLabel mapLabel;
	private final JLabel passageLabel;
	
	public StreetObserverPanel(ImageIcon ii, int n) {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Street Observer" + " " + n));
		
		mapLabel = new JLabel();
		mapLabel.setIcon(ii);
		
		passageLabel = new JLabel();
		setButtonOff();
		
		this.add(mapLabel);
		this.add(passageLabel, BorderLayout.EAST);
	}
	
	private void setButtonOn() {
		this.passageLabel.setIcon(PASSAGE_ACTIVE_ICON);
	}
	
	private void setButtonOff() {
		this.passageLabel.setIcon(PASSAGE_INACTIVE_ICON);
	}
	
	public void displayPassage() {
		SwingUtilities.invokeLater(() -> { setButtonOn(); });
		
		try {
			Thread.sleep(DELAY);
		}
		catch(InterruptedException e) {
		}
		
		SwingUtilities.invokeLater(() -> { setButtonOff(); });
	}
}
