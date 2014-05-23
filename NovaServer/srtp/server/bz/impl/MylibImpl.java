package srtp.server.bz.impl;

import java.awt.print.Book;
import java.util.Vector;

import srtp.server.dao.DbHelper;
import k.MessageType;
import k.User;
import k.bookInfo;

public class MylibImpl implements MessageType{

	public static Vector<Vector> showCollection(User ob) {
		// TODO Auto-generated method stub
		String sql = "select * from user_collection where u_cardNo='"+ob.getCardNo()+"'";

		Vector<Vector> vec = DbHelper.executeQuery(sql);
		
		Vector<Vector> vecBook = new Vector<Vector>();
//		while(vec.size()!=0){
//			sql = "select * from book where book_id='"+vec.get(i)+"'";
//			 vecBook.add(DbHelper.executeQuery(sql) ) ;
//			 
//		}
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='"+vec.get(i).get(2)+"'";
			 vecBook.add((Vector) DbHelper.executeQuery(sql).firstElement() ) ;
		}
		System.out.println(vecBook);
		
		return vecBook;
	}

	public static Object showHaveBuy(User ob) {
		// TODO Auto-generated method stub
		String sql = "select * from user_havebuy where u_cardNo='"+ob.getCardNo()+"'";

		Vector<Vector> vec = DbHelper.executeQuery(sql);
		
		Vector<Vector> vecBook = new Vector<Vector>();
//		while(vec.size()!=0){
//			sql = "select * from book where book_id='"+vec.get(i)+"'";
//			 vecBook.add(DbHelper.executeQuery(sql) ) ;
//			 
//		}
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='"+vec.get(i).get(2)+"'";
			 vecBook.add((Vector) DbHelper.executeQuery(sql).firstElement() ) ;
		}
		System.out.println(vecBook);
		
		return vecBook;
	}

	public static Object showWillSell(User ob) {
		// TODO Auto-generated method stub
		String sql = "select * from user_willsell where u_cardNo='"+ob.getCardNo()+"'";

		Vector<Vector> vec = DbHelper.executeQuery(sql);
		
		Vector<Vector> vecBook = new Vector<Vector>();
//		while(vec.size()!=0){
//			sql = "select * from book where book_id='"+vec.get(i)+"'";
//			 vecBook.add(DbHelper.executeQuery(sql) ) ;
//			 
//		}
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='"+vec.get(i).get(2)+"'";
			 vecBook.add((Vector) DbHelper.executeQuery(sql).firstElement() ) ;
		}
		System.out.println(vecBook);
		
		return vecBook;
		
		
	}

	public static Object showHaveSell(User ob) {
		// TODO Auto-generated method stub
		String sql = "select * from user_havesell where u_cardNo='"+ob.getCardNo()+"'";

		Vector<Vector> vec = DbHelper.executeQuery(sql);
		
		Vector<Vector> vecBook = new Vector<Vector>();
//		while(vec.size()!=0){
//			sql = "select * from book where book_id='"+vec.get(i)+"'";
//			 vecBook.add(DbHelper.executeQuery(sql) ) ;
//			 
//		}
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='"+vec.get(i).get(2)+"'";
			 vecBook.add((Vector) DbHelper.executeQuery(sql).firstElement() ) ;
		}
		System.out.println(vecBook);
		
		return vecBook;
	}

	public static Object showWillBuy(User ob) {
		// TODO Auto-generated method stub
		String sql = "select * from user_willbuy where u_cardNo='"+ob.getCardNo()+"'";

		Vector<Vector> vec = DbHelper.executeQuery(sql);
		
		Vector<Vector> vecBook = new Vector<Vector>();
//		while(vec.size()!=0){
//			sql = "select * from book where book_id='"+vec.get(i)+"'";
//			 vecBook.add(DbHelper.executeQuery(sql) ) ;
//			 
//		}
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='"+vec.get(i).get(2)+"'";
			 vecBook.add((Vector) DbHelper.executeQuery(sql).firstElement() ) ;
		}
		System.out.println(vecBook);
		
		return vecBook;
	}

	public static void delCollection(String ob) {
		// TODO Auto-generated method stub		
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String bookID = ob.substring(index + 2);
		if (cardNo == null || bookID == null) {
			return;
		}
		String sql;
		sql = "select * from user_collection where u_cardNo='" + cardNo + "'"
				+ " and book_collection='" + bookID + "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0) {
			return;
		}
		sql = "delete from user_collection where u_cardNo = '"
				+ cardNo + "' and book_collection = '" + bookID + "'";

		DbHelper.executeUpdate(sql);
		
	}

	public static void delHaveBuy(String ob) {
		// TODO Auto-generated method stub
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String bookID = ob.substring(index + 2);
		if (cardNo == null || bookID == null) {
			return;
		}
		String sql;
		sql = "select * from user_havebuy where u_cardNo='" + cardNo + "'"
				+ " and book_havebuy ='" + bookID + "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0) {
			return;
		}
		sql = "delete from user_havebuy where u_cardNo = '"
				+ cardNo + "' and book_havebuy = '" + bookID + "'";

		DbHelper.executeUpdate(sql);
	}

	public static void delHaveSell(String ob) {
		// TODO Auto-generated method stub
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String bookID = ob.substring(index + 2);
		if (cardNo == null || bookID == null) {
			return;
		}
		String sql;
		sql = "select * from user_havesell where u_cardNo='" + cardNo + "'"
				+ " and book_havesell ='" + bookID + "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0) {
			return;
		}
		sql = "delete from user_havesell where u_cardNo = '"
				+ cardNo + "' and book_havesell = '" + bookID + "'";

		DbHelper.executeUpdate(sql);
	}

	public static void delWillSell(String ob) {
		// TODO Auto-generated method stub
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String bookID = ob.substring(index + 2);
		if (cardNo == null || bookID == null) {
			return;
		}
		String sql;
		sql = "select * from user_willsell where u_cardNo='" + cardNo + "'"
				+ " and book_willsell ='" + bookID + "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0) {
			return;
		}
		sql = "delete from user_willsell where u_cardNo = '"
				+ cardNo + "' and book_willsell = '" + bookID + "'";

		DbHelper.executeUpdate(sql);
		
	}


	
}
