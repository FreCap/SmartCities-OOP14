package it.unibo.oop.smac.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Observable;

/**
 * Classe le operazioni effettuate dal server di rete all'invio e alla ricezioni di messaggi dal
 * client
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

  /**
   * dispatcher che implementa l'interfaccia Observable per la notifica dei jobs dell'arrivo di un
   * determinato messaggio
   */
  private final Observable dispatcher;

  /**
   * Costruttore della classe.
   * 
   * @param dispatcher
   *          dell'applicazione su cui verranno richiamate le funzioni di segnalazione all'arrivo di
   *          eventi dalla rete
   */
  ServerHandler(final Observable dispatcher) {
    this.dispatcher = dispatcher;
  }

  /**
   * Metodo che alla ricezione di un determinato messaggio, notifica tutti i job che stanno
   * osservando il dispatcher.
   */
  @Override
  public void channelRead(final ChannelHandlerContext ctx, final Object msg) {
    dispatcher.notifyObservers(msg);
  }

  /**
   * Effettua il flush dei dati nel buffer.
   */
  @Override
  public void channelReadComplete(final ChannelHandlerContext ctx) {
    ctx.flush();
  }

  /**
   * Nel caso in cui la connessione cada, vada in timeout o accada qualsiasi altro errore, viene
   * generata un'exception e terminata la connessione.
   */
  @Override
  public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }

}