package it.unibo.oop.smartercities.database;

import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StolenCar")
public class StolenCarRow implements IInfoStolenCar {
	public static final String LICENSEPLATE_FIELD_NAME = "licensePlate";
	public static final String DATAINSERIMENTO_FIELD_NAME = "dataInserimento";

	@DatabaseField(columnName = LICENSEPLATE_FIELD_NAME, id = true)
	private LicensePlate licensePlate;

	@DatabaseField(columnName = DATAINSERIMENTO_FIELD_NAME, canBeNull = false)
	private Date dataInserimento;

	StolenCarRow() {
	}

	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

}