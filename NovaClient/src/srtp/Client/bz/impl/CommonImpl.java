package src.srtp.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import src.srtp.Client.util.SocketHelper;

import k.MessageType;
import k.MyMessage;

public class CommonImpl {
	private static ObjectInputStream is;
	public static ObjectOutputStream os;
	static MyMessage serverRe = null; // ���������ص�message


	public static void initSocket() throws UnknownHostException, IOException {
		SocketHelper.getConnection();
		is = SocketHelper.getIs();
		os = SocketHelper.getOs();
	}
	public static void closeSocket() {
		SocketHelper.close();
		try {
			if (is != null)
				is.close();
			if (os != null)
				os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public CommonImpl() throws UnknownHostException, IOException {
		//initSocket();
	}


	public static MyMessage sendMessage(MyMessage mm) {
		try {
			//os.writeInt(61);
			System.out.println("send message "+mm.getCmd());
			//initSocket();
			os.writeObject(mm );
			os.flush();
			if (mm.getCmd() != -1) {
				serverRe = (MyMessage) is.readObject();
			}
			
			//System.out.println(serverRe);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			return serverRe;
			
		}
	
}
}
