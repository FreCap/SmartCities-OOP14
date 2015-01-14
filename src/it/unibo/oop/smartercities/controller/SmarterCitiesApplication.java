package it.unibo.oop.smartercities.controller;

import java.util.Random;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.StreetObserver;
import it.unibo.oop.smartercities.view.ViewGUI;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final IController controller = new Controller(new ViewGUI());
		
		StreetObserver so1 =  new StreetObserver(new Coordinates<>(44.139625, 12.235225));
		StreetObserver so2 =  new StreetObserver(new Coordinates<>(44.131771, 12.268767));
		StreetObserver so3 =  new StreetObserver(new Coordinates<>(21.306944, -157.858333));
		
		controller.addStreetObserver(so1);
		controller.addStreetObserver(so2);
		controller.addStreetObserver(so3);
		
		Thread.sleep(2000);
		
		Random r = new Random();
		while(true){
			try {
				int t = r.nextInt(1000) + 100;
				Thread.sleep(t);
				if(t % 2 == 0) {
					controller.newPassage(so1, null);
				} else if(t % 15 == 0) {
					controller.newPassage(so2, null);
				} else {
					controller.newPassage(so3, null);
				}
			}
			catch(Exception e) {
			}
		}
	}
}
