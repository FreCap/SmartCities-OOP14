package it.unibo.oop.smartercities.control;

import it.unibo.oop.smartercities.view.ViewGUI;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) {
		
		final ControllerInterface controller = new Controller(new ViewGUI());
		
		controller.pluginRequest(44.139625, 12.235225);
		controller.pluginRequest(44.131771, 12.268767);
		controller.pluginRequest(21.306944, -157.858333);
		controller.pluginRequest(0.0, 0.0);
	}
}
