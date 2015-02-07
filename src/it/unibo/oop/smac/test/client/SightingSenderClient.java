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
import it.unibo.oop.smac.network.NetServer;

/**
 * Classe che gestisce l'apertura della connessione di un simulatore sighting
 * tra client-serer
 */
public final class SightingSenderClient implements Runnable {

	/**
	 * Costante dell'indirizzo del server cui collegarsi
	 */
	static final String HOST = System.getProperty("host", "127.0.0.1");

	/**
	 * Costante della porta del server cui collegarsi
	 */
	static final int PORT = NetServer.PORT;

	/**
	 * Genero in maniera random un nuovo trackSimulator da utilizzare durante la
	 * connessione
	 */
	public final TrackSimulator trackSimulator = new TrackSimulator(
			LicensePlateTest.generate());

	/**
	 * Inizializzazione dell'inizializzatore di un nuovo channel (connessione)
	 */
	public final ChannelInitializer<SocketChannel> channelInitializer = new ChannelInitializer<SocketChannel>() {
		@Override
		public void initChannel(SocketChannel ch) throws Exception {
			ChannelPipeline p = ch.pipeline();

			// imposto gli encoder-decoder che incapsulano i messaggi della
			// connessione, e l'handler che gestisce gli eventi di scambio
			// messaggi
			p.addLast(new ObjectEncoder(),
					new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
					new SightingSenderClientHandler(trackSimulator));
		}
	};

	/**
	 * Metodo che fa partire il processo di connessione
	 */
	public void run() {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			// inizializzo i parametri di connessione
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.handler(channelInitializer);

			// faccio partire la connessione
			b.connect(HOST, PORT).sync().channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// un client è morto indispettito
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}

	}
}