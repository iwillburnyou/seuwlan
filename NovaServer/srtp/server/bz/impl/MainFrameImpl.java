package srtp.server.bz.impl;

import java.util.Collection;
import java.util.Vector;

import src.srtp.Client.view.Page_detail;
import srtp.server.dao.DbHelper;

import k.MessageType;
import k.User;
import k.bookInfo;

public class MainFrameImpl implements MessageType {

	public static Vector<bookInfo> showGuessBook(User ob) {
		// TODO Auto-generated method stub
		Vector<String> strVector = new Vector<String>();
		Vector<Vector> vec;
		Vector<Vector> temp;
		String sql = "select bookid from tblGuess where userid='"
				+ ob.getCardNo() + "'";
		vec = DbHelper.executeQuery(sql);
		Vector<bookInfo> vb = new Vector<bookInfo>();
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='" + vec.get(i).get(0)
					+ "'";
			vb.add(new bookInfo((Vector) DbHelper.executeQuery(sql)
					.firstElement()));
		}

		return vb;

	}

	public static Vector<bookInfo> showHot() {
		// TODO Auto-generated method stub
		Vector<String> strVector = new Vector<String>();
		Vector<Vector> vec;
		Vector<Vector> temp;
		String sql = "select bookid from tblHotBook";
		vec = DbHelper.executeQuery(sql);
		Vector<bookInfo> vb = new Vector<bookInfo>();
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='" + vec.get(i).get(0)
					+ "'";
			vb.add(new bookInfo((Vector) DbHelper.executeQuery(sql)
					.firstElement()));
		}

		return vb;

	}

	public static Vector<bookInfo> initHealth() {
		// TODO Auto-generated method stub

		Vector<Vector> vec;
		String sql = "select bookid,class from tblLiving";
		vec = DbHelper.executeQuery(sql);
		Vector<bookInfo> vb = new Vector<bookInfo>();
		bookInfo bi;
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='" + vec.get(i).get(0)
					+ "'";
			// vb.add( new bookInfo((Vector)
			// DbHelper.executeQuery(sql).firstElement()) ) ;
			bi = new bookInfo((Vector) DbHelper.executeQuery(sql)
					.firstElement());
			bi.setIntClass(Integer.parseInt((String) vec.get(i).get(1)));
			vb.add(bi);
		}

		return vb;

	}

	public static Vector<bookInfo> initEntertainment() {
		// TODO Auto-generated method stub
		Vector<Vector> vec;
		String sql = "select bookid,class from tblEntertainment";
		vec = DbHelper.executeQuery(sql);
		Vector<bookInfo> vb = new Vector<bookInfo>();
		bookInfo bi;
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='" + vec.get(i).get(0)
					+ "'";
			// vb.add( new bookInfo((Vector)
			// DbHelper.executeQuery(sql).firstElement()) ) ;
			bi = new bookInfo((Vector) DbHelper.executeQuery(sql)
					.firstElement());
			bi.setIntClass(Integer.parseInt((String) vec.get(i).get(1)));
			vb.add(bi);
		}

		return vb;
	}

	public static Vector<bookInfo> intAcademic() {
		// TODO Auto-generated method stub
		Vector<Vector> vec;
		String sql = "select bookid,class from tblAcademic";
		vec = DbHelper.executeQuery(sql);
		Vector<bookInfo> vb = new Vector<bookInfo>();
		bookInfo bi;
		for (int i = 0; i < vec.size(); i++) {
			sql = "select * from book where book_id='" + vec.get(i).get(0)
					+ "'";
			// vb.add( new bookInfo((Vector)
			// DbHelper.executeQuery(sql).firstElement()) ) ;
			bi = new bookInfo((Vector) DbHelper.executeQuery(sql)
					.firstElement());
			bi.setIntClass(Integer.parseInt((String) vec.get(i).get(1)));
			vb.add(bi);
		}

		return vb;
	}

	public static void addCart(String ob) {
		// TODO Auto-generated method stu
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String bookID = ob.substring(index + 2);
		if (cardNo == null || bookID == null) {
			return;
		}
		String sql;
		sql = "select * from user_willbuy where u_cardNo='" + cardNo + "'"
				+ " and book_willbuy='" + bookID + "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() != 0) {
			return;
		}
		sql = "insert into user_willbuy (u_cardNo,book_willbuy)values ('"
				+ cardNo + "','" + bookID + "')";

		DbHelper.executeUpdate(sql);
	}

	public static void addCollection(String ob) {
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
		if (vec.size() != 0) {
			return;
		}
		sql = "insert into user_collection (u_cardNo,book_collection)values ('"
				+ cardNo + "','" + bookID + "')";

		DbHelper.executeUpdate(sql);
	}

	public static void initDetail(Page_detail ob) {
		// TODO Auto-generated method stub
		String sql;
		sql = "select * from user_collection where u_cardNo='" + ob.getCardNo()
				+ "'" + " and book_collection='" + ob.getBi().getBook_id()
				+ "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0)
			ob.setCollected(false);
		else
			ob.setCollected(true);
		sql = "select * from user_willbuy where u_cardNo='" + ob.getCardNo()
				+ "'" + " and book_willbuy='" + ob.getBi().getBook_id()
				+ "'";
	vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0)
			ob.setInCart(false);
		else
			ob.setInCart(true);
		

	}

}
