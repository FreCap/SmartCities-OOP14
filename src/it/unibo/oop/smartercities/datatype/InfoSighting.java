package it.unibo.oop.smartercities.datatype;

import java.util.Date;

/**
 * Classe di scambio, prima di essere tradotto in Sighting
 * @author fre
 *
 */
public class InfoSighting {

	private Coordinates coordinates;

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

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}
