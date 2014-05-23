
package src.srtp.Client.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import k.MyMessage;
import src.srtp.Client.bz.impl.CommonImpl;
import src.srtp.Client.view.FeedBack;

public class SocketHelper {

	private static String StuId;
	private static Socket socket = null; // ����socket����
	private static ObjectOutputStream os =null; // �����������
	private static ObjectInputStream is = null; // �����������


	public static void getConnection() throws UnknownHostException, IOException {
		
			socket = new Socket("127.0.0.1", 5678); 
			//System.out.println("�ͻ���socket����");
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());

//		} catch (UnknownHostException e) {
//			System.out.println("offline");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("1");
//			e.printStackTrace();
//		}
	}

	/**
	 * ��ö��������
	 * 
	 * @return ObjectOutputStream
	 */
	public static ObjectOutputStream getOs() {
		return os;
	}

	/**
	 * ���ö��������
	 * 
	 * @param os
	 */
	public static void setOs(ObjectOutputStream os) {
		SocketHelper.os = os;
	}

	/**
	 * ��ö���������
	 * 
	 * @return ObjectInputStream
	 */
	public static ObjectInputStream getIs() {
		return is;
	}

	/**
	 * ���ö�����������
	 * 
	 * @param is
	 */
	public static void setIs(ObjectInputStream is) {
		SocketHelper.is = is;
	}

	/**
	 * �������������ӵ�Socket
	 * 
	 * @return Socket
	 */
	public static Socket getSocket() {
		return socket;
	}

	/**
	 * ����Socket
	 * 
	 * @param socket
	 */
	public static void setSocket(Socket socket) {
		SocketHelper.socket = socket;
	}
	
	public static void close() {
		try {
			FeedBack.closed();
			CommonImpl.sendMessage(new MyMessage(-1,1));
			if(is !=null) {
				is.close() ;is = null;
			}
			
			if(os !=null) {
				os.close() ; os = null;
			}
			
			if(socket !=null) {
				socket.close() ; socket = null;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
