package src.srtp.Client.bz.impl;

import java.awt.print.Book;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import k.MyMessage;
import k.User;
import k.bookInfo;

public class MylibImpl extends CommonImpl {
	public MylibImpl() throws UnknownHostException, IOException  {
		super();	
	}

	public static Vector<bookInfo> showCollection(User u) {
		// TODO Auto-generated method stub


		MyMessage mm = new MyMessage(k.MessageType.SHOW_COLLECTION,u);
		
		serverRe = sendMessage(mm);
		Vector<Vector> vec = (Vector<Vector>) serverRe.getOb();
		Vector<bookInfo> bv = new Vector<bookInfo>();
		//System.out.println(vec);
		for(int i=0; i<vec.size();i++) {
			bv.add(new bookInfo( vec.get(i) ) );
			//System.out.println(bv.get(i));
		}
		
		return bv;
	}

	public static Vector<bookInfo> showHaveBuy(User u) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.SHOW_HAVE_BUY,u);
		
		serverRe = sendMessage(mm);
		Vector<Vector> vec = (Vector<Vector>) serverRe.getOb();
		Vector<bookInfo> bv = new Vector<bookInfo>();
		//System.out.println(vec);
		for(int i=0; i<vec.size();i++) {
			bv.add(new bookInfo( vec.get(i) ) );
			//System.out.println(bv.get(i));
		}
		
		return bv;
	
	}

	public static Vector<bookInfo> showWillSell(User u) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.SHOW_WILL_SELL,u);
		
		serverRe = sendMessage(mm);
		Vector<Vector> vec = (Vector<Vector>) serverRe.getOb();
		Vector<bookInfo> bv = new Vector<bookInfo>();
		//System.out.println(vec);
		for(int i=0; i<vec.size();i++) {
			bv.add(new bookInfo( vec.get(i) ) );
			//System.out.println(bv.get(i));
		}
		
		return bv;
	}

	public static Vector<bookInfo> showHaveSell(User u) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.SHOW_HAVE_SELL,u);
		
		serverRe = sendMessage(mm);
		Vector<Vector> vec = (Vector<Vector>) serverRe.getOb();
		Vector<bookInfo> bv = new Vector<bookInfo>();
		//System.out.println(vec);
		for(int i=0; i<vec.size();i++) {
			bv.add(new bookInfo( vec.get(i) ) );
			//System.out.println(bv.get(i));
		}
		
		return bv;
	}

	public static Vector<bookInfo> showWillBuy(User u) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.SHOW_WILL_BUY,u);
		
		serverRe = sendMessage(mm);
		Vector<Vector> vec = (Vector<Vector>) serverRe.getOb();
		Vector<bookInfo> bv = new Vector<bookInfo>();
		//System.out.println(vec);
		for(int i=0; i<vec.size();i++) {
			bv.add(new bookInfo( vec.get(i) ) );
			//System.out.println(bv.get(i));
		}
		
		return bv;
	}

	public static void DeleteHaveBuy(String book_id, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+book_id; //cardNo%%book_id
		MyMessage mm = new MyMessage(k.MessageType.DEL_HAVEBUY, cardNo);
		serverRe = sendMessage(mm);
		
	}

	public static void DeleteHaveSell(String book_id, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+book_id; //cardNo%%book_id
		MyMessage mm = new MyMessage(k.MessageType.DEL_HAVESELL, cardNo);
		serverRe = sendMessage(mm);
		
	}

	public static void DelWillSell(String book_id, String cardNo) {
		// TODO Auto-generated method stub
		cardNo +="%%"+book_id; //cardNo%%book_id
		MyMessage mm = new MyMessage(k.MessageType.DEL_WILLSELL, cardNo);
		serverRe = sendMessage(mm);
	}
	
	
}
