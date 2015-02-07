package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.I.IInfoStolenCar;

import java.util.List;

public interface IStolenCarsObserver{

	public List<IInfoStolenCar> getStolenCarsInfoList();
	void addNewStolenCar(LicensePlate licensePlate);

}