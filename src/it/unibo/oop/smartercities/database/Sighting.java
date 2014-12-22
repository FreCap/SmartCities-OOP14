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
	private IStreetObserver streetObserver;

	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private Date date;

	@DatabaseField(canBeNull = false)
	private String licensePlate;

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
	
	@Override
	public IStreetObserver getStreetObserver() {
		return streetObserver;
	}

	@Override
	public void setStreetObserver(IStreetObserver streetObserver) {
		this.streetObserver = streetObserver;
	}
	
	@Override
	public Date getDate() {
		return date;
	}
	
	@Override
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String getLicensePlate() {
		return licensePlate;
	}
	
	@Override
	public void setLicensePlate(String plateLicense) {
		this.licensePlate = plateLicense;
	}
	
	@Override
	public Float getSpeed() {
		return speed;
	}
	
	@Override
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
}