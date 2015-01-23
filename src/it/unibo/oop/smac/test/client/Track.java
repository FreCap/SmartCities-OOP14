package it.unibo.oop.smac.test.client;

import java.util.List;

import it.unibo.oop.smac.datatype.Coordinates;

public class Track {
	
	private List<TrackCommand> trackCommands;

	public List<TrackCommand> getTrackCommands() {
		return trackCommands;
	}

	public void setTrackCommands(List<TrackCommand> trackCommands) {
		this.trackCommands = trackCommands;
	}
}