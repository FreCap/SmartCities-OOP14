package it.unibo.oop.smartercities.test.client;

import it.unibo.oop.smartercities.datatype.Coordinates;

import java.util.List;

public class TrackCommand {

	private Integer sleep;
	private Coordinates<Double> coordinate;

	public Integer getSleep() {
		return sleep;
	}

	public void setSleep(Integer sleep) {
		this.sleep = sleep;
	}

	public Coordinates<Double> getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinates<Double> coordinate) {
		this.coordinate = coordinate;
	}

}