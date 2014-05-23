package srtp.server.bz.thread;

/**
 * 服务端子线程。每个在线用户唯一对应一个子线程
 * 在用户登录，或新用户申请注册时建立
 * 
 * @see Thread, MessageType
 * 
 */

import java.io.*;
import java.net.*;
import java.sql.SQLException;

import k.MyMessage;
import k.MessageType;

import srtp.server.bz.impl.CommonImpl;
import srtp.server.bz.impl.StuInfoImpl;
import srtp.server.view.ServerView;

//import server.bz.intf.ICanteenServerImpl;
//import server.bz.intf.ICourseServerImpl;
//import server.bz.intf.IFeedbackServerImpl;
//import server.bz.intf.ILibraryServerImpl;
//import server.bz.intf.ILogInServerImpl;
//import server.bz.intf.IShopServerImpl;
//import server.bz.intf.IStuInfoServerImpl;
//import server.view.ServerView;
//import common.MessageType;
/**
 * 服务器每个连接上服务器用户的子线程类
 * 
 * @author 王一多
 */
public class SubThread extends Thread {

	private ObjectInputStream is;
	private ObjectOutputStream os;
	private Socket socket; // 与用户通信所需连接
	// private int cmd; //用户操作指令，为MessageType中的一个成员
	private MyMessage mm; // 接收客户发来的信息，也作为回馈信息返回给客户端

	public SubThread() {
	}

	/**
	 * 服务器针对每个连接客户的分线程的构造函数
	 * 
	 * @author 王一多
	 */
	public SubThread(Socket socket) {
		this.socket = socket; // 接收socket参数

		// 建立连接
		try {
			(ServerView.count)++;
			is = new ObjectInputStream(this.socket.getInputStream());
			os = new ObjectOutputStream(this.socket.getOutputStream());
			System.out.println("服务器端socket流获取");
		} catch (IOException e) {
			(ServerView.count)--; // 连接建立失败
			e.printStackTrace();
		}

	}

	/**
	 * run函数实现用户在客户端与服务端的通信，一次接受一個消息
	 * 
	 * MessageType中，通过不同模块占用不同命令区间来区分模块区间
	 * 
	 */
	@Override
	public void run() {
		while (!socket.isClosed()) {
			try {
				mm = (MyMessage) is.readObject(); // 接收新命令，为MessageType中的一个成员,阻塞方法!
				if (mm.getCmd() == -1) {
					ServerView.count--;
					try {
						os.close();
						is.close();
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
					
				}
				if (CommonImpl.executeCmd(mm)) {
					mm.setCmd(MessageType.SERVER_OPERATION_SUCC);
					
				} else {
					mm.setCmd(MessageType.SERVER_OPERATION_FAIL);
					mm.setOb("cmd执行出错啦");
				}

			} catch (SQLException eSQL) {

				eSQL.printStackTrace();
				mm.setCmd(MessageType.SERVER_OPERATION_FAIL);
				mm.setOb("输入数据不合法，被服务器拒绝");
			} catch (Exception e) {
				if (mm != null)
					mm.setCmd(MessageType.SERVER_OPERATION_FAIL);
				e.printStackTrace();
			} finally {
				try {
					// 返回给客户端的消息
					if(mm.getCmd() !=-1) {
						os.writeObject(mm);
						os.flush();
					}
					
				} catch (IOException e2) {
					System.out.println("返回给客户端的消息失败，client offline！");
					ServerView.count--;
					try {
						if (os!=null) {
							os.close();
						}
						if (is!=null) {
							is.close();
						}
						
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				}
			}

		}
		System.out.println("Main closed!");
	}
}
