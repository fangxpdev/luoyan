package com.luoyan.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NIOServer {
	int port = 8080;
	ServerSocketChannel server;

	Selector selector;


	ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
	ByteBuffer sendBuffer = ByteBuffer.allocate(1024);


	Map<SelectionKey,String> sessionMsg = new HashMap<SelectionKey,String>();

	public NIOServer(int port) throws IOException{

		this.port = port;
		//就相当于是高速公路，同时开几排车,带宽，带宽越大，车流量就越多
		server = ServerSocketChannel.open();

		//关卡也打开了，可以多路复用了
		server.socket().bind(new InetSocketAddress(this.port));
		//默认是阻塞的，手动设置为非阻塞，它才是非阻塞
		server.configureBlocking(false);

		//叫号系统开始工作
		selector = Selector.open();

		//高速管家，BOSS已经准备就绪，等会有客人来了，要通知我一下
		//我感兴趣的事件
		SelectionKey register = server.register(selector, SelectionKey.OP_ACCEPT);

		System.out.println("NIO服务已经启动，监听端口是：" + this.port);
	}


	public void listener() throws IOException{
		//轮询
		while(true){
			//判断一下，当前有没有客户来注册，有没有排队的，有没有取号的
			//没有你感兴趣的事件触发的时候，它还是阻塞在这个位置
			//只要有你感兴趣的事件发生的时候，程序才会往下执行
			int i = selector.select();//这个位置，还是一个阻塞的

			if(i == 0){ continue;}

			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = keys.iterator();

			while (iterator.hasNext()) {

				//来一个处理一个
				process(iterator.next());

				//处理完之后打发走
				iterator.remove();

			}

		}


	}


	private void process(SelectionKey key) throws IOException{

		//判断客户有没有跟我们BOSS建立好连接
		if(key.isAcceptable()){
			SocketChannel client = server.accept();
			client.configureBlocking(false);
			//继续告诉叫号系统，下一步我要开始读数据了，记得通知我
			client.register(selector, SelectionKey.OP_READ);
		}
		//判断是否可以读数据了
		else if(key.isReadable()){
			receiveBuffer.clear();

			//这条管道是交给我们NIO API内部去处理的
			SocketChannel client = (SocketChannel)key.channel();
			int len = client.read(receiveBuffer);
			if(len > 0){
				String msg = new String(receiveBuffer.array(), 0, len);
				sessionMsg.put(key, msg);
				System.out.println("获取客户端发送来的消息：" + msg);
			}
			//告诉叫号系统，下一个我感兴趣的事件就是要写数据了
			client.register(selector, SelectionKey.OP_WRITE);
		}
		//是否可以写数据
		else if(key.isWritable()){


			if(!sessionMsg.containsKey(key)){ return;}

			SocketChannel client = (SocketChannel)key.channel();

			sendBuffer.clear();

			sendBuffer.put(new String(sessionMsg.get(key) + ",你好，您的请求已处理完成").getBytes());

			sendBuffer.flip();//
			client.write(sendBuffer);
			//再告诉我们叫号系统，下一个我要关心的动作，又是读了
			//如此反复，我们的程序就陷入到了一个银行取款的同步陷阱里面去了的
			client.register(selector,SelectionKey.OP_READ);
			//SelectionKey.OP_ACCEPT//服务端，只要客户端连接，就触发
			//SelectionKey.OP_CONNECT//客户端，只要连上了服务端，就触发
			//SelectionKey.OP_READ//只要发生读操作，就触发
			//SelectionKey.OP_WRITE//只要发生写操作，就触发

		}

	}


	public static void main(String[] args) throws IOException {
		new NIOServer(8080).listener();
	}
}
