package it.unibo.oop.smac.database;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Sighting")
public class SightingDB implements ISighting {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = false, foreign = true)
	private final StreetObserverDB streetObserverRow;

	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private final Date date;

	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private final LicensePlate licensePlate;

	@DatabaseField(canBeNull = false)
	private final Float speed;

	SightingDB(){
		this(null,null);
	}

	public SightingDB(ISighting sighting, StreetObserverDB streetObserverRow) {
		this.streetObserverRow = streetObserverRow;
		this.date = sighting.getDate();
		this.licensePlate = sighting.getLicensePlate();
		this.speed = sighting.getSpeed();
	}

	public int getId() {
		return id;
	}

	public IStreetObserver getStreetObserver() {
		return streetObserverRow;
	}

	public Date getDate() {
		return date;
	}

	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	public Float getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return "SightingRow [id=" + id + ", streetObserverRow="
				+ streetObserverRow + ", date=" + date + ", licensePlate="
				+ licensePlate + ", speed=" + speed + "]";
	}
	
	// TODO hashcode e equals
	
	

}