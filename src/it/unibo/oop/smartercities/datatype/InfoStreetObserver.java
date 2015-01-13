package it.unibo.oop.smartercities.datatype;

// pacchetto di info che il database restituisce alla gui quando la gui richiede di avere
// delle info su di uno street observer dal database
public class InfoStreetObserver {
	private final Coordinates<Double> c;
	private final int numeroAvvistamenti;
	private final double velocitaMedia;
	private final int velocitaMax;
	
	public InfoStreetObserver(Coordinates<Double> c, int numeroAvvistamenti, double velocitaMedia, int velocitaMax) {
		super();
		this.c = c;
		this.numeroAvvistamenti = numeroAvvistamenti;
		this.velocitaMedia = velocitaMedia;
		this.velocitaMax = velocitaMax;
	}

	public Coordinates<Double> getC() {
		return c;
	}

	public int getNumeroAvvistamenti() {
		return numeroAvvistamenti;
	}

	public double getVelocitaMedia() {
		return velocitaMedia;
	}

	public int getVelocitaMax() {
		return velocitaMax;
	}

}
