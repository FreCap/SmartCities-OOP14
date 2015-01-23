package it.unibo.oop.smac.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import it.unibo.oop.smac.network.jobs.StolenCarsChecker;
import it.unibo.oop.smac.network.jobs.StreetObserverLogger;

public final class NetServer {

	public static final int PORT = Integer
			.parseInt(System.getProperty("port", "8007"));

	public static void initJobs() {
		Dispatcher.getInstance().addObserver(new StreetObserverLogger());
		Dispatcher.getInstance().addObserver(new StolenCarsChecker());

	}

	public static ChannelInitializer<SocketChannel> channelInitializer = new ChannelInitializer<SocketChannel>() {
		@Override
		public void initChannel(SocketChannel ch) throws Exception {
			ChannelPipeline p = ch.pipeline();

			p.addLast(new ObjectEncoder(),
					new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
					new ServerHandler());
		}
	};

	public static void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				initJobs();
				
				// nuovi workers
				EventLoopGroup bossGroup = new NioEventLoopGroup(1);
				EventLoopGroup workerGroup = new NioEventLoopGroup();
				try {
					ServerBootstrap b = new ServerBootstrap();
					b.group(bossGroup, workerGroup)
							.channel(NioServerSocketChannel.class)
							.childHandler(channelInitializer);

					// Starto il server e accetto le connessioni
					b.bind(PORT).sync().channel().closeFuture().sync();
				} catch (Exception e) {
					// server terminato in modo anomalo
					e.printStackTrace();

				} finally {
					bossGroup.shutdownGracefully();
					workerGroup.shutdownGracefully();
				}
			}
		});

	}

}