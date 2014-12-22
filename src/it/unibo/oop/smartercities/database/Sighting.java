package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.I.ISighting;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Sighting")
public class Sighting implements ISighting {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = false, foreign = true)
	private StreetObserver streetObserver;

	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private Date date;

	@DatabaseField(canBeNull = false)
	private String plateLicense;

	@DatabaseField(canBeNull = false)
	private Float speed;

	Sighting() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StreetObserver getStreetObserver() {
		return streetObserver;
	}

	public void setStreetObserver(StreetObserver streetObserver) {
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

	public String getPlateLicense() {
		return plateLicense;
	}

	public void setPlateLicense(String plateLicense) {
		this.plateLicense = plateLicense;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

}