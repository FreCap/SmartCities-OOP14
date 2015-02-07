package it.unibo.oop.smac.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Observable;

/**
 * Classe le operazioni effettuate dal server di rete all'invio e alla ricezioni
 * di messaggi dal client
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * dispatcher che implementa l'interfaccia Observable per la notifica dei
	 * jobs dell'arrivo di un determinato messaggio
	 */
	private final Observable dispatcher;

	/**
	 * Costruttore della classe
	 * 
	 * @param dispatcher
	 */
	ServerHandler(Observable dispatcher) {
		this.dispatcher = dispatcher;
	}

	/**
	 * Metodo che alla ricezione di un determinato messaggio, notifica tutti i
	 * job che stanno osservando il dispatcher
	 */
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		dispatcher.notifyObservers(msg);
	}

	/**
	 * Effettua il flush dei dati nel buffer
	 */
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	/**
	 * Nel caso in cui la connessione cada, vada in timeout o accada qualsiasi
	 * altro errore, viene generata un'exception e terminata la connessione
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}