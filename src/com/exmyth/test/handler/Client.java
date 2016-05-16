package com.exmyth.test.handler;

import com.exmyth.test.handler.LooperThread.Message;

public class Client {
	public static void main(String[] args) {
		final LooperThread looper = new LooperThread();
		looper.start();
		for (int i = 0; i < 10; i++) {
			final Message message = new LooperThread.Message();
			message.what = i;
			message.data = "data"+i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					looper.sendMessage(message);
				}
			}).start();
			
		}
	}
}
