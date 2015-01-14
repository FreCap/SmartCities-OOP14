package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;

// pacchetto di info che il database restituisce alla gui quando la gui richiede di avere
// delle info su di uno street observer dal database
public class InfoStreetObserver implements IInfoStreetObserver{
	// TODO trasforma i campi in Optional
	private Coordinates<Double> c;
	private int numeroAvvistamenti;
	private int numeroAvvistamentiUltimoMese;
	private double velocitaMedia;
	private int velocitaMax;
	
	public InfoStreetObserver() {
		super();
	}

	public Coordinates<Double> getC() {
		return c;
	}

	public void setC(Coordinates<Double> c) {
		this.c = c;
	}

	public int getNumeroAvvistamenti() {
		return numeroAvvistamenti;
	}

	public void setNumeroAvvistamenti(int numeroAvvistamenti) {
		this.numeroAvvistamenti = numeroAvvistamenti;
	}

	public int getNumeroAvvistamentiUltimoMese() {
		return numeroAvvistamentiUltimoMese;
	}

	public void setNumeroAvvistamentiUltimoMese(int numeroAvvistamentiUltimoMese) {
		this.numeroAvvistamentiUltimoMese = numeroAvvistamentiUltimoMese;
	}

	public double getVelocitaMedia() {
		return velocitaMedia;
	}

	public void setVelocitaMedia(double velocitaMedia) {
		this.velocitaMedia = velocitaMedia;
	}

	public int getVelocitaMax() {
		return velocitaMax;
	}

	public void setVelocitaMax(int velocitaMax) {
		this.velocitaMax = velocitaMax;
	}

}
