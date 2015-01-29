package it.unibo.oop.smac.view.mainpanel;

import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private static final int DELAY = 150;
	private static final ImageIcon PASSAGE_ACTIVE_ICON = 
			new ImageIcon(MainPanel.class.getResource("/images/activeButton.png"));
	private static final ImageIcon PASSAGE_INACTIVE_ICON = 
			new ImageIcon(MainPanel.class.getResource("/images/inactiveButton.png"));
	
	private final Color DEFAUTLT_COLOR_BACKGROUND;
	private final JLabel mapLabel;
	private final JLabel passageLabel;
	
	public StreetObserverPanel(IStreetObserver streetObserver, Consumer<IStreetObserver> consumer) {
		super();
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Street Observer  " + streetObserver.getID()));
		this.DEFAUTLT_COLOR_BACKGROUND = this.getBackground();
		
		this.mapLabel = new JLabel();
		ImageIcon ii = OSMStaticMapConstructor.getInstance().getStaticMap(
				streetObserver.getLatitude(),
				streetObserver.getLongitude()
		);
		
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
					setColor(Color.YELLOW);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					setColor(DEFAUTLT_COLOR_BACKGROUND);
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					setColor(Color.GREEN);
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					setColor(Color.YELLOW);
				}
		});
	}
	
	private void setColor(Color c){
		try {
			SwingUtilities.invokeLater(() -> this.setBackground(c));
		} catch (Exception e) {
			// do nothing
		}
	}
	
	public void displayPassage() {
		SwingUtilities.invokeLater(() -> { this.setButtonOn(); });
		try {
			Thread.sleep(DELAY);
		} catch(InterruptedException e) {
		}
		SwingUtilities.invokeLater(() -> { this.setButtonOff(); });
	}
	
	private void setButtonOn() {
		this.passageLabel.setIcon(PASSAGE_ACTIVE_ICON);
	}
	
	private void setButtonOff() {
		this.passageLabel.setIcon(PASSAGE_INACTIVE_ICON);
	}

}
