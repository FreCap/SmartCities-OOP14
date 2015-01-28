package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.StolenCarDB;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.model.IStolenCars;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class StolenCars implements IStolenCars {
	private static StolenCars instance;
	protected StolenCars(){
		
	};
	
	public static synchronized StolenCars getInstance() {
		if (instance != null)
			return instance;
		instance = new StolenCars();
		return instance;
	}
	@Override
	public List<IInfoStolenCar> getStolenCarsInfoList() {
		List<StolenCarDB> stolenCars = null;
		Dao<StolenCarDB, Integer> stolenCarDao = Connection.getInstance().getStolenCarDao();
		try {
			stolenCars = stolenCarDao.queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<IInfoStolenCar> stolen = (List<IInfoStolenCar>) (List<?>) stolenCars;
		return stolen;

	}

	@Override
	public Boolean checkStolenPlate(LicensePlate licensePlate) {
		Dao<StolenCarDB, Integer> stolenCarDao = Connection.getInstance()
				.getStolenCarDao();
		QueryBuilder<StolenCarDB, Integer> statementBuilder = stolenCarDao
				.queryBuilder();
		List<StolenCarDB> exist = new ArrayList<StolenCarDB>();
		try {
			List<StolenCarDB> stolenCars = stolenCarDao.query(statementBuilder
					.prepare());
			statementBuilder.where().eq(StolenCarDB.LICENSEPLATE_FIELD_NAME,
					licensePlate.toString());

			exist = stolenCarDao.query(statementBuilder.prepare());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exist.size() > 0;
	}
}