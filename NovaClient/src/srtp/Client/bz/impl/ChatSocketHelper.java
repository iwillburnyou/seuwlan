package src.srtp.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import k.FeedBackMMS;
import k.MyMessage;

public class ChatSocketHelper {
	private static Socket socket= null;
	private static ObjectInputStream ois = null;
	private static ObjectOutputStream oos= null;
	private static final String add = "127.0.0.1";
	private static final int port = 9090;
	private static ChatReceiveThread ch= null;
	
	public static void getConection() {
		try {
			socket = new Socket(add, port);
			
			System.out.println("chat socket ready 9090...");
			//
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("运行到 oos = new ObjectOutputStream(socket.getOutputStream());");
			/**
			 * stuck
			 */
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("运行到 ois = new ObjectInputStream(socket.getInputStream());");
			ch = new ChatReceiveThread(ois);
			//System.out.println(30);
			ch.start();
		} catch (Exception e) {
			System.err.println("chat socket error...");
			e.printStackTrace();
		}
	}

	public static void Send(FeedBackMMS mms) {
		try {
			oos.writeObject(mms);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		ch.stop();
		try {
			if(ois != null) {
				ois.close();
				ois = null;
			}
			
			if(oos !=null) {
				oos.close();
				oos = null;
			}
			
			if(socket != null) {
				socket.close();
				socket = null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
