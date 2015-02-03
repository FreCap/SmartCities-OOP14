package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.datatype.I.IInfoStolenCar;
import it.unibo.oop.smac.datatype.I.IStolenCar;

// TODO per fra.
// questo observer ha il compito di chiedere al controller delle info relative ad una StolenCars,
// quando viene richiesto dalla GUI

@FunctionalInterface
public interface IStolenCarsObserver{
	
	IInfoStolenCar getStolenCarsInfo(IStolenCar stolenCar);

}