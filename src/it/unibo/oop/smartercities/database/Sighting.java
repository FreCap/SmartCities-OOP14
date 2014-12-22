package it.unibo.oop.smartercities.database;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Sighting")
public class Sighting {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = false, foreign = true)
	private StreetObserver streetObserver;

	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private Date data;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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