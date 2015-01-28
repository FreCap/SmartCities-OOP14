package it.unibo.oop.smac.network;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {

	private final Dispatcher dispatcher;

	ServerHandler(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		dispatcher.notifyObservers(msg);
	}

	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}