package it.unibo.oop.smac.test.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import it.unibo.oop.smac.datatype.LicensePlate;
import it.unibo.oop.smac.network.NetServer;

public final class SightingSenderClient implements Runnable {

	static final String HOST = System.getProperty("host", "127.0.0.1");
	static final int PORT = NetServer.PORT;

	public final TrackSimulator trackSimulator = new TrackSimulator(
			LicensePlateTest.generate());

	public final ChannelInitializer<SocketChannel> channelInitializer = new ChannelInitializer<SocketChannel>() {
		@Override
		public void initChannel(SocketChannel ch) throws Exception {
			ChannelPipeline p = ch.pipeline();

			p.addLast(new ObjectEncoder(),
					new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
					new SightingSenderClientHandler(trackSimulator));
		}
	};

	public void run() {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.handler(channelInitializer);
			b.connect(HOST, PORT).sync().channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO un client è morto indispettito
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}

	}
}