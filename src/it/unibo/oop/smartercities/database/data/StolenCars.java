package it.unibo.oop.smartercities.database.data;

import it.unibo.oop.smartercities.database.Connection;
import it.unibo.oop.smartercities.database.StolenCarRow;
import it.unibo.oop.smartercities.database.data.I.IStolenCars;
import it.unibo.oop.smartercities.datatype.LicensePlate;
import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class StolenCars implements IStolenCars {

	@Override
	public List<IInfoStolenCar> getStolenCarsList() {
		List<StolenCarRow> stolenCars = null;
		Dao<StolenCarRow, Integer> stolenCarDao = Connection.getInstance()
				.getStolenCarDao();
		try {
			stolenCars = stolenCarDao.queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<IInfoStolenCar> stolen = (List<IInfoStolenCar>) (List<?>) stolenCars;
		return stolen;

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
