package src.srtp.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;

import src.srtp.Client.bz.impl.*;

import k.MyMessage;
import k.User;


public class LoginImpl extends CommonImpl{

	public LoginImpl() throws UnknownHostException, IOException {
		super();	
	}

	public static User getMessage(String string) {
		MyMessage mm = new MyMessage(k.MessageType.GET_MESSAGE, string);
		serverRe = sendMessage(mm);
		return (User)serverRe.getOb();
	}
	public static MyMessage logIn(String name,String psd) {
		User u = new User();
		u.setCardNo(name);
		u.setPsd(psd);
		
		MyMessage mm = new MyMessage(k.MessageType.LOGIN,u);
		serverRe = sendMessage(mm);
		
		return serverRe;
		
	}



	public static void changePsd(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_PSD,sql);
		serverRe = sendMessage(mm);	
	}

	public static boolean registerNew(User u) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.REGISTER_NEW,u);
		serverRe = sendMessage(mm);	
		if (serverRe.getCmd() == k.MyMessage.SERVER_OPERATION_SUCC) 
			return  true;
			
		else
			return false;
	}
	

}