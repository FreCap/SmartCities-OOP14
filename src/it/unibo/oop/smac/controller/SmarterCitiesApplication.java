package it.unibo.oop.smac.controller;

import it.unibo.oop.smac.simulator.client.SightingSenderClient;
import it.unibo.oop.smac.view.gui.stolencars.ViewGUIStolenCars;
import it.unibo.oop.smac.view.network.NetServer;

/**
 * Esempio di avvio dell'applicazione.
 * 
 * @author Federico Bellini
 * @author Francesco Capponi
 */
public final class SmarterCitiesApplication {

  /**
   * Numero di auto in circolazione nel tracciato.
   */
  private static final int N_CARS = 2;

  private SmarterCitiesApplication() {
  }

  /**
   * Main dell'applicazione. Avvia i servizi e l'interfaccia grafica.
   * 
   * @param varargs
   *          Parametri passati all'applicazione. NON utilizzati.
   * @throws InterruptedException
   *           Chiusura forzata dell'applicazione
   */
  public static void main(final String... varargs) throws InterruptedException {

    // creazione del controller e della view
    final IController controller = new StolenCarsController(new ViewGUIStolenCars());

    // creazione del server e dei client ad esso connessi
    new NetServer(controller);

    for (int i = 0; i < N_CARS; i++) {
      Thread.sleep(1000); // garantisce un distacco tra le due auto
      new Thread(new SightingSenderClient()).start();
    }
  }

}
