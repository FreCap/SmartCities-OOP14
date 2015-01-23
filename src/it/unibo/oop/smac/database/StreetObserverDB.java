package it.unibo.oop.smac.database;

import java.util.ArrayList;
import java.util.List;

import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.StreetObserver;
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
	private Coordinates<Double> coordinates;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<SightingDB> sightings;
	
	// costruttori
	public StreetObserverDB() {
		this(new StreetObserver(new Coordinates<Double>(0.0,0.0)));
	}
	
	public StreetObserverDB(IStreetObserver streetObserver) {
		this.coordinates = streetObserver.getCoordinates();
		this.id = streetObserver.getID();
	}
	
	public void addSightings(SightingDB sighting) {
		this.sightings.add(sighting);
		System.out.println("Just added new sighting: " + sighting);
	}
	
	public List<SightingDB> getSightings() {
		return new ArrayList<SightingDB>();
	}

	@Override
	public Coordinates<Double> getCoordinates() {
		return coordinates;
	}
	
	@Override
	public String getID() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "StreetObserverRow = " + 
				"[ID : " + this.id +
				"; " + this.coordinates +
				"; " + this.sightings + "]";
	}

}