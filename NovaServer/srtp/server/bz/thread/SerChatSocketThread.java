package srtp.server.bz.thread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import k.FeedBackMMS;


public class SerChatSocketThread extends Thread {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket socket;
	private SerReceiveThread ch;
	
	public SerChatSocketThread(Socket socket) {
		this.socket = socket;
		System.out.println("sss socket...");
	}

	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			ch = new SerReceiveThread(ois);
			ch.start();
			while (socket.isConnected());
			System.out.println("connect");
			this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Send(FeedBackMMS mms) {
		try {
			oos.writeObject(mms);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		System.out.println("thread closed...");
		ch.interrupt();
		this.interrupt();
		try {
			if(oos != null) {
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
