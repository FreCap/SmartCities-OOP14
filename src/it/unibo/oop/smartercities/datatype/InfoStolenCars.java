package it.unibo.oop.smartercities.datatype;

import java.util.Date;

// TODO
// pacchetto in informazioni che il database restituisce alla gui quando
// la gui chiede al database delle info su una determinata targa
public class InfoStolenCars {
	
	private NumberPlate np;
	private Date dataRubata;
	
	public InfoStolenCars(){
		//TODO
	}
	
	public Date getDataRubata() {
		return dataRubata;
	}
	public NumberPlate getNp() {
		return np;
	}
}