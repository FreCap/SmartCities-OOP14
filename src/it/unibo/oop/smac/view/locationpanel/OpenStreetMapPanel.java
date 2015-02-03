package it.unibo.oop.smac.view.locationpanel;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import it.unibo.oop.smac.datatype.I.ICoordinates;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Implementazione di una {@link JMapViewer}, che permette di visualizzare una
 * mappa di "Open Street Map".
 * 
 * @author Federico Bellini
 */
public class OpenStreetMapPanel extends JMapViewer implements ILocationPanel{

	private static final long serialVersionUID = -2763079963863167233L;
	private static final int TIME_DELAY = 300;
	
	/**
	 * Costruttore pubblico della classe.
	 */
	public OpenStreetMapPanel() {
		this.setZoomButtonStyle(JMapViewer.ZOOM_BUTTON_STYLE.VERTICAL);
	}

	/**
	 * Aggiunge un'{@link IStreetObserver} alla mappa.
	 */
	@Override
	public void addStreetObserver(IStreetObserver streetObserver) {
		this.addRedMapMarker(streetObserver.getID(), streetObserver.getCoordinates());
		SwingUtilities.invokeLater(() -> {
				this.setDisplayToFitMapMarkers();
		});
	}

	/**
	 * Restituisce questo JPanel.
	 * 
	 * @return
	 * 			Il JPanel richiesto.
	 */
	@Override
	public JPanel getPanel() {
		return this;
	}

	/**
	 * Notifica visivamente sulla mappa l'avvenuto passaggio di un auto sotto di un
	 * {@link IStreetObserver} modificando per qualche istante il colore del pin
	 * visualizzato, da rosso a verde.
	 */
	@Override
	public void notifyPassage(IStreetObserver streetObserver) {
		String id = streetObserver.getID();
		ICoordinates c = streetObserver.getCoordinates();
		
		removeMapMarker(id,c);
		addGreenMapMarker(id, c);
		try {
			Thread.sleep(TIME_DELAY);
		} catch (InterruptedException e) {
			// nothing to do
		}
		removeMapMarker(id,c);
		addRedMapMarker(id, c);
	}
	
	/**
	 * Aggiunge alla mappa un nuovo {@link MyMapMarker} di colore rosso.
	 * 
	 * @param id
	 * 			ID del {@link MyMapMarker}.
	 * @param coordinates
	 * 			Le coodinate del {@link MyMapMarker}.
	 */
	private void addRedMapMarker(String id, ICoordinates coordinates){
		SwingUtilities.invokeLater(() -> 
				this.addMapMarker(new RedMapMarker(id, coordinates))
		);
	}
	
	/**
	 * Aggiunge alla mappa un nuovo {@link MyMapMarker} di colore verde.
	 * 
	 * @param id
	 * 			ID del {@link MyMapMarker}.
	 * @param coordinates
	 * 			Le coodinate del {@link MyMapMarker}.
	 */
	private void addGreenMapMarker(String id, ICoordinates coordinates){
		SwingUtilities.invokeLater(() -> 
				this.addMapMarker(new GreenMapMarker(id, coordinates))
		);		
	}

	/**
	 * Rimuove dalla mappa un {@link MyMapMarker} esistente.
	 * 
	 * @param id
	 * 			ID del {@link MyMapMarker}.
	 * @param coordinates
	 * 			Le coodinate del {@link MyMapMarker}.
	 */
	private void removeMapMarker(String id, ICoordinates coordinates){
		/* nota che non c'è differenza tra rimuovere un RedMapMarker o un GreenMapMarker,
		poichè quando il metodo removeMapMarker richiama la funziona equals, e cerca il
		giusto MapMarker da rimuovere, essa non fa differenza tra red o green, ma si basa
		esclusivamente sulla posizione dei MapMarker per verificarne l'uguaglianza */
		SwingUtilities.invokeLater(() -> 
				this.removeMapMarker(new RedMapMarker(id, coordinates))
		);
	}

}
