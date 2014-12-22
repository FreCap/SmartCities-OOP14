package it.unibo.oop.smartercities.database;

import java.util.Date;

import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StolenCar")
public class StolenCar implements IStolenCar {
	
	public static final String LICENSEPLATE_FIELD_NAME = "licensePlate";
	public static final String INSERTIONDATE_FIELD_NAME = "insertionDate";

    @DatabaseField(columnName = LICENSEPLATE_FIELD_NAME,id = true)
    private LicensePlate licensePlate;

	@DatabaseField(columnName = INSERTIONDATE_FIELD_NAME, canBeNull = false)
	private Date insertionDate;
	
    StolenCar() {
    }

    @Override
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

    @Override
	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}

    @Override
	public Date getInsertionDate() {
		return insertionDate;
	}

    @Override
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
}