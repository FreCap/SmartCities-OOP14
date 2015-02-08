package it.unibo.oop.smac.database;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.StolenCar;
import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

// TODO per fra
@DatabaseTable(tableName = "StolenCar")
public class StolenCarRow implements IStolenCar {
	public static final String LICENSEPLATE_FIELD_NAME = "licensePlate";
	public static final String DATAINSERIMENTO_FIELD_NAME = "dataInserimento";

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(columnName = LICENSEPLATE_FIELD_NAME, dataType = DataType.STRING)
	private String licensePlate;

	@DatabaseField(columnName = DATAINSERIMENTO_FIELD_NAME, canBeNull = false)
	private final Date dataInserimento;

	StolenCarRow() {
		this(new LicensePlate(""));
	}

	public StolenCarRow(LicensePlate licensePlate) {
		setLicensePlate(licensePlate);
		this.dataInserimento = new Date();
	}

	public StolenCarRow(StolenCar stolenCar) {
		setLicensePlate(stolenCar.getLicensePlate());
		this.dataInserimento = stolenCar.getInsertionDate();
	}

	public LicensePlate getLicensePlate() {
		return new LicensePlate(licensePlate);
	}

	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate.toString();
	}

	public Date getInsertionDate() {
		return dataInserimento;
	}

}