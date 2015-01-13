package it.unibo.oop.smartercities.view;

import it.unibo.oop.smartercities.datatype.Coordinates;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	public StreetObserverPanel(Coordinates<Double> c, int id) {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Street Observer" + " " + id));
		
		this.mapLabel = new JLabel();
		ImageIcon ii = LocationMapsConstructor.getLMC().getMapOf(id, c.getLatitude(), c.getLongitude());
		this.mapLabel.setIcon(ii);
		
		this.passageLabel = new JLabel();
		this.setButtonOff();
		
		this.add(mapLabel);
		this.add(passageLabel, BorderLayout.EAST);
		
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(c + " is clicked ");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
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
