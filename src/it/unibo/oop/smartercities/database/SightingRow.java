package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.InfoSighting;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Sighting")
public class SightingRow extends Sighting {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = false, foreign = true)
	private StreetObserverRow streetObserver;

	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private Date date;

	@DatabaseField(canBeNull = false)
	private LicensePlate licensePlate;

	@DatabaseField(canBeNull = false)
	private Float speed;

	SightingRow() {
	}

	SightingRow(InfoSighting infoSighting) {
		//TODO mettere lo streetObserver
		this.setDate(infoSighting.getDate());
		this.setLicensePlate(new LicensePlate(infoSighting.getLicensePlate()));
		this.speed = infoSighting.getSpeed();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StreetObserverRow getStreetObserver() {
		return streetObserver;
	}

	public void setStreetObserver(StreetObserverRow streetObserver) {
		this.streetObserver = streetObserver;
	}

	public void setStreetObserver(IStreetObserver streetObserver) {
		// TODO
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

}