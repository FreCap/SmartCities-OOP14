package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.StolenCarRow;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.model.IStolenCarModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

// TODO per fra
public class StolenCarModelDatabase implements IStolenCarModel {
	private static StolenCarModelDatabase instance;
	protected StolenCarModelDatabase(){
		
	};
	
	public static synchronized StolenCarModelDatabase getInstance() {
		if (instance != null)
			return instance;
		instance = new StolenCarModelDatabase();
		return instance;
	}
	@Override
	public List<IInfoStolenCar> getStolenCarsInfoList() {
		List<StolenCarRow> stolenCars = null;
		Dao<StolenCarRow, Integer> stolenCarDao = Connection.getInstance().getStolenCarDao();
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
		Dao<StolenCarRow, Integer> stolenCarDao = Connection.getInstance()
				.getStolenCarDao();
		QueryBuilder<StolenCarRow, Integer> statementBuilder = stolenCarDao
				.queryBuilder();
		List<StolenCarRow> exist = new ArrayList<StolenCarRow>();
		try {
			List<StolenCarRow> stolenCars = stolenCarDao.query(statementBuilder
					.prepare());
			statementBuilder.where().eq(StolenCarRow.LICENSEPLATE_FIELD_NAME,
					licensePlate.toString());

			exist = stolenCarDao.query(statementBuilder.prepare());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exist.size() > 0;
	}

	@Override
	public IInfoStolenCar getStolenCarInfo(IStolenCar stolenCar) {
		// TODO Auto-generated method stub
		return null;
	}
}