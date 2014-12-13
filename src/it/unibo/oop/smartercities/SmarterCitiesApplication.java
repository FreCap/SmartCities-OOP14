package it.unibo.oop.smartercities;

public class SmarterCitiesApplication {

	private SmarterCitiesApplication() {
	}
	
	public static void main(String[] args) {
		
		final SCViewInterface v = new SCViewGUI();
		final SCViewObserverInterface c = new SCController(v);
		
		c.pluginRequest(0, 44.139625, 12.235225);
		c.pluginRequest(1, 44.131771, 12.268767);
		c.pluginRequest(2, 21.306944, -157.858333);
		c.pluginRequest(3, 0.0, 0.0);
	}
}
