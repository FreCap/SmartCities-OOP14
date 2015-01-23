package it.unibo.oop.smac.view.mainpanel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class GoogleStaticMaps {
	
	private GoogleStaticMaps(){
	}
	
	public static final Optional<ImageIcon> get(URL mapUrl) {
		BufferedImage mapImage = null;
		
		try {
			mapImage = ImageIO.read(mapUrl);
			return Optional.of(new ImageIcon(mapImage));
		}
		catch(IOException e) {
			String eMsg = e.toString() + "\n\nPossible problems are:\n    - No connections to the net available;\n    - Weak connection.";
			JOptionPane.showMessageDialog(new JFrame(), eMsg,  "Can't get input stream from URL!", JOptionPane.ERROR_MESSAGE);
			return Optional.empty();
		}
	}
}
