package com.exmyth.test.socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	BufferedWriter writer;

	public static void main(String[] args) {
		SocketServer socketServer = new SocketServer();
		socketServer.startServer();
	}
	
	public void startServer() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9898);
			System.out.println("server started..");
			while (true) {
				socket = serverSocket.accept();
				manageConnection(socket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void manageConnection(final Socket socket) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader reader = null;
				try {
					System.out.println("client " + socket.hashCode() + " connedted");
					reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					/*
					new Timer().schedule(new TimerTask() {
						@Override
						public void run() {
							try {
								writer.write("heart beat once...\n");
								writer.flush();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}, 1000, 1000);
					*/
					String receivedMsg;
					while ((receivedMsg = reader.readLine()) != null) {
						System.out.println("client " + socket.hashCode() + ": " + receivedMsg);
						writer.write("server reply: " + receivedMsg + "\n");
						writer.flush();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						reader.close();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}