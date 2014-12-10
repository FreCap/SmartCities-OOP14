package it.unibo.oop.googleMapsWeb;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class GoogleMapsWebBrowser extends JFXPanel {
	private static final long serialVersionUID = 6541846132164168451L;
	private WebView webView;
	private WebEngine webEngine;
	
	public GoogleMapsWebBrowser() {
		Platform.runLater(() -> {
				initialiseJavaFXScene();
			});
		}
	private void initialiseJavaFXScene() {
		webView = new WebView();
		webEngine = webView.getEngine();
		webEngine.load("https://www.google.it/maps");
		
		Scene scene = new Scene(webView, 100, 100, true);
		setScene(scene);
	}
}

