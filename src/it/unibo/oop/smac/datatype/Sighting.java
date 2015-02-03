package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.util.Date;

/**
 * Questa classe implementa l'interfaccia {@link ISighting}, ed ha il compito di raccogliere
 * tutte le informazioni generate dall'osservatore, quali la data dell'avvistamento, la 
 * targa dell'auto avvistata e la sua velocita'.
 * 
 * Questa classe è costruita utilizzando il pattern Builder.
 * 
 * @author Federico Bellini
 *
 */
public class Sighting implements ISighting {

	private final IStreetObserver streetObserver;
	private final Date date;
	private final LicensePlate licensePlate;
	private final Float speed;

	/**
	 * Costruttore privato della classe.
	 * 
	 * @param streetObserver
	 * 			L'osservatore che ha compiuto l'avvistamento.
	 * @param date
	 * 			La data dell'avvistamento.
	 * @param licensePlate
	 * 			La targa dell'auto avvistata.
	 * @param speed
	 * 			La velocita' rilevata.
	 */
	private Sighting(IStreetObserver streetObserver, Date date, LicensePlate licensePlate, Float speed) {
		this.streetObserver = streetObserver;
		this.date = date;
		this.licensePlate = licensePlate;
		this.speed = speed;
	}

	/**
	 * Restituisce l'{@link IStreetObserver} che ha generato le informazioni di questo
	 * avvistamento.
	 * 
	 * @return
	 * 			L'{@link IStreetObserver} autore dell'avvistamento.
	 */
	@Override
	public IStreetObserver getStreetObserver() {
		return new StreetObserver(this.streetObserver); //defensive copy
	}
	
	/**
	 * Restituisce la {@link Date} relativa al momento dell'avvistamento.
	 * 
	 * @return
	 * 			La {@link Date} relativa al momento dell'avvistamento.
	 */
	@Override
	public Date getDate() {
		return this.date;
	}

	/**
	 * Restituisce la {@link LicensePlate} dell'auto avvistata.
	 * 
	 * @return
	 * 			La {@link LicensePlate} dell'auto avvistata.
	 */
	@Override
	public LicensePlate getLicensePlate() {
		return this.licensePlate;
	}

	/**
	 * Restituisce la velocita' dell'auto avvistata.
	 * 
	 * @return
	 * 			La velocita' dell'auto avvistata.
	 */
	@Override
	public Float getSpeed() {
		return this.speed;
	}
	
	/**
	 * Classe statica Builder per la classe Sighting. 
	 * Questa classe permette di creare un oggetto della classe Sighting, utilizzando il
	 * pattern Builder.
	 * 
	 * @author Federico Bellini
	 */
	public static class Builder{
		private IStreetObserver streetObserver;
		private Date date;
		private LicensePlate licensePlate;
		private Float speed;
		
		/**
		 * Costruisce l'oggetto Sighting con l'IStreetObserver passato come paramentro.
		 * 
		 * @param streetObserver
		 * 			L'IStreetObserver da settare.
		 * @return
		 * 			Il Builder stesso.
		 */
		public Builder streetObserver(IStreetObserver streetObserver){
			this.streetObserver = streetObserver;
			return this;
		}
		
		/**
		 * Costruisce l'oggetto Sighting con la data' passata come paramentro.
		 * 
		 * @param date
		 * 			La data da settare.
		 * @return
		 * 			Il Builder stesso.
		 */
		public Builder date(Date date){
			this.date = date;
			return this;
		}
		
		/**
		 * Costruisce l'oggetto Sighting con la LicensePlate passata come paramentro.
		 * 
		 * @param licensePlate
		 * 			La LicensePlate' da settare.
		 * @return
		 * 			Il Builder stesso.
		 */
		public Builder licensePlate(LicensePlate licensePlate){
			this.licensePlate = licensePlate;
			return this;
		}
		
		/**
		 * Costruisce l'oggetto Sighting con la velocita' passata come paramentro.
		 * 
		 * @param speed
		 * 			La velocita' da settare.
		 * @return
		 * 			Il Builder stesso.
		 */
		public Builder speed(Float speed){
			this.speed = speed;
			return this;
		}
		
		/**
		 * Metodo utilizzato per creare un oggetto della classe Sighting con gli attributi
		 * appena settati.
		 * 
		 * @return
		 * 			L'oggetto della classe Sighting appena creato.
		 */
		public Sighting build(){
			return new Sighting(this.streetObserver, this.date, this.licensePlate, this.speed);
		}
	}

}
