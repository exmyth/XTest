package com.exmyth.test.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.exmyth.test.mina.handle.MyServerHandler;

public class MinaServer {

	public static void main(String[] args) {
		try {
			NioSocketAcceptor acceptor = new NioSocketAcceptor();
			acceptor.setHandler(new MyServerHandler());
			acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyTextLineFactory()));
//			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
			acceptor.bind(new InetSocketAddress(9898));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}