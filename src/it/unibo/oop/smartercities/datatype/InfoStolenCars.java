package it.unibo.oop.smartercities.datatype;

import it.unibo.oop.smartercities.datatype.I.IStolenCar;

import java.util.Date;

// TODO
// pacchetto in informazioni che il database restituisce alla gui quando
// la gui chiede al database delle info su una determinata targa
public class InfoStolenCars implements IStolenCar {

	private LicensePlate licensePlate;
	private Date dataInserimento;

	public InfoStolenCars() {
		// TODO
	}

	@Override
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	@Override
	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public Date getInsertionDate() {
		return dataInserimento;
	}

	@Override
	public void setInsertionDate(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
}
