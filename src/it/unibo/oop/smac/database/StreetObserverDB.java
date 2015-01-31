package it.unibo.oop.smac.database;

import java.util.ArrayList;
import java.util.List;

import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.StreetObserver;
import it.unibo.oop.smac.datatype.I.ICoordinates;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StreetObserver")
public class StreetObserverDB implements IStreetObserver{
	
	@DatabaseField(id = true, canBeNull = false)
	private String id;
	
	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private Coordinates coordinates;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<SightingDB> sightings;
	
	// costruttori
	public StreetObserverDB() {
		this(new StreetObserver(new Coordinates(0f,0f)));
	}
	
	public StreetObserverDB(IStreetObserver streetObserver) {
		this.coordinates = (Coordinates)streetObserver.getCoordinates();
		this.id = streetObserver.getID();
	}
	
	public void addSightings(SightingDB sighting) {
		this.sightings.add(sighting);
		System.out.println("Just added new sighting: " + sighting);
	}
	
	// getters
	public List<SightingDB> getSightingsList() {
		return new ArrayList<SightingDB>(this.sightings); //defensive copy
	}

	@Override
	public ICoordinates getCoordinates() {
		return new Coordinates(this.coordinates); //defensive copy
	}
	
	@Override
	public Float getLatitude() {
		return this.coordinates.getLatitude();
	}

	@Override
	public Float getLongitude() {
		return this.coordinates.getLongitude();
	}
	
	@Override
	public String getID() {
		return new String(this.id);   //defensive copy
	}
	
	@Override
	public String toString() {
		return "StreetObserverRow = " + 
				"[ID : " + this.id +
				"; " + this.coordinates +
				"; " + this.sightings + "]";
	}

}