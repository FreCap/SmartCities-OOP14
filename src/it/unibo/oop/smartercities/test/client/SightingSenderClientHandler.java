package it.unibo.oop.smartercities.test.client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SightingSenderClientHandler extends ChannelHandlerAdapter {

	public TrackSimulator trackSimulator;

	public SightingSenderClientHandler(TrackSimulator trackSimulator) {
		this.trackSimulator = trackSimulator;
	}

	public void channelActive(ChannelHandlerContext ctx) {
		while (true) {
			ctx.writeAndFlush(trackSimulator.next());
		}
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