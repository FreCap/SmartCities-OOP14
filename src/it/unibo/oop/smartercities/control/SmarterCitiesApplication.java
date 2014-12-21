package it.unibo.oop.smartercities.control;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.view.ViewGUI;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) {
		
		final ControllerInterface controller = new Controller(new ViewGUI());
		
		Coordinates c1 = new Coordinates(44.139625, 12.235225);
		Coordinates c2 = new Coordinates(44.131771, 12.268767);
		Coordinates c3 = new Coordinates(21.306944, -157.858333);
		Coordinates c4= new Coordinates(0.0, 0.0);
		
		controller.pluginRequest(c1);
		controller.pluginRequest(c2);
		controller.pluginRequest(c3);
		controller.pluginRequest(c4);
	}
}
