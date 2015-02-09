package it.unibo.oop.smac.test.client;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.network.datatype.PlainSighting;

import java.io.InputStream;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * Classe che gestisce la simulazione del percorso di una macchina
 */
public class TrackSimulator {

	/**
	 * File contenente i tracks possibili
	 */
	public static final String FILENAME = "tracks/tracks.json";

	/**
	 * Track corrente da seguire
	 */
	public Track track;

	/**
	 * Posizione del track in cui si trova la macchina in questo istante
	 */
	public Integer currentIndex = 0;

	/**
	 * Targa della macchina di cui si sta simulando lo spostamento
	 */
	public final LicensePlate licensePlate;

	/**
	 * Azione con cui si genera un nuovo Sighting e l'avanzamento della macchina
	 * nel track
	 * 
	 * @return {@link PlainSighting} del passaggio corrente
	 */
	public PlainSighting next() {
		final TrackCommand current = track.getTrackCommands().get(currentIndex);
		try {
			Thread.sleep(1000 * current.getSleep());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final PlainSighting response = new PlainSighting();
		response.setCoordinates(current.getCoordinate());
		response.setDate(new Date());
		response.setLicensePlate(licensePlate.toString());
		response.setSpeed(new Float(new Random().nextInt(50) + 30));

		final int size = track.getTrackCommands().size();
		// avanzo il contatore
		currentIndex = (currentIndex + 1) % size;

		return response;
	}

	/**
	 * Costruttore della classe che richiede la targa della macchina di cui si
	 * vuole simulare il comportamento, e su quale track devi passare
	 * 
	 * @param licensePlate
	 *            targa della macchina di cui si vuole simulare l'avanzamento
	 * @param nTrack
	 *            id del track da utilizzare
	 */
	public TrackSimulator(final LicensePlate licensePlate, final Integer nTrack) {
		track = getNTrack(nTrack);
		this.licensePlate = licensePlate;
	}

	/**
	 * Costruttore della classe che richiede la targa della macchina di cui si
	 * vuole simulare il comportamento, e sceglie un track casuale
	 * 
	 * @param licensePlate
	 *            targa della macchina di cui si vuole simulare l'avanzamento
	 */
	public TrackSimulator(final LicensePlate licensePlate) {
		this(licensePlate, new Random().nextInt(100));
	}

	/**
	 * Metodo che restituisce la track richiesta
	 * 
	 * @param nTrack
	 *            id della track richiesta
	 * @return Track richiesta
	 */
	private Track getNTrack(final Integer nTrack) {
		final Track[] tracks = getTracks();
		return tracks[nTrack % tracks.length];
	}

	/**
	 * Metodo che legge dal JSON tutte le tracks disponibili
	 * 
	 * @return Track[] Tracks disponibili
	 */
	private Track[] getTracks() {
		final Gson gson = new Gson();
		final String rawJSON = readFile();
		return gson.fromJson(rawJSON, Track[].class);
	}

	/**
	 * Metodo per leggere il file contenente i tracks
	 * 
	 * @return String testo del file
	 */
	private String readFile() {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		final InputStream stream = classLoader.getResourceAsStream(FILENAME);
		final Scanner scanner = new Scanner(stream, "UTF-8");
		final String fileText = scanner.useDelimiter("\\A").next();
		scanner.close();
		return fileText;
	}
}
