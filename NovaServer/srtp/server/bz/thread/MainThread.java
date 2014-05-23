package srtp.server.bz.thread;


/**
 * 程序服务端开启服务功能时的线程，主线程
 * 支持多用户同时登录操作
 */


import java.io.IOException;
import java.net.*;

import srtp.server.view.*;
/**
 * 服务器端的主要线程类，负责挂起服务器和启动针对每个连接用户的多线程
 * @author 王一多
 */
public class MainThread extends Thread {
	private Socket socket; // 用于对客户端的通信
	private ServerSocket server = null; // 服务端server

/**
 * 主线程的构造函数
 */
	public MainThread() {
		this.start();		//启动服务主线程
		System.out.println("启动！");
	}
	
	/**
	 * 关闭服务函数，关闭服务端
	 */
	public void close() {
		try {
			this.stop();
			if (socket != null ) {
				if(!socket.isClosed()) {
					socket.close();		//socket关闭
					System.out.println("socket关闭！");
				}
				socket = null;
				
			}
			if (server!=null) {
					server.close();		//serverSocket关闭
					System.out.println("serverSocket关闭！");
				server = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 线程run函数
	 */
	@Override
	public void run() {
		try {
			server = new ServerSocket(5678);
			System.out.println("我是服务器，在5678端口监听");
			// 阻塞,等待连接
			while (true) {
				//当有新用户登录时，构造连接
				socket = server.accept();
				System.out.println("连接成功");
				
				
				// 接收客户端发来的信息.
				new SubThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				server.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
