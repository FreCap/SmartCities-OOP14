package it.unibo.oop.smac.test.client;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.Sighting;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

public class TrackSimulator {

	public static final String fileName = "tracks.json";

	public Track track;
	public Integer currentIndex = 0;
	public final LicensePlate licensePlate;

	public Sighting next() {/*
		TrackCommand current = track.getTrackCommands().get(currentIndex);
		try {
			Thread.sleep(1000 * current.getSleep());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PlainSighting response = new PlainSighting();
		response.setCoordinates(current.getCoordinate());
		response.setDate(new Date());
		response.setLicensePlate(licensePlate.toString());
		response.setSpeed(new Float(new Random().nextInt(50) + 30));

		// avanzo il contatore
		currentIndex = currentIndex++ % track.getTrackCommands().size();

		return response;*/return null;
	}

	public TrackSimulator(LicensePlate licensePlate, Integer nTrack) {
		track = getNTrack(nTrack);
		this.licensePlate = licensePlate;
	}

	public TrackSimulator(LicensePlate licensePlate) {
		this(licensePlate, new Random().nextInt(100));
	}

	private Track getNTrack(Integer nTrack) {
		Track[] tracks = getTracks();
		return tracks[nTrack % tracks.length];
	}

	private Track[] getTracks() {
		Gson gson = new Gson();
		String rawJSON = readFile();
		return gson.fromJson(rawJSON, Track[].class);
	}

	private String readFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return new Scanner(classLoader.getResourceAsStream(fileName), "UTF-8")
				.useDelimiter("\\A").next();
	}

}
