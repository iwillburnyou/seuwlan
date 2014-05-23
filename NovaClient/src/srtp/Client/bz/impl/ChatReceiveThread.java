package src.srtp.Client.bz.impl;

import k.FeedBackMMS;
import src.srtp.Client.view.FeedBack;
import java.io.ObjectInputStream;

public class ChatReceiveThread extends Thread {
	private ObjectInputStream ois;
	private static FeedBackMMS mms = null;
	public ChatReceiveThread(ObjectInputStream ois) {
		this.ois = ois;
	}
	
	public void run() {
		try {
			while (true) {
				setMms((FeedBackMMS) ois.readObject());
				String string = FeedBack.getTextArea().getText() + "\nFrom : " + mms.getCardNo() + "\n" + mms.getText();
				// to show on the window!
				FeedBack.getTextArea().setText(string);
				System.out.println("mms receive..");
			}
		} catch (Exception e) {
			System.out.println("chat receive down...");
			e.printStackTrace();
		}
	}

	public static FeedBackMMS getMms() {
		return mms;
	}

	public static void setMms(FeedBackMMS mms) {
		ChatReceiveThread.mms = mms;
	}
	
}
