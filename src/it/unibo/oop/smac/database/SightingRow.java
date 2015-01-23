package it.unibo.oop.smac.database;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Sighting")
public class SightingRow implements ISighting {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = false, foreign = true)
	private StreetObserverRow streetObserverRow;

	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private Date date;

	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private LicensePlate licensePlate;

	@DatabaseField(canBeNull = false)
	private Float speed;

	SightingRow() {
	}

	public SightingRow(ISighting sighting, StreetObserverRow streetObserverRow) {
		this.setStreetObserver(streetObserverRow);
		this.setDate(sighting.getDate());
		this.setLicensePlate(sighting.getLicensePlate());
		this.speed = sighting.getSpeed();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IStreetObserver getStreetObserver() {
		return streetObserverRow;
	}

	public void setStreetObserver(StreetObserverRow streetObserverRow) {
		this.streetObserverRow = streetObserverRow;
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