package srtp.server.bz.thread;


import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import k.FeedBackMMS;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

public class SerChatSocket extends Thread {
	private ServerSocket serverSocket;
	private Socket socket;
	private SerChatSocketThread ch;
	public static LinkedList<SerChatSocketThread> chList = new LinkedList<SerChatSocketThread>(); // regist socket
	public static LinkedList<String> sName = new LinkedList<String>(); // regist name
	
	public SerChatSocket() {
		this.start();
	}
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("9090");
			while (true) {
				socket = serverSocket.accept();
				System.out.println("server socket accept...");
				ch = new SerChatSocketThread(socket);
				ch.start();
				System.out.println(ch);
				chList.add(ch);
			}
		} catch (Exception e) {
			System.err.println("chat socket error...");
			e.printStackTrace();
		}
	}
	
	public static void Send(FeedBackMMS mms) {
		System.out.println(chList.size());
		for (int i = 0; i < sName.size(); i++) {
			if (sName.get(i).equals(mms.getTo())) {
				System.out.println("cout : " + i);
				chList.get(i).Send(mms);
				break;
			}
		}
	}
	
	public static void removeList(String cardNo) {
		System.out.println("remove chList");
		for (int i = 0; i < sName.size(); i++) {
			if (sName.get(i).equals(cardNo)) {
				chList.get(i).close();
				chList.remove(i);
				sName.remove(i);
				break;
			}
		}
	}
	
	public void close() {
		this.stop();
		
		for (int i = 0; i < sName.size(); i++) {
			sName.remove();
			chList.getFirst().close();
			chList.remove();
		}
		try {
			if (socket != null) {
				socket.close();
				socket = null;
			}
			if (serverSocket != null) {
				serverSocket.close();
				serverSocket = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("all chat closed");
	}
}
