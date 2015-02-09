package it.unibo.oop.smac.database;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.Sighting;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Classe che implementa un'{@link ISighting} da salvare nel database.
 * 
 * @author Federico Bellini
 */
@DatabaseTable(tableName = "Sighting")
public class SightingRow implements ISighting {

	/**
	 * Campo contenente l'ID dell'avvistamento.
	 */
	@DatabaseField(generatedId = true)
	private int id;

	/**
	 * Campo contenente l'osservatore che ha compiuto l'avvistamento.
	 */
	@DatabaseField(canBeNull = false, foreign = true)
	private final StreetObserverRow streetObserverDB;

	/**
	 * Campo contenente la data di avvistamento.
	 */
	@DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
	private final Date date;

	/**
	 * Campo contenente la targa del mezzo rilevata.
	 */
	@DatabaseField(canBeNull = false, dataType = DataType.SERIALIZABLE)
	private final LicensePlate licensePlate;

	/**
	 * Campo contenente la velocita' rilevata.
	 */
	@DatabaseField(canBeNull = false)
	private final Float speed;

	/**
	 * Costruttore di default reimplementato per il corretto funzionamento delle
	 * librerie di database.
	 */
	SightingRow() {
		this(new Sighting.Builder().build(), new StreetObserverRow());
	}

	/**
	 * Costruttore pubblico per la classe.
	 * 
	 * @param sighting
	 *            L'{@link ISighting} rilevato dall'osservatore.
	 * @param streetObserverDB
	 *            L'osservatore che ha compiuto l'avvistamento.
	 */
	public SightingRow(final ISighting sighting,
			final StreetObserverRow streetObserverDB) {
		this.streetObserverDB = streetObserverDB;
		this.date = sighting.getDate();
		this.licensePlate = sighting.getLicensePlate();
		this.speed = sighting.getSpeed();
	}

	@Override
	public IStreetObserver getStreetObserver() {
		return streetObserverDB;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	@Override
	public Float getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return "SightingRow [id=" + id + ", streetObserverRow="
				+ streetObserverDB + ", date=" + date + ", licensePlate="
				+ licensePlate + ", speed=" + speed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime
				* result
				+ ((streetObserverDB == null) ? 0 : streetObserverDB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final SightingRow other = (SightingRow) obj;
		if (date == null || other.date == null) {
			return false;
		} else if (!date.equals(other.date)) {
			return false;
		}

		if (id != other.id) {
			return false;
		}

		if (licensePlate == null || other.licensePlate != null) {
			return false;
		} else if (!licensePlate.equals(other.licensePlate)) {
			return false;
		}

		if (speed == null || other.speed != null) {
			return false;
		} else if (!speed.equals(other.speed)) {
			return false;
		}
		if (streetObserverDB == null || other.streetObserverDB != null) {
			return false;
		} else if (!streetObserverDB.equals(other.streetObserverDB)) {
			return false;
		}
		return true;
	}

}