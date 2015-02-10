package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;

import javax.swing.JPanel;

/**
 * Interfaccia di un panel contenente la gestione delle stolen cars.
 */
public interface IStolenCarsPanel {

  /**
   * Attacca un {@link IStolenCarsObserver} degli StolenCars.
   * 
   * @param sco
   *          L'{@link IStolenCarsObserver} da attaccare.
   */
  void attachStolenCarsObserver(IStolenCarsObserver sco);

  /**
   * Restituisce l'{@link IStolenCarsObserver}
   * 
   * @return restituisce il {@link IStolenCarsObserver} corrente.
   * @throws IllegalStateException
   *           nel caso in cui non ci sia ancora alcun observer
   */
  IStolenCarsObserver getStolenCarsObserver() throws IllegalStateException;

  /**
   * Restituisce il {@link JPanel}.
   * 
   * @return Il {@link JPanel}.
   */
  JPanel getPanel();
}
