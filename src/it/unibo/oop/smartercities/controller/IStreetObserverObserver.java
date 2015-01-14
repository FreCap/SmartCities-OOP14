package it.unibo.oop.smartercities.controller;

import it.unibo.oop.smartercities.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smartercities.datatype.I.IStreetObserver;

// questo observer ha il compito di chiedere al controller delle info relative ad uno StreetObserver,
// quando viene richiesto dalla GUI

@FunctionalInterface
public interface IStreetObserverObserver{
	
	IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver);
}
