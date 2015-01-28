package it.unibo.oop.smac.controller;

import java.util.Date;
import java.util.Random;

import it.unibo.oop.smac.datatype.Coordinates;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.datatype.Sighting;
import it.unibo.oop.smac.datatype.StreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.view.ViewGUI;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final IController controller = new Controller(new ViewGUI());
		
		StreetObserver<Coordinates> so1 =  new StreetObserver<>(new Coordinates(44.139625f, 12.235225f));
		StreetObserver<Coordinates> so2 =  new StreetObserver<>(new Coordinates(44.131771f, 12.268767f));
		StreetObserver<Coordinates> so3 =  new StreetObserver<>(new Coordinates(44.14464f, 12.24114f));
		
		controller.addStreetObserver(so1);
		controller.addStreetObserver(so2);
		controller.addStreetObserver(so3);
		
		Thread.sleep(2000);
		
		ISighting s = new Sighting.Builder().date(new Date())
											.streetObserver(so1)
											.speed(50.03f)
											.licensePlate(new LicensePlate("AB 000 EF"))
											.build();
											
		Random r = new Random();
		while(true){
			try {
				int t = r.nextInt(1000) + 100;
				Thread.sleep(t);
				if(t % 2 == 0) {
					controller.newPassage(so1, s);
				} else if(t % 15 == 0) {
					controller.newPassage(so2, s);
				} else {
					controller.newPassage(so3, s);
				}
			}
			catch(Exception e) {
			}
		}
	}
}
