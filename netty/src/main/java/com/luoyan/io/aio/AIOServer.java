package com.luoyan.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {

	AsynchronousServerSocketChannel server;

	ByteBuffer receviceBuff = ByteBuffer.allocate(1024);

	int port = 8080;

	public AIOServer(int port) throws IOException{
		this.port = port;
		//要想富，先修路
		server = AsynchronousServerSocketChannel.open();

		server.bind(new InetSocketAddress("localhost", this.port));

	}

	public void listener(){
		new Thread(){
			public void run() {
				System.out.println("AIO服务已启动，监听端口" + port);
				server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
					//成功以后的回调
					public void completed(AsynchronousSocketChannel client,Void attachment) {
						server.accept(null,this);
						process(client);
					}

					public void failed(Throwable exc, Void attachment) {
						System.out.println("异步IO失败");
					}

					private void process(AsynchronousSocketChannel client){
						try{
							receviceBuff.clear();
							int len = client.read(receviceBuff).get();
							receviceBuff.flip();
							System.out.println("已接收到客户端发来的消息：" + new String(receviceBuff.array(),0,len));
						}catch(Exception e){

						}
					}

				});
				while(true){}
			}
		}.run();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		new AIOServer(8080).listener();
		Thread.sleep(20000);
	}

}
