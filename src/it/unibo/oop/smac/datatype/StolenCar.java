package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.IStolenCar;

import java.util.Date;

import javax.management.InvalidAttributeValueException;

/**
 * Implementazione concreta di un'{@link IStolenCar}.
 */
public class StolenCar implements IStolenCar {

	/**
	 * Attributo contente la targa della macchina rubata.
	 */
	private final LicensePlate licensePlate;

	/**
	 * Attributo contenente la data del furto della macchina
	 */
	private final Date insertionDate;

	/**
	 * Costruttore della classe che permette l'inizializzazione i suoi campi
	 * 
	 * @param licensePlate
	 * @param insertionDate
	 */
	public StolenCar(final LicensePlate licensePlate, final Date insertionDate) {
		this.licensePlate = licensePlate;
		this.insertionDate = insertionDate;
	}

	/**
	 * Restituisce la targa della macchina rubata.
	 * 
	 * @return targa della macchina rubata
	 */
	@Override
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Restituisce la data del furto della macchina
	 * 
	 * @return data del furto
	 */
	@Override
	public Date getInsertionDate() {
		return insertionDate;
	}

	/**
	 * Classe statica Builder per la classe StolenCar. Questa classe permette di
	 * creare un oggetto della classe StolenCar, utilizzando il pattern Builder.
	 * 
	 */
	public static class Builder {

		private LicensePlate licensePlate;
		private Date insertionDate;

		/**
		 * Costruisce l'oggetto StolenCar con la LicensePlate passata come
		 * paramentro.
		 * 
		 * @param licensePlate
		 *            La LicensePlate' da settare.
		 * @return Il Builder stesso.
		 */
		public Builder licensePlate(final LicensePlate licensePlate) {
			this.licensePlate = licensePlate;
			return this;
		}

		/**
		 * Costruisce l'oggetto StolenCar con la targa passata come paramentro.
		 * 
		 * @param licensePlate
		 *            La LicensePlate' da settare.
		 * @return Il Builder stesso.
		 * @throws InvalidAttributeValueException
		 *             restituita quando la targa non ha il formato giusto, es.
		 *             AA000AA
		 */
		public Builder licensePlate(final String licensePlate)
				throws InvalidAttributeValueException {
			this.licensePlate(new LicensePlate(licensePlate));
			return this;
		}

		/**
		 * Costruisce l'oggetto StolenCar con la data' passata come paramentro.
		 * 
		 * @param date
		 *            La data da settare.
		 * @return Il Builder stesso.
		 */
		public Builder insertionDate(final Date insertionDate) {
			this.insertionDate = insertionDate;
			return this;
		}

		/**
		 * Costruisce l'oggetto StolenCar con la data' corrente.
		 * 
		 * @param date
		 *            La data da settare.
		 * @return Il Builder stesso.
		 */
		public Builder insertionDateNow() {
			this.insertionDate(new Date());
			return this;
		}

		/**
		 * Metodo utilizzato per creare un oggetto della classe Sighting con gli
		 * attributi appena settati.
		 * 
		 * @return L'oggetto della classe Sighting appena creato.
		 * @throws StolenCarNotValidException
		 * @exception IllegalArgumentException
		 *                ricordarsi di impostare tutti i parametri
		 */
		public StolenCar build() {
			if (this.licensePlate == null || this.insertionDate == null) {
				throw new IllegalArgumentException(
						"Devi completare tutti i campi prima di fare il build");
			}
			return new StolenCar(this.licensePlate, this.insertionDate);
		}
	}

}
