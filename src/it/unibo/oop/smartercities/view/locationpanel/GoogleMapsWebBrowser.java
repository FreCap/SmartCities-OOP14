package it.unibo.oop.smartercities.view.locationpanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class GoogleMapsWebBrowser extends JFXPanel implements ILocationPanel{
	
	private static final long serialVersionUID = 6541846132164168451L;
	private WebView webView;
	private WebEngine webEngine;
	
	public GoogleMapsWebBrowser() {
		super();
		Platform.runLater( ()->{googleMapsScene();} );
	}
	
	private void googleMapsScene() {
		webView = new WebView();
		webEngine = webView.getEngine();
		//TODO guarda http://econym.org.uk/gmap
		webEngine.load("http://econym.org.uk/gmap/example_plotpoints.htm?q=Cesena1@44.139625,12.235225&q=Cesena%2@44.131771,12.268767");
		
		Scene scene = new Scene(webView);
		setScene(scene);
	}

	@Override
	public JFXPanel getPanel() {
		return this;
	}
}

