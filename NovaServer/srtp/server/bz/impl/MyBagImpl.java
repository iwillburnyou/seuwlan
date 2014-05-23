package srtp.server.bz.impl;

import java.util.Vector;

import srtp.server.dao.DbHelper;
import k.MessageType;
import k.bookInfo;

public class MyBagImpl implements MessageType{

	public static boolean addWantBuy(bookInfo ob) {
		// TODO Auto-generated method stub
		String sql;
		sql = "select * from book where book_name='"+ob.getBook_name()+"'"; //weak condition
		Vector<Vector> vector = DbHelper.executeQuery(sql);
		if (vector.size()!=0) {
			return false;
		}
		sql = "insert into book (book_name,author,press,num_left,num_sell)values ('"
				+ob.getBook_name()+"','"
				+ob.getAuthor()+"','"
				+ob.getPress()+"',0,0"
				+")";
		DbHelper.executeUpdate(sql);
//		String sql="insert into tblStudentInfo (StudentNo,StuName,Gender,Grade,Department,Major,IDNumber)values ('"
//				+ob.StudentNo+"','"
//				+ob.Name+"','"
//				+ob.Gender+"','"
//				+ob.Grade+"','"
//				+ob.Department+"','"
//				+ob.Major+"','"
//				+ob.ID+"')";
//		
//		DbHelper.executeUpdate(sql);
		sql = "select * from book where book_name='"+ob.getBook_name()+"'"; //weak condition
		vector = DbHelper.executeQuery(sql);
		sql ="update book set book_id='"+vector.get(0).get(0)+"' where book_name='"+ob.getBook_name()+"'";
		DbHelper.executeUpdate(sql);
		return true;
	}

	public static boolean addWantSell(bookInfo ob) {
		// TODO Auto-generated method stub
		String sql;
		sql = "select * from book where book_name='"+ob.getBook_name()+"'"; //weak condition
		Vector<Vector> vector = DbHelper.executeQuery(sql);
		if (vector.size()==0) {
			return false;
		}
		sql = "select num_left from book where book_name='"+ob.getBook_name()+"'"; //weak condition
		vector = DbHelper.executeQuery(sql);
		int left = Integer.parseInt((String) vector.get(0).get(0)) ;
		left++;
		sql ="update book set num_left="+left+" where book_name='"+ob.getBook_name()+"'";
		DbHelper.executeUpdate(sql);
		return true;
	}

	public static Vector<bookInfo> showNeedBook() {
		// TODO Auto-generated method stub
		String sql;
		sql ="select book_id from tblNeedBook";
		Vector<Vector> vector = DbHelper.executeQuery(sql);
		Vector<bookInfo> vb = new Vector<bookInfo>();
		for (int i = 0; i < vector.size(); i++) {
			sql = "select * from book where book_id='"+vector.get(i).get(0)+"'"; //weak condition
			Vector<Vector> vectorBook = DbHelper.executeQuery(sql);
			vb.add(new bookInfo(vectorBook.get(0)));
		}
		
		
		
		return vb;
	}

	public static void delCart(String ob) {
		// TODO Auto-generated method stub
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String bookID = ob.substring(index + 2);
		if (cardNo == null || bookID == null) {
			return;
		}
		String sql;
		sql = "select * from user_willbuy where u_cardNo='" + cardNo + "'"
				+ " and book_willbuy ='" + bookID + "'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if (vec.size() == 0) {
			return;
		}
		sql = "delete from user_willbuy where u_cardNo = '"
				+ cardNo + "' and book_willbuy = '" + bookID + "'";

		DbHelper.executeUpdate(sql);
	}

	public static boolean buyOneBook(String ob) {
		// TODO Auto-generated method stub
		int index = ob.indexOf("%%");
		String cardNo = ob.substring(0, index);
		String price = ob.substring(index + 2);
		String sql;
		sql = "select u_accounts from userInfo where u_cardNo = '"
				+ cardNo + "'";
		Vector<Vector> temp = DbHelper.executeQuery(sql);
		int accounts = Integer.parseInt((String) temp.get(0).get(0));
	//	System.out.println(accounts);
		accounts -=Integer.parseInt(price);
		if (accounts< 0) {
			return false;
		}
		String tempAccounts = String.valueOf(accounts);
		sql = "update userInfo set u_accounts = "+tempAccounts+" where u_cardNo = '"
				+ cardNo + "'";

		DbHelper.executeUpdate(sql);
		return true;
	}

}
