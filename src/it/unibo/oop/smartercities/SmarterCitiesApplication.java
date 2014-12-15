package it.unibo.oop.smartercities;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) {
		
		final SCViewObserverInterface controller = new SCController(new SCViewGUI());
		
		controller.pluginRequest(44.139625, 12.235225);
		controller.pluginRequest(44.131771, 12.268767);
		controller.pluginRequest(21.306944, -157.858333);
		controller.pluginRequest(0.0, 0.0);
	}
}
