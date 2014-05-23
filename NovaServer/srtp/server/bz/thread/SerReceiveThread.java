package srtp.server.bz.thread;


import java.io.IOException;
import java.io.ObjectInputStream;

import k.FeedBackMMS;

public class SerReceiveThread extends Thread {
	private ObjectInputStream ois;
	private static FeedBackMMS mms = null;
	public SerReceiveThread(ObjectInputStream ois) throws IOException {
		this.ois = ois;
	}
	
	public void run() {
		try {
			while (true) {
				setMms((FeedBackMMS) ois.readObject());
				if (-1 == mms.getFlag()) {
					SerChatSocket.removeList(mms.getCardNo()); // to close
					break;
				}
				if (1 == mms.getFlag()) {
					SerChatSocket.sName.add(mms.getCardNo()); // to regist
					continue;
				}
				System.out.println("mms receive...");
				SerChatSocket.Send(mms);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static FeedBackMMS getMms() {
		return mms;
	}

	public static void setMms(FeedBackMMS mms) {
		SerReceiveThread.mms = mms;
	}
	
}
