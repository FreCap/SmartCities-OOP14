package it.unibo.oop.smac.test.client;

import it.unibo.oop.smac.datatype.Coordinates;

public class TrackCommand {

	private Integer sleep;
	private Coordinates coordinate;

	public Integer getSleep() {
		return sleep;
	}

	public void setSleep(Integer sleep) {
		this.sleep = sleep;
	}

	public Coordinates getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinates coordinate) {
		this.coordinate = coordinate;
	}

}