package src.srtp.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import k.MessageType;
import k.MyMessage;
import k.bookInfo;

public class MyBag extends CommonImpl {
	public MyBag() throws UnknownHostException, IOException  {
		super();	
	}

	public static boolean addWantBuy(bookInfo bi) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_WANT_BUY,bi);
		serverRe = sendMessage(mm);
		
		if (serverRe.getCmd() == MessageType.SERVER_OPERATION_SUCC) {
			return  true;
		}
		else {
			return false;
		}
		
	}

	public static boolean addWantSell(bookInfo bi) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_WANT_SELL,bi);
		serverRe = sendMessage(mm);
		
		if (serverRe.getCmd() == MessageType.SERVER_OPERATION_SUCC) {
			return  true;
		}
		else {
			return false;
		}
		
	}

	public static Vector<bookInfo> showNeedBook() {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.SHOW_NEED_BOOK,null);
		serverRe = sendMessage(mm);
		return (Vector<bookInfo>) serverRe.getOb();
	}

	public static void delCart(String book_id, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+book_id; //cardNo%%book_id
		MyMessage mm = new MyMessage(k.MessageType.DEL_CART, cardNo);
		serverRe = sendMessage(mm);
	}

	public static boolean buyOneBook(String price, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+price; //cardNo%%price
		MyMessage mm = new MyMessage(k.MessageType.BUY_ONE_BOOK, cardNo);
		serverRe = sendMessage(mm);
		if (serverRe.getCmd() == k.MessageType.SERVER_OPERATION_SUCC ) {
			return true;
		}
		else {
			return false;
		}
	}
}
