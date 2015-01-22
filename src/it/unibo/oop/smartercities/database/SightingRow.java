package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.PlainSighting;
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

	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private LicensePlate licensePlate;

	@DatabaseField(canBeNull = false)
	private Float speed;

	SightingRow() {
	}

	public SightingRow(PlainSighting plainSighting, StreetObserverRow streetObserverRow) {
		this.setStreetObserver(streetObserverRow);
		this.setDate(plainSighting.getDate());
		this.setLicensePlate(new LicensePlate(plainSighting.getLicensePlate()));
		this.speed = plainSighting.getSpeed();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IStreetObserver getStreetObserver() {
		return null;//streetObserver;
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