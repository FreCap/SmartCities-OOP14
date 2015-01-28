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
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import it.unibo.oop.smac.controller.IController;
import it.unibo.oop.smac.network.jobs.ControllerSightingSender;

public class NetServer {

	static final String HOST = System.getProperty("host", "127.0.0.1");
	public static final int PORT = Integer.parseInt(System.getProperty("port",
			"8007"));
	private final Dispatcher dispatcher;

	public NetServer(IController controller) {
		this.dispatcher = new Dispatcher(controller);
		dispatcher.addObserver(new ControllerSightingSender());
		run();
	}

	public ChannelInitializer<SocketChannel> channelInitializer = new ChannelInitializer<SocketChannel>() {
		@Override
		public void initChannel(SocketChannel ch) throws Exception {
			ChannelPipeline p = ch.pipeline();

			p.addLast(new ObjectEncoder(),
					new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
					new ServerHandler(dispatcher));
		}
	};

	public void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {

				EventLoopGroup bossGroup = new NioEventLoopGroup(1);
				EventLoopGroup workerGroup = new NioEventLoopGroup();
				try {
					ServerBootstrap b = new ServerBootstrap();
					b.group(bossGroup, workerGroup)
							.channel(NioServerSocketChannel.class)
							.handler(new LoggingHandler(LogLevel.INFO))
							.childHandler(
									new ChannelInitializer<SocketChannel>() {
										@Override
										public void initChannel(SocketChannel ch)
												throws Exception {
											ChannelPipeline p = ch.pipeline();

											p.addLast(
													new ObjectEncoder(),
													new ObjectDecoder(
															ClassResolvers
																	.cacheDisabled(null)),
													new ServerHandler(
															dispatcher));
										}
									});

					// Bind and start to accept incoming connections.
					b.bind(PORT).sync().channel().closeFuture().sync();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					bossGroup.shutdownGracefully();
					workerGroup.shutdownGracefully();
				}
			}
		}).start();
	}

}