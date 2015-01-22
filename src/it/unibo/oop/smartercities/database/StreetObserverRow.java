package it.unibo.oop.smartercities.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StreetObserver")
public class StreetObserverRow {
	
	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private Coordinates<Double> coordinates;
	
	@DatabaseField(id = true, canBeNull = false)
	private double id;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<SightingRow> sightings;
	
	// costruttori
	public StreetObserverRow() {
		this(new StreetObserver(new Coordinates<Double>(0.0,0.0)));
	}
	
	public StreetObserverRow(IStreetObserver iso) {
		this.coordinates = iso.getCoordinates();
		this.id = iso.getID();
		//this.sightings = 
	}
	
	public StreetObserverRow(Coordinates<Double> coordinate) {
		System.exit(0);
		/*
		this.coordinates = coordinate;
		this.id = coordinate.toString().substring(0, 5);*/
	}
	
	
	// getters
	public Float getMediaVelocita() throws Exception {
		ForeignCollection<SightingRow> sightings = this.getSightings();
		Float sum = (float) 0;
		for(SightingRow s:sightings){
			sum += s.getSpeed();
		}
		Float response = sum/sightings.size();
		return response;
	}

	public Float getMediaVelocita(Date from, Date to) throws Exception {
		List<SightingRow> sightings = getSightings(from, to);
		Float sum = (float) 0;
		for(Sighting s:sightings){
			sum += s.getSpeed();
		}
		Float response = sum/=sightings.size();
		return response;
	}
	
	public ForeignCollection<SightingRow> getSightings() {
		return sightings;
	}
	
	public List<SightingRow> getSightings(Date from, Date to) {
		List<SightingRow> response = new ArrayList<SightingRow>();
		for(SightingRow s:getSightings()){
			if(s.getDate().before(to) && s.getDate().after(from)){
				response.add(s);
			}
		}
		return response;
	}
	


	public void setSightings(ForeignCollection<SightingRow> sightings) {
		this.sightings = sightings;
	}

	public Coordinates<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates<Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public String toString() {
		return "StreetObserverRow = " + 
				"[ID : " + this.id +
				this.coordinates +
				this.sightings + "]";
	}

}