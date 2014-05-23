package src.srtp.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Vector;

import src.srtp.Client.view.Page_detail;

import k.MyMessage;
import k.User;
import k.bookInfo;

public class MainFImpl extends CommonImpl{

	public MainFImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Vector<bookInfo> showGuessBook(User u2) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.SHOW_GUESSBOOK, u2);
		serverRe = sendMessage(mm);
		
		return (Vector<bookInfo>) serverRe.getOb();
	}

	public static Vector<bookInfo> initGuess(String cardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Vector<bookInfo> showHot() {
		// TODO Auto-generated method stub
		
		MyMessage mm = new MyMessage(k.MessageType.SHOW_HOT, null);
		serverRe = sendMessage(mm);
		
		return (Vector<bookInfo>) serverRe.getOb();
	}

	public static Vector<bookInfo> initHealth() {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.INIT_HEALTH, null);
		serverRe = sendMessage(mm);
		
		return (Vector<bookInfo>) serverRe.getOb();
	}
	//initEntertainment
	public static Vector<bookInfo> initEntertainment() {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.INIT_ENTERTAINMENT, null);
		serverRe = sendMessage(mm);
		
		return (Vector<bookInfo>) serverRe.getOb();
	}

	public static Vector<bookInfo> initAcademic() {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.INIT_ACADEMIC, null);
		serverRe = sendMessage(mm);
		
		return (Vector<bookInfo>) serverRe.getOb();
	
	}
	/**
	 * tip: format as cardNo%%bookID
	 * @param currentHotIndex
	 * @param cardNo
	 */
	public static void AddCart(String currentHotIndex, String cardNo) {
		// TODO Auto-generated method stub
	
		cardNo +="%%"+currentHotIndex;
		MyMessage mm = new MyMessage(k.MessageType.ADD_CART, cardNo);
		serverRe = sendMessage(mm);
	}

	public static void AddCollection(String book_id, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+book_id;
		MyMessage mm = new MyMessage(k.MessageType.ADD_COLLECTION, cardNo);
		serverRe = sendMessage(mm);
	}

	public static void initDetail(Page_detail page_detail) {
		// TODO Auto-generated method stub
		if (page_detail.getCardNo()==null || page_detail.getBi().getBook_id() == null) {
			System.out.println("出现信息不完全的detail界面~\n"+page_detail.getCardNo()+page_detail.getBi().getBook_id());
			return ;
			
		}
		MyMessage mm = new MyMessage(k.MessageType.INIT_DETAIL, page_detail);
		serverRe = sendMessage(mm);
		Page_detail serverReOb = (Page_detail) serverRe.getOb();
		//System.out.println("serverRe"+serverReOb.isCollected() );
		page_detail.setCollected(serverReOb.isCollected());
		page_detail.setInCart(serverReOb.isInCart());
	}

	public static void DeleteCollection(String book_id, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+book_id; //cardNo%%book_id
		MyMessage mm = new MyMessage(k.MessageType.DELETE_COLLECTION, cardNo);
		serverRe = sendMessage(mm);
		
	}

//	public static void DelCart(String book_id, String cardNo) {
//		// TODO Auto-generated method stub
//		cardNo +="%%"+book_id; //cardNo%%book_id
//		MyMessage mm = new MyMessage(k.MessageType.DEL_CART, cardNo);
//		serverRe = sendMessage(mm);
//	}

}
