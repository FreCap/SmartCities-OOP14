package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.StolenCarRow;
import it.unibo.oop.smac.datatypes.IStolenCar;
import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.datatypes.StolenCar;
import it.unibo.oop.smac.model.IStolenCarModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class StolenCarModelDatabase implements IStolenCarModel {

  /**
   * Logger della classe
   */
  private final static Logger LOGGER = LoggerFactory.getLogger(StolenCarModelDatabase.class);

  /**
   * Instanza del Singleton
   */
  private static StolenCarModelDatabase instance;

  /**
   * Restituisce un'istanza del model del database.
   * 
   * @return istanza del model database
   */
  public synchronized static StolenCarModelDatabase getInstance() {
    if (instance != null) {
      return instance;
    }
    instance = new StolenCarModelDatabase();
    return instance;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<IStolenCar> getStolenCarsInfoList() {
    List<StolenCarRow> stolenCars = null;
    Dao<StolenCarRow, Integer> stolenCarDao = null;
    try {
      stolenCarDao = Connection.getInstance().getStolenCarDao();
    } catch (SQLException e1) {
      LOGGER.error("Database connection error ", e1);
    }
    try {
      stolenCars = stolenCarDao.queryForAll();
    } catch (SQLException e) {
      LOGGER.error("Database query error ", e);
    }
    return (List<IStolenCar>) (List<?>) stolenCars;
  }

  @Override
  public Boolean checkStolenPlate(final LicensePlate licensePlate) {
    Dao<StolenCarRow, Integer> stolenCarDao = null;
    try {
      stolenCarDao = Connection.getInstance().getStolenCarDao();
    } catch (SQLException e) {
      LOGGER.error("Database query error ", e);
    }
    final QueryBuilder<StolenCarRow, Integer> statementBuilder = stolenCarDao.queryBuilder();
    List<StolenCarRow> exist = new ArrayList<StolenCarRow>();
    try {
      List<StolenCarRow> stolenCars = stolenCarDao.query(statementBuilder.prepare());
      statementBuilder.where().eq(StolenCarRow.LICENSEPLATE_FIELD_NAME, licensePlate.toString());

      exist = stolenCarDao.query(statementBuilder.prepare());

    } catch (SQLException e) {
      LOGGER.error("Database query error ", e);
    }

    return !exist.isEmpty();
  }

  @Override
  public synchronized void addNewStolenCar(StolenCar stolenCar) {
    if (!this.checkStolenPlate(stolenCar.getLicensePlate())) {
      final StolenCarRow stolenCarRow = new StolenCarRow(stolenCar);
      Dao<StolenCarRow, Integer> stolenCarDao = null;
      try {
        stolenCarDao = Connection.getInstance().getStolenCarDao();
      } catch (SQLException e) {
        LOGGER.error("Database query error ", e);
      }
      try {
        stolenCarDao.createIfNotExists(stolenCarRow);
      } catch (SQLException e) {
        System.err.println("The creation on database of the new StolenCar " + stolenCarRow
            + " is failed!");
        LOGGER
            .error("The creation on database of the new StolenCar {} is failed!", stolenCarRow, e);

      }

    }
  }

}