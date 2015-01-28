package it.unibo.oop.smac.view.mainpanel;

import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class StreetObserverPanel extends JPanel{
	
	private static final long serialVersionUID = 984911465198419L;
	private static final String DEFAULT_PATH = "/images/";
	private static final ImageIcon PASSAGE_ACTIVE_ICON = new ImageIcon(MainPanel.class.getResource(DEFAULT_PATH + "activeButton.png"));
	private static final ImageIcon PASSAGE_INACTIVE_ICON = new ImageIcon(MainPanel.class.getResource(DEFAULT_PATH + "inactiveButton.png"));
	private static final int DELAY = 150;
	
	private final JLabel mapLabel;
	private final JLabel passageLabel;
	
	public StreetObserverPanel(IStreetObserver streetObserver, Consumer<IStreetObserver> consumer) {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Street Observer" ));
		
		this.mapLabel = new JLabel();
		ImageIcon ii = null; // TODO!!!!
		
		this.mapLabel.setIcon(ii);
		
		this.passageLabel = new JLabel();
		this.setButtonOff();
		
		this.add(mapLabel);
		this.add(passageLabel, BorderLayout.EAST);
		
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consumer.accept(streetObserver);
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
	
	public void displayPassage() {
		SwingUtilities.invokeLater(() -> { setButtonOn(); });
		
		try {
			Thread.sleep(DELAY);
		}
		catch(InterruptedException e) {
		}
		
		SwingUtilities.invokeLater(() -> { setButtonOff(); });
	}
	
	private void setButtonOn() {
		this.passageLabel.setIcon(PASSAGE_ACTIVE_ICON);
	}
	
	private void setButtonOff() {
		this.passageLabel.setIcon(PASSAGE_INACTIVE_ICON);
	}

}
