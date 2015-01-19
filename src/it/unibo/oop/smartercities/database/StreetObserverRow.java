package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StreetObserver")
public class StreetObserverRow extends StreetObserver {
	
	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private Coordinates<Double> coordinates;
	
	public StreetObserverRow() {
		super(new Coordinates<Double>(0.0,0.0), 0);
	}
	
	public StreetObserverRow(IStreetObserver iso) {
		super(iso);
		coordinates = iso.getCoordinates();
	}

	public Coordinates<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates<Double> coordinates) {
		this.coordinates = coordinates;
	}

}