package it.unibo.oop.smartercities.control;

import java.util.Random;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.view.ViewGUI;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final ControllerInterface controller = new Controller(new ViewGUI());
		
		Coordinates<Double> c1 = new Coordinates<>(44.139625, 12.235225);
		Coordinates<Double> c2 = new Coordinates<>(44.131771, 12.268767);
		Coordinates<Double> c3 = new Coordinates<>(21.306944, -157.858333);
		
		controller.pluginRequest(c1);
		controller.pluginRequest(c2);
		controller.pluginRequest(c3);
		
		Thread.sleep(2000);
		
		Random r = new Random();
		while(true){
			try {
				int t = r.nextInt(1000) + 100;
				Thread.sleep(t);
				if(t % 2 == 0) {
					controller.newPassage(c2, null);
				}
				else if(t % 15 == 0) {
					controller.newPassage(c3, null);
				}
				else {
					controller.newPassage(c1, null);
				}
				
			}
			catch(Exception e) {
			}
		}
	}
}
