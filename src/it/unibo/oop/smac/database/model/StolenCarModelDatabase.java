package it.unibo.oop.smac.database.model;

import it.unibo.oop.smac.database.Connection;
import it.unibo.oop.smac.database.StolenCarRow;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.StolenCar;
import it.unibo.oop.smac.datatype.StolenCar;
import it.unibo.oop.smac.datatype.I.IStolenCar;
import it.unibo.oop.smac.model.IStolenCarModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

// TODO per fra (io questa classe(StreetObserverModelDatabase)
// l'ho implementata con il metodo getInfo astratto, in modo che sia il
// model vero e proprio dell'applicazione ad implementarlo!
public class StolenCarModelDatabase implements IStolenCarModel {
	private static StolenCarModelDatabase instance;

	protected StolenCarModelDatabase() {

	};

	public static synchronized StolenCarModelDatabase getInstance() {
		if (instance != null)
			return instance;
		instance = new StolenCarModelDatabase();
		return instance;
	}

	@Override
	public List<IStolenCar> getStolenCarsInfoList() {
		List<StolenCarRow> stolenCars = null;
		Dao<StolenCarRow, Integer> stolenCarDao = null;
		try {
			stolenCarDao = Connection.getInstance().getStolenCarDao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stolenCars = stolenCarDao.queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<IStolenCar> stolen = (List<IStolenCar>) (List<?>) stolenCars;
		return stolen;

	}

	@Override
	public Boolean checkStolenPlate(LicensePlate licensePlate) {
		Dao<StolenCarRow, Integer> stolenCarDao = null;
		try {
			stolenCarDao = Connection.getInstance().getStolenCarDao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	public synchronized void addNewStolenCar(StolenCar stolenCar) {
		if (!this.checkStolenPlate(stolenCar.getLicensePlate())) {
			StolenCarRow stolenCarDB = new StolenCarRow(stolenCar);
			Dao<StolenCarRow, Integer> stolenCarDao = null;
			try {
				stolenCarDao = Connection.getInstance().getStolenCarDao();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				stolenCarDao.createIfNotExists(stolenCarDB);
			} catch (SQLException e) {
				System.err
						.println("The creation on database of the new StolenCar "
								+ stolenCarDB + " is failed!");
				System.exit(1);
			}

		}
	}

}