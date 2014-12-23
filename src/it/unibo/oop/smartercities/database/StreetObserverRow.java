package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.StreetObserver;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StreetObserver")
public class StreetObserverRow extends StreetObserver {

	public StreetObserverRow(Coordinates c) {
		super(c);
		coordinates = c;
	}

	@DatabaseField(id = true)
	private Coordinates coordinates;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}