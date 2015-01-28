package it.unibo.oop.smac.datatype;

import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

import java.util.Date;

/**
 * Classe che viene spedita dai Client verso il Server contenente tutte le informazioni rilevate.
 * Questa classe è costruita utilizzando il pattern Builder.
 * 
 * @author Federico Bellini
 *
 */
public class Sighting implements ISighting {

	private final IStreetObserver<?> streetObserver;
	private final Date date;
	private final LicensePlate licensePlate;
	private final Float speed;

	private Sighting(IStreetObserver<?> streetObserver, Date date, LicensePlate licensePlate, Float speed) {
		this.streetObserver = streetObserver;
		this.date = date;
		this.licensePlate = licensePlate;
		this.speed = speed;
	}

	@Override
	public IStreetObserver<?> getStreetObserver() {
		return this.streetObserver;
	}
	
	@Override
	public Date getDate() {
		return this.date;
	}

	@Override
	public LicensePlate getLicensePlate() {
		return this.licensePlate;
	}

	@Override
	public Float getSpeed() {
		return this.speed;
	}
	
	public static class Builder{
		private IStreetObserver<?> streetObserver;
		private Date date;
		private LicensePlate licensePlate;
		private Float speed;
		
		public Builder streetObserver(IStreetObserver<?> streetObserver){
			this.streetObserver = streetObserver;
			return this;
		}
		
		public Builder date(Date date){
			this.date = date;
			return this;
		}
		
		public Builder licensePlate(LicensePlate licensePlate){
			this.licensePlate = licensePlate;
			return this;
		}
		
		public Builder speed(Float speed){
			this.speed = speed;
			return this;
		}
		
		public Sighting build(){
			return new Sighting(this.streetObserver, this.date, this.licensePlate, this.speed);
		}
	}

}
