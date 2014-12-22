package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.Coordinates;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StreetObserver")
public class StreetObserver {
    @DatabaseField(id = true)
    private Coordinates coordinates;
    
    StreetObserver() {
    }

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
      
}