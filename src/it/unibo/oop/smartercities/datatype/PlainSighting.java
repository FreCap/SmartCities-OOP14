package it.unibo.oop.smartercities.datatype;

import java.util.Date;

/**
 * Classe di scambio, prima di essere tradotto in Sighting
 * 
 * @author Francesco Capponi
 *
 */
public class PlainSighting {

	private Coordinates<Double> coordinates;
	private Date date;
	private String licensePlate;

	private Float speed;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Coordinates<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates<Double> coordinates) {
		this.coordinates = coordinates;
	}

}
