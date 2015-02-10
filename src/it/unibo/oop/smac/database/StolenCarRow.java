package it.unibo.oop.smac.database;

import it.unibo.oop.smac.datatypes.IStolenCar;
import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.datatypes.StolenCar;

import java.util.Date;

import javax.management.InvalidAttributeValueException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 */
@DatabaseTable(tableName = "StolenCar")
public class StolenCarRow implements IStolenCar {

  /**
   * Logger della classe
   */
  private final static Logger LOGGER = LoggerFactory.getLogger(Connection.class);

  public static final String LICENSEPLATE_FIELD_NAME = "licensePlate";
  public static final String DATAINSERIMENTO_FIELD_NAME = "dataInserimento";

  @DatabaseField(id = true, columnName = LICENSEPLATE_FIELD_NAME, dataType = DataType.STRING)
  private String licensePlate;

  @DatabaseField(columnName = DATAINSERIMENTO_FIELD_NAME, canBeNull = false)
  private final Date dataInserimento;

  StolenCarRow() {
    this(new LicensePlate());
  }

  public StolenCarRow(final LicensePlate licensePlate) {
    setLicensePlate(licensePlate);
    this.dataInserimento = new Date();
  }

  public StolenCarRow(final StolenCar stolenCar) {
    setLicensePlate(stolenCar.getLicensePlate());
    this.dataInserimento = stolenCar.getInsertionDate();
  }

  @Override
  public LicensePlate getLicensePlate() {
    LicensePlate response = null;
    try {
      response = new LicensePlate(licensePlate);
    } catch (InvalidAttributeValueException e) {
      // non può succede visto che se viene creata una copia difensiva di
      // un oggetto già esistente, e quindi di cui è stato convalidato il
      // valore
      LOGGER.error("How can a valid license plate generate a invalid license plate?", e);
    }
    return response;
  }

  public void setLicensePlate(final LicensePlate licensePlate) {
    this.licensePlate = licensePlate.toString();
  }

  @Override
  public Date getInsertionDate() {
    return new Date(dataInserimento.getTime());
  }

}