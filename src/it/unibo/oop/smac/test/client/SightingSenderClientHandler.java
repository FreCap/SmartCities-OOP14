package it.unibo.oop.smac.test.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SightingSenderClientHandler extends ChannelInboundHandlerAdapter {

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