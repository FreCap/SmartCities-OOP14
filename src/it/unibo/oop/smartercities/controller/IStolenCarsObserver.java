package it.unibo.oop.smartercities.controller;

import it.unibo.oop.smartercities.datatype.I.IInfoStolenCar;
import it.unibo.oop.smartercities.datatype.I.IStolenCar;

// questo observer ha il compito di chiedere al controller delle info relative ad una StolenCars,
// quando viene richiesto dalla GUI

@FunctionalInterface
public interface IStolenCarsObserver{
	
	IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar);

}