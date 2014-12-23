package it.unibo.oop.smartercities.data;

import it.unibo.oop.smartercities.data.I.IStolenCars;
import it.unibo.oop.smartercities.database.Connection;
import it.unibo.oop.smartercities.database.StolenCarRow;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.LicensePlate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class StolenCars implements IStolenCars {

	@Override
	public List<InfoStreetObserver> getStolenCarsList() {

		Dao<StolenCarRow, Integer> stolenCarDao = Connection.getInstance()
				.getStolenCarDao();
		QueryBuilder<StolenCarRow, Integer> statementBuilder = stolenCarDao
				.queryBuilder();
		try {
			List<StolenCarRow> stolenCars = stolenCarDao.query(statementBuilder
					.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// List<InfoStreetObserver> a = stolenCars;
		// return stolenCars;
		return null;
	}

	@Override
	public Boolean verifyStolenCars(LicensePlate licensePlate) {
		Dao<StolenCarRow, Integer> stolenCarDao = Connection.getInstance()
				.getStolenCarDao();
		QueryBuilder<StolenCarRow, Integer> statementBuilder = stolenCarDao
				.queryBuilder();
		List<StolenCarRow> exist = new ArrayList<StolenCarRow>();
		try {
			List<StolenCarRow> stolenCars = stolenCarDao.query(statementBuilder
					.prepare());
			statementBuilder.where().like(StolenCarRow.LICENSEPLATE_FIELD_NAME,
					licensePlate);

			exist = stolenCarDao.query(statementBuilder.prepare());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exist.size() > 0;
	}
}
